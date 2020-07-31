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
/* loaded from: classes19.dex */
public final class CronetUploadDataStream implements UploadDataSink {
    private final Executor mExecutor;
    private long mHA;
    private Runnable mHm;
    private final UploadDataProvider mHx;
    private final CronetUrlRequest mHy;
    private long mHz;
    private final Runnable mHB = new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (CronetUploadDataStream.this.mLock) {
                if (CronetUploadDataStream.this.mHC != 0) {
                    CronetUploadDataStream.this.a(UserCallback.NOT_IN_CALLBACK);
                    if (CronetUploadDataStream.this.mByteBuffer == null) {
                        throw new IllegalStateException("Unexpected readData call. Buffer is null");
                    }
                    CronetUploadDataStream.this.mHD = UserCallback.READ;
                    try {
                        CronetUploadDataStream.this.mHx.a(CronetUploadDataStream.this, CronetUploadDataStream.this.mByteBuffer);
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
    private long mHC = 0;
    @GuardedBy("mLock")
    private UserCallback mHD = UserCallback.NOT_IN_CALLBACK;
    @GuardedBy("mLock")
    private boolean mHE = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
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
        this.mHx = uploadDataProvider;
        this.mHy = cronetUrlRequest;
    }

    @CalledByNative
    void readData(ByteBuffer byteBuffer) {
        this.mByteBuffer = byteBuffer;
        B(this.mHB);
    }

    @CalledByNative
    void rewind() {
        B(new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUploadDataStream.this.mLock) {
                    if (CronetUploadDataStream.this.mHC != 0) {
                        CronetUploadDataStream.this.a(UserCallback.NOT_IN_CALLBACK);
                        CronetUploadDataStream.this.mHD = UserCallback.REWIND;
                        try {
                            CronetUploadDataStream.this.mHx.a(CronetUploadDataStream.this);
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
        if (this.mHD != userCallback) {
            throw new IllegalStateException("Expected " + userCallback + ", but was " + this.mHD);
        }
    }

    @CalledByNative
    void onUploadDataStreamDestroyed() {
        dyr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(Throwable th) {
        synchronized (this.mLock) {
            if (this.mHD == UserCallback.NOT_IN_CALLBACK) {
                throw new IllegalStateException("There is no read or rewind or length check in progress.");
            }
            this.mHD = UserCallback.NOT_IN_CALLBACK;
            this.mByteBuffer = null;
            dys();
        }
        this.mHy.t(th);
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void wI(boolean z) {
        synchronized (this.mLock) {
            a(UserCallback.READ);
            if (z && this.mHz >= 0) {
                throw new IllegalArgumentException("Non-chunked upload can't have last chunk");
            }
            int position = this.mByteBuffer.position();
            this.mHA -= position;
            if (this.mHA < 0 && this.mHz >= 0) {
                throw new IllegalArgumentException(String.format("Read upload data length %d exceeds expected length %d", Long.valueOf(this.mHz - this.mHA), Long.valueOf(this.mHz)));
            }
            this.mByteBuffer = null;
            this.mHD = UserCallback.NOT_IN_CALLBACK;
            dys();
            if (this.mHC != 0) {
                nativeOnReadSucceeded(this.mHC, position, z);
            }
        }
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void dyq() {
        synchronized (this.mLock) {
            a(UserCallback.REWIND);
            this.mHD = UserCallback.NOT_IN_CALLBACK;
            this.mHA = this.mHz;
            if (this.mHC != 0) {
                nativeOnRewindSucceeded(this.mHC);
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
    public void B(Runnable runnable) {
        try {
            this.mExecutor.execute(runnable);
        } catch (Throwable th) {
            this.mHy.t(th);
        }
    }

    private void dyr() {
        synchronized (this.mLock) {
            if (this.mHD == UserCallback.READ) {
                this.mHE = true;
            } else if (this.mHC != 0) {
                nativeDestroy(this.mHC);
                this.mHC = 0L;
                if (this.mHm != null) {
                    this.mHm.run();
                }
                B(new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            CronetUploadDataStream.this.mHx.close();
                        } catch (IOException e) {
                            Log.e("CronetUploadDataStream", "Exception thrown when closing", e);
                        }
                    }
                });
            }
        }
    }

    private void dys() {
        synchronized (this.mLock) {
            if (this.mHD == UserCallback.READ) {
                throw new IllegalStateException("Method should not be called when read has not completed.");
            }
            if (this.mHE) {
                dyr();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dyt() {
        synchronized (this.mLock) {
            this.mHD = UserCallback.GET_LENGTH;
        }
        try {
            this.mHz = this.mHx.getLength();
            this.mHA = this.mHz;
        } catch (Throwable th) {
            onError(th);
        }
        synchronized (this.mLock) {
            this.mHD = UserCallback.NOT_IN_CALLBACK;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fP(long j) {
        synchronized (this.mLock) {
            this.mHC = nativeAttachUploadDataToRequest(j, this.mHz);
        }
    }
}
