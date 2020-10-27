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
/* loaded from: classes17.dex */
public final class CronetUploadDataStream implements UploadDataSink {
    private final Executor mExecutor;
    private Runnable ocC;
    private final UploadDataProvider ocN;
    private final CronetUrlRequest ocO;
    private long ocP;
    private long ocQ;
    private final Runnable ocR = new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (CronetUploadDataStream.this.mLock) {
                if (CronetUploadDataStream.this.ocS != 0) {
                    CronetUploadDataStream.this.a(UserCallback.NOT_IN_CALLBACK);
                    if (CronetUploadDataStream.this.mByteBuffer == null) {
                        throw new IllegalStateException("Unexpected readData call. Buffer is null");
                    }
                    CronetUploadDataStream.this.ocT = UserCallback.READ;
                    try {
                        CronetUploadDataStream.this.ocN.a(CronetUploadDataStream.this, CronetUploadDataStream.this.mByteBuffer);
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
    private long ocS = 0;
    @GuardedBy("mLock")
    private UserCallback ocT = UserCallback.NOT_IN_CALLBACK;
    @GuardedBy("mLock")
    private boolean ocU = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
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
        this.ocN = uploadDataProvider;
        this.ocO = cronetUrlRequest;
    }

    @CalledByNative
    void readData(ByteBuffer byteBuffer) {
        this.mByteBuffer = byteBuffer;
        z(this.ocR);
    }

    @CalledByNative
    void rewind() {
        z(new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUploadDataStream.this.mLock) {
                    if (CronetUploadDataStream.this.ocS != 0) {
                        CronetUploadDataStream.this.a(UserCallback.NOT_IN_CALLBACK);
                        CronetUploadDataStream.this.ocT = UserCallback.REWIND;
                        try {
                            CronetUploadDataStream.this.ocN.a(CronetUploadDataStream.this);
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
        if (this.ocT != userCallback) {
            throw new IllegalStateException("Expected " + userCallback + ", but was " + this.ocT);
        }
    }

    @CalledByNative
    void onUploadDataStreamDestroyed() {
        dXQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(Throwable th) {
        synchronized (this.mLock) {
            if (this.ocT == UserCallback.NOT_IN_CALLBACK) {
                throw new IllegalStateException("There is no read or rewind or length check in progress.");
            }
            this.ocT = UserCallback.NOT_IN_CALLBACK;
            this.mByteBuffer = null;
            dXR();
        }
        this.ocO.s(th);
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void zg(boolean z) {
        synchronized (this.mLock) {
            a(UserCallback.READ);
            if (z && this.ocP >= 0) {
                throw new IllegalArgumentException("Non-chunked upload can't have last chunk");
            }
            int position = this.mByteBuffer.position();
            this.ocQ -= position;
            if (this.ocQ < 0 && this.ocP >= 0) {
                throw new IllegalArgumentException(String.format("Read upload data length %d exceeds expected length %d", Long.valueOf(this.ocP - this.ocQ), Long.valueOf(this.ocP)));
            }
            this.mByteBuffer = null;
            this.ocT = UserCallback.NOT_IN_CALLBACK;
            dXR();
            if (this.ocS != 0) {
                nativeOnReadSucceeded(this.ocS, position, z);
            }
        }
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void dXP() {
        synchronized (this.mLock) {
            a(UserCallback.REWIND);
            this.ocT = UserCallback.NOT_IN_CALLBACK;
            this.ocQ = this.ocP;
            if (this.ocS != 0) {
                nativeOnRewindSucceeded(this.ocS);
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
    public void z(Runnable runnable) {
        try {
            this.mExecutor.execute(runnable);
        } catch (Throwable th) {
            this.ocO.s(th);
        }
    }

    private void dXQ() {
        synchronized (this.mLock) {
            if (this.ocT == UserCallback.READ) {
                this.ocU = true;
            } else if (this.ocS != 0) {
                nativeDestroy(this.ocS);
                this.ocS = 0L;
                if (this.ocC != null) {
                    this.ocC.run();
                }
                z(new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            CronetUploadDataStream.this.ocN.close();
                        } catch (IOException e) {
                            Log.e("CronetUploadDataStream", "Exception thrown when closing", e);
                        }
                    }
                });
            }
        }
    }

    private void dXR() {
        synchronized (this.mLock) {
            if (this.ocT == UserCallback.READ) {
                throw new IllegalStateException("Method should not be called when read has not completed.");
            }
            if (this.ocU) {
                dXQ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dXS() {
        synchronized (this.mLock) {
            this.ocT = UserCallback.GET_LENGTH;
        }
        try {
            this.ocP = this.ocN.getLength();
            this.ocQ = this.ocP;
        } catch (Throwable th) {
            onError(th);
        }
        synchronized (this.mLock) {
            this.ocT = UserCallback.NOT_IN_CALLBACK;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void gQ(long j) {
        synchronized (this.mLock) {
            this.ocS = nativeAttachUploadDataToRequest(j, this.ocP);
        }
    }
}
