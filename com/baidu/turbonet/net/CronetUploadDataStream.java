package com.baidu.turbonet.net;

import android.util.Log;
import com.baidu.turbonet.base.annotations.CalledByNative;
import com.baidu.turbonet.base.annotations.JNINamespace;
import com.baidu.turbonet.base.annotations.NativeClassQualifiedName;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
/* JADX INFO: Access modifiers changed from: package-private */
@JNINamespace
/* loaded from: classes6.dex */
public final class CronetUploadDataStream implements UploadDataSink {
    private final Executor mExecutor;
    private long mLength;
    private Runnable mOnDestroyedCallbackForTesting;
    private long mRemainingLength;
    private final UploadDataProvider oPo;
    private final CronetUrlRequest oPp;
    private final Runnable mReadTask = new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (CronetUploadDataStream.this.mLock) {
                if (CronetUploadDataStream.this.mUploadDataStreamAdapter != 0) {
                    CronetUploadDataStream.this.a(UserCallback.NOT_IN_CALLBACK);
                    if (CronetUploadDataStream.this.mByteBuffer == null) {
                        throw new IllegalStateException("Unexpected readData call. Buffer is null");
                    }
                    CronetUploadDataStream.this.oPq = UserCallback.READ;
                    try {
                        CronetUploadDataStream.this.oPo.a(CronetUploadDataStream.this, CronetUploadDataStream.this.mByteBuffer);
                    } catch (Exception e) {
                        CronetUploadDataStream.this.onError(e);
                    }
                }
            }
        }
    };
    private ByteBuffer mByteBuffer = null;
    private final Object mLock = new Object();
    @GuardedBy("mLock")
    private long mUploadDataStreamAdapter = 0;
    @GuardedBy("mLock")
    private UserCallback oPq = UserCallback.NOT_IN_CALLBACK;
    @GuardedBy("mLock")
    private boolean mDestroyAdapterPostponed = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public enum UserCallback {
        READ,
        REWIND,
        GET_LENGTH,
        NOT_IN_CALLBACK
    }

    private native long nativeAttachUploadDataToRequest(long j, long j2);

    private native long nativeCreateAdapterForTesting();

    private native long nativeCreateUploadDataStreamForTesting(long j, long j2);

    @NativeClassQualifiedName
    private static native void nativeDestroy(long j);

    @NativeClassQualifiedName
    private native void nativeOnReadSucceeded(long j, int i, boolean z);

    @NativeClassQualifiedName
    private native void nativeOnRewindSucceeded(long j);

    public CronetUploadDataStream(UploadDataProvider uploadDataProvider, Executor executor, CronetUrlRequest cronetUrlRequest) {
        this.mExecutor = executor;
        this.oPo = uploadDataProvider;
        this.oPp = cronetUrlRequest;
    }

    @CalledByNative
    void readData(ByteBuffer byteBuffer) {
        this.mByteBuffer = byteBuffer;
        postTaskToExecutor(this.mReadTask);
    }

    @CalledByNative
    void rewind() {
        postTaskToExecutor(new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUploadDataStream.this.mLock) {
                    if (CronetUploadDataStream.this.mUploadDataStreamAdapter != 0) {
                        CronetUploadDataStream.this.a(UserCallback.NOT_IN_CALLBACK);
                        CronetUploadDataStream.this.oPq = UserCallback.REWIND;
                        try {
                            CronetUploadDataStream.this.oPo.a(CronetUploadDataStream.this);
                        } catch (Exception e) {
                            CronetUploadDataStream.this.onError(e);
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mLock")
    public void a(UserCallback userCallback) {
        if (this.oPq != userCallback) {
            throw new IllegalStateException("Expected " + userCallback + ", but was " + this.oPq);
        }
    }

    @CalledByNative
    void onUploadDataStreamDestroyed() {
        destroyAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(Throwable th) {
        synchronized (this.mLock) {
            if (this.oPq == UserCallback.NOT_IN_CALLBACK) {
                throw new IllegalStateException("There is no read or rewind or length check in progress.");
            }
            this.oPq = UserCallback.NOT_IN_CALLBACK;
            this.mByteBuffer = null;
            destroyAdapterIfPostponed();
        }
        this.oPp.onUploadException(th);
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void onReadSucceeded(boolean z) {
        synchronized (this.mLock) {
            a(UserCallback.READ);
            if (z && this.mLength >= 0) {
                throw new IllegalArgumentException("Non-chunked upload can't have last chunk");
            }
            int position = this.mByteBuffer.position();
            this.mRemainingLength -= position;
            if (this.mRemainingLength < 0 && this.mLength >= 0) {
                throw new IllegalArgumentException(String.format("Read upload data length %d exceeds expected length %d", Long.valueOf(this.mLength - this.mRemainingLength), Long.valueOf(this.mLength)));
            }
            this.mByteBuffer = null;
            this.oPq = UserCallback.NOT_IN_CALLBACK;
            destroyAdapterIfPostponed();
            if (this.mUploadDataStreamAdapter != 0) {
                nativeOnReadSucceeded(this.mUploadDataStreamAdapter, position, z);
            }
        }
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void onRewindSucceeded() {
        synchronized (this.mLock) {
            a(UserCallback.REWIND);
            this.oPq = UserCallback.NOT_IN_CALLBACK;
            this.mRemainingLength = this.mLength;
            if (this.mUploadDataStreamAdapter != 0) {
                nativeOnRewindSucceeded(this.mUploadDataStreamAdapter);
            }
        }
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void z(Exception exc) {
        synchronized (this.mLock) {
            a(UserCallback.REWIND);
            onError(exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void postTaskToExecutor(Runnable runnable) {
        try {
            this.mExecutor.execute(runnable);
        } catch (Throwable th) {
            this.oPp.onUploadException(th);
        }
    }

    private void destroyAdapter() {
        synchronized (this.mLock) {
            if (this.oPq == UserCallback.READ) {
                this.mDestroyAdapterPostponed = true;
            } else if (this.mUploadDataStreamAdapter != 0) {
                nativeDestroy(this.mUploadDataStreamAdapter);
                this.mUploadDataStreamAdapter = 0L;
                if (this.mOnDestroyedCallbackForTesting != null) {
                    this.mOnDestroyedCallbackForTesting.run();
                }
                postTaskToExecutor(new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            CronetUploadDataStream.this.oPo.close();
                        } catch (IOException e) {
                            Log.e(aegon.chrome.net.impl.CronetUploadDataStream.TAG, "Exception thrown when closing", e);
                        }
                    }
                });
            }
        }
    }

    private void destroyAdapterIfPostponed() {
        synchronized (this.mLock) {
            if (this.oPq == UserCallback.READ) {
                throw new IllegalStateException("Method should not be called when read has not completed.");
            }
            if (this.mDestroyAdapterPostponed) {
                destroyAdapter();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initializeWithRequest() {
        synchronized (this.mLock) {
            this.oPq = UserCallback.GET_LENGTH;
        }
        try {
            this.mLength = this.oPo.getLength();
            this.mRemainingLength = this.mLength;
        } catch (Throwable th) {
            onError(th);
        }
        synchronized (this.mLock) {
            this.oPq = UserCallback.NOT_IN_CALLBACK;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void attachNativeAdapterToRequest(long j) {
        synchronized (this.mLock) {
            this.mUploadDataStreamAdapter = nativeAttachUploadDataToRequest(j, this.mLength);
        }
    }
}
