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
    private final CronetUrlRequest mHA;
    private long mHB;
    private long mHC;
    private Runnable mHo;
    private final UploadDataProvider mHz;
    private final Runnable mHD = new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (CronetUploadDataStream.this.mLock) {
                if (CronetUploadDataStream.this.mHE != 0) {
                    CronetUploadDataStream.this.a(UserCallback.NOT_IN_CALLBACK);
                    if (CronetUploadDataStream.this.mByteBuffer == null) {
                        throw new IllegalStateException("Unexpected readData call. Buffer is null");
                    }
                    CronetUploadDataStream.this.mHF = UserCallback.READ;
                    try {
                        CronetUploadDataStream.this.mHz.a(CronetUploadDataStream.this, CronetUploadDataStream.this.mByteBuffer);
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
    private long mHE = 0;
    @GuardedBy("mLock")
    private UserCallback mHF = UserCallback.NOT_IN_CALLBACK;
    @GuardedBy("mLock")
    private boolean mHG = false;

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
        this.mHz = uploadDataProvider;
        this.mHA = cronetUrlRequest;
    }

    @CalledByNative
    void readData(ByteBuffer byteBuffer) {
        this.mByteBuffer = byteBuffer;
        B(this.mHD);
    }

    @CalledByNative
    void rewind() {
        B(new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUploadDataStream.this.mLock) {
                    if (CronetUploadDataStream.this.mHE != 0) {
                        CronetUploadDataStream.this.a(UserCallback.NOT_IN_CALLBACK);
                        CronetUploadDataStream.this.mHF = UserCallback.REWIND;
                        try {
                            CronetUploadDataStream.this.mHz.a(CronetUploadDataStream.this);
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
        if (this.mHF != userCallback) {
            throw new IllegalStateException("Expected " + userCallback + ", but was " + this.mHF);
        }
    }

    @CalledByNative
    void onUploadDataStreamDestroyed() {
        dys();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(Throwable th) {
        synchronized (this.mLock) {
            if (this.mHF == UserCallback.NOT_IN_CALLBACK) {
                throw new IllegalStateException("There is no read or rewind or length check in progress.");
            }
            this.mHF = UserCallback.NOT_IN_CALLBACK;
            this.mByteBuffer = null;
            dyt();
        }
        this.mHA.t(th);
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void wI(boolean z) {
        synchronized (this.mLock) {
            a(UserCallback.READ);
            if (z && this.mHB >= 0) {
                throw new IllegalArgumentException("Non-chunked upload can't have last chunk");
            }
            int position = this.mByteBuffer.position();
            this.mHC -= position;
            if (this.mHC < 0 && this.mHB >= 0) {
                throw new IllegalArgumentException(String.format("Read upload data length %d exceeds expected length %d", Long.valueOf(this.mHB - this.mHC), Long.valueOf(this.mHB)));
            }
            this.mByteBuffer = null;
            this.mHF = UserCallback.NOT_IN_CALLBACK;
            dyt();
            if (this.mHE != 0) {
                nativeOnReadSucceeded(this.mHE, position, z);
            }
        }
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void dyr() {
        synchronized (this.mLock) {
            a(UserCallback.REWIND);
            this.mHF = UserCallback.NOT_IN_CALLBACK;
            this.mHC = this.mHB;
            if (this.mHE != 0) {
                nativeOnRewindSucceeded(this.mHE);
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
            this.mHA.t(th);
        }
    }

    private void dys() {
        synchronized (this.mLock) {
            if (this.mHF == UserCallback.READ) {
                this.mHG = true;
            } else if (this.mHE != 0) {
                nativeDestroy(this.mHE);
                this.mHE = 0L;
                if (this.mHo != null) {
                    this.mHo.run();
                }
                B(new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            CronetUploadDataStream.this.mHz.close();
                        } catch (IOException e) {
                            Log.e("CronetUploadDataStream", "Exception thrown when closing", e);
                        }
                    }
                });
            }
        }
    }

    private void dyt() {
        synchronized (this.mLock) {
            if (this.mHF == UserCallback.READ) {
                throw new IllegalStateException("Method should not be called when read has not completed.");
            }
            if (this.mHG) {
                dys();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dyu() {
        synchronized (this.mLock) {
            this.mHF = UserCallback.GET_LENGTH;
        }
        try {
            this.mHB = this.mHz.getLength();
            this.mHC = this.mHB;
        } catch (Throwable th) {
            onError(th);
        }
        synchronized (this.mLock) {
            this.mHF = UserCallback.NOT_IN_CALLBACK;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fP(long j) {
        synchronized (this.mLock) {
            this.mHE = nativeAttachUploadDataToRequest(j, this.mHB);
        }
    }
}
