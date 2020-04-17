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
/* loaded from: classes.dex */
public final class CronetUploadDataStream implements UploadDataSink {
    private Runnable lIK;
    private final UploadDataProvider lIV;
    private final CronetUrlRequest lIW;
    private long lIX;
    private long lIY;
    private final Executor mExecutor;
    private final Runnable lIZ = new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (CronetUploadDataStream.this.mLock) {
                if (CronetUploadDataStream.this.lJa != 0) {
                    CronetUploadDataStream.this.a(UserCallback.NOT_IN_CALLBACK);
                    if (CronetUploadDataStream.this.mByteBuffer == null) {
                        throw new IllegalStateException("Unexpected readData call. Buffer is null");
                    }
                    CronetUploadDataStream.this.lJb = UserCallback.READ;
                    try {
                        CronetUploadDataStream.this.lIV.a(CronetUploadDataStream.this, CronetUploadDataStream.this.mByteBuffer);
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
    private long lJa = 0;
    @GuardedBy("mLock")
    private UserCallback lJb = UserCallback.NOT_IN_CALLBACK;
    @GuardedBy("mLock")
    private boolean lJc = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
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
        this.lIV = uploadDataProvider;
        this.lIW = cronetUrlRequest;
    }

    @CalledByNative
    void readData(ByteBuffer byteBuffer) {
        this.mByteBuffer = byteBuffer;
        A(this.lIZ);
    }

    @CalledByNative
    void rewind() {
        A(new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUploadDataStream.this.mLock) {
                    if (CronetUploadDataStream.this.lJa != 0) {
                        CronetUploadDataStream.this.a(UserCallback.NOT_IN_CALLBACK);
                        CronetUploadDataStream.this.lJb = UserCallback.REWIND;
                        try {
                            CronetUploadDataStream.this.lIV.a(CronetUploadDataStream.this);
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
        if (this.lJb != userCallback) {
            throw new IllegalStateException("Expected " + userCallback + ", but was " + this.lJb);
        }
    }

    @CalledByNative
    void onUploadDataStreamDestroyed() {
        diT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(Throwable th) {
        synchronized (this.mLock) {
            if (this.lJb == UserCallback.NOT_IN_CALLBACK) {
                throw new IllegalStateException("There is no read or rewind or length check in progress.");
            }
            this.lJb = UserCallback.NOT_IN_CALLBACK;
            this.mByteBuffer = null;
            diU();
        }
        this.lIW.t(th);
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void vh(boolean z) {
        synchronized (this.mLock) {
            a(UserCallback.READ);
            if (z && this.lIX >= 0) {
                throw new IllegalArgumentException("Non-chunked upload can't have last chunk");
            }
            int position = this.mByteBuffer.position();
            this.lIY -= position;
            if (this.lIY < 0 && this.lIX >= 0) {
                throw new IllegalArgumentException(String.format("Read upload data length %d exceeds expected length %d", Long.valueOf(this.lIX - this.lIY), Long.valueOf(this.lIX)));
            }
            this.mByteBuffer = null;
            this.lJb = UserCallback.NOT_IN_CALLBACK;
            diU();
            if (this.lJa != 0) {
                nativeOnReadSucceeded(this.lJa, position, z);
            }
        }
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void diS() {
        synchronized (this.mLock) {
            a(UserCallback.REWIND);
            this.lJb = UserCallback.NOT_IN_CALLBACK;
            this.lIY = this.lIX;
            if (this.lJa != 0) {
                nativeOnRewindSucceeded(this.lJa);
            }
        }
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void n(Exception exc) {
        synchronized (this.mLock) {
            a(UserCallback.REWIND);
            onError(exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(Runnable runnable) {
        try {
            this.mExecutor.execute(runnable);
        } catch (Throwable th) {
            this.lIW.t(th);
        }
    }

    private void diT() {
        synchronized (this.mLock) {
            if (this.lJb == UserCallback.READ) {
                this.lJc = true;
            } else if (this.lJa != 0) {
                nativeDestroy(this.lJa);
                this.lJa = 0L;
                if (this.lIK != null) {
                    this.lIK.run();
                }
                A(new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            CronetUploadDataStream.this.lIV.close();
                        } catch (IOException e) {
                            Log.e("CronetUploadDataStream", "Exception thrown when closing", e);
                        }
                    }
                });
            }
        }
    }

    private void diU() {
        synchronized (this.mLock) {
            if (this.lJb == UserCallback.READ) {
                throw new IllegalStateException("Method should not be called when read has not completed.");
            }
            if (this.lJc) {
                diT();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void diV() {
        synchronized (this.mLock) {
            this.lJb = UserCallback.GET_LENGTH;
        }
        try {
            this.lIX = this.lIV.getLength();
            this.lIY = this.lIX;
        } catch (Throwable th) {
            onError(th);
        }
        synchronized (this.mLock) {
            this.lJb = UserCallback.NOT_IN_CALLBACK;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fx(long j) {
        synchronized (this.mLock) {
            this.lJa = nativeAttachUploadDataToRequest(j, this.lIX);
        }
    }
}
