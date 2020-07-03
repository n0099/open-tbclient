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
    private final Executor mExecutor;
    private Runnable mze;
    private final UploadDataProvider mzp;
    private final CronetUrlRequest mzq;
    private long mzr;
    private long mzs;
    private final Runnable mzt = new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (CronetUploadDataStream.this.mLock) {
                if (CronetUploadDataStream.this.mzu != 0) {
                    CronetUploadDataStream.this.a(UserCallback.NOT_IN_CALLBACK);
                    if (CronetUploadDataStream.this.mByteBuffer == null) {
                        throw new IllegalStateException("Unexpected readData call. Buffer is null");
                    }
                    CronetUploadDataStream.this.mzv = UserCallback.READ;
                    try {
                        CronetUploadDataStream.this.mzp.a(CronetUploadDataStream.this, CronetUploadDataStream.this.mByteBuffer);
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
    private long mzu = 0;
    @GuardedBy("mLock")
    private UserCallback mzv = UserCallback.NOT_IN_CALLBACK;
    @GuardedBy("mLock")
    private boolean mzw = false;

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
        this.mzp = uploadDataProvider;
        this.mzq = cronetUrlRequest;
    }

    @CalledByNative
    void readData(ByteBuffer byteBuffer) {
        this.mByteBuffer = byteBuffer;
        C(this.mzt);
    }

    @CalledByNative
    void rewind() {
        C(new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUploadDataStream.this.mLock) {
                    if (CronetUploadDataStream.this.mzu != 0) {
                        CronetUploadDataStream.this.a(UserCallback.NOT_IN_CALLBACK);
                        CronetUploadDataStream.this.mzv = UserCallback.REWIND;
                        try {
                            CronetUploadDataStream.this.mzp.a(CronetUploadDataStream.this);
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
        if (this.mzv != userCallback) {
            throw new IllegalStateException("Expected " + userCallback + ", but was " + this.mzv);
        }
    }

    @CalledByNative
    void onUploadDataStreamDestroyed() {
        dva();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(Throwable th) {
        synchronized (this.mLock) {
            if (this.mzv == UserCallback.NOT_IN_CALLBACK) {
                throw new IllegalStateException("There is no read or rewind or length check in progress.");
            }
            this.mzv = UserCallback.NOT_IN_CALLBACK;
            this.mByteBuffer = null;
            dvb();
        }
        this.mzq.u(th);
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void wd(boolean z) {
        synchronized (this.mLock) {
            a(UserCallback.READ);
            if (z && this.mzr >= 0) {
                throw new IllegalArgumentException("Non-chunked upload can't have last chunk");
            }
            int position = this.mByteBuffer.position();
            this.mzs -= position;
            if (this.mzs < 0 && this.mzr >= 0) {
                throw new IllegalArgumentException(String.format("Read upload data length %d exceeds expected length %d", Long.valueOf(this.mzr - this.mzs), Long.valueOf(this.mzr)));
            }
            this.mByteBuffer = null;
            this.mzv = UserCallback.NOT_IN_CALLBACK;
            dvb();
            if (this.mzu != 0) {
                nativeOnReadSucceeded(this.mzu, position, z);
            }
        }
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void duZ() {
        synchronized (this.mLock) {
            a(UserCallback.REWIND);
            this.mzv = UserCallback.NOT_IN_CALLBACK;
            this.mzs = this.mzr;
            if (this.mzu != 0) {
                nativeOnRewindSucceeded(this.mzu);
            }
        }
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void v(Exception exc) {
        synchronized (this.mLock) {
            a(UserCallback.REWIND);
            onError(exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(Runnable runnable) {
        try {
            this.mExecutor.execute(runnable);
        } catch (Throwable th) {
            this.mzq.u(th);
        }
    }

    private void dva() {
        synchronized (this.mLock) {
            if (this.mzv == UserCallback.READ) {
                this.mzw = true;
            } else if (this.mzu != 0) {
                nativeDestroy(this.mzu);
                this.mzu = 0L;
                if (this.mze != null) {
                    this.mze.run();
                }
                C(new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            CronetUploadDataStream.this.mzp.close();
                        } catch (IOException e) {
                            Log.e("CronetUploadDataStream", "Exception thrown when closing", e);
                        }
                    }
                });
            }
        }
    }

    private void dvb() {
        synchronized (this.mLock) {
            if (this.mzv == UserCallback.READ) {
                throw new IllegalStateException("Method should not be called when read has not completed.");
            }
            if (this.mzw) {
                dva();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dvc() {
        synchronized (this.mLock) {
            this.mzv = UserCallback.GET_LENGTH;
        }
        try {
            this.mzr = this.mzp.getLength();
            this.mzs = this.mzr;
        } catch (Throwable th) {
            onError(th);
        }
        synchronized (this.mLock) {
            this.mzv = UserCallback.NOT_IN_CALLBACK;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fC(long j) {
        synchronized (this.mLock) {
            this.mzu = nativeAttachUploadDataToRequest(j, this.mzr);
        }
    }
}
