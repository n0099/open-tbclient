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
    private final UploadDataProvider mdA;
    private final CronetUrlRequest mdB;
    private long mdC;
    private long mdD;
    private Runnable mdp;
    private final Runnable mdE = new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (CronetUploadDataStream.this.mLock) {
                if (CronetUploadDataStream.this.mdF != 0) {
                    CronetUploadDataStream.this.a(UserCallback.NOT_IN_CALLBACK);
                    if (CronetUploadDataStream.this.mByteBuffer == null) {
                        throw new IllegalStateException("Unexpected readData call. Buffer is null");
                    }
                    CronetUploadDataStream.this.mdG = UserCallback.READ;
                    try {
                        CronetUploadDataStream.this.mdA.a(CronetUploadDataStream.this, CronetUploadDataStream.this.mByteBuffer);
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
    private long mdF = 0;
    @GuardedBy("mLock")
    private UserCallback mdG = UserCallback.NOT_IN_CALLBACK;
    @GuardedBy("mLock")
    private boolean mdH = false;

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
        this.mdA = uploadDataProvider;
        this.mdB = cronetUrlRequest;
    }

    @CalledByNative
    void readData(ByteBuffer byteBuffer) {
        this.mByteBuffer = byteBuffer;
        C(this.mdE);
    }

    @CalledByNative
    void rewind() {
        C(new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUploadDataStream.this.mLock) {
                    if (CronetUploadDataStream.this.mdF != 0) {
                        CronetUploadDataStream.this.a(UserCallback.NOT_IN_CALLBACK);
                        CronetUploadDataStream.this.mdG = UserCallback.REWIND;
                        try {
                            CronetUploadDataStream.this.mdA.a(CronetUploadDataStream.this);
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
        if (this.mdG != userCallback) {
            throw new IllegalStateException("Expected " + userCallback + ", but was " + this.mdG);
        }
    }

    @CalledByNative
    void onUploadDataStreamDestroyed() {
        dqv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(Throwable th) {
        synchronized (this.mLock) {
            if (this.mdG == UserCallback.NOT_IN_CALLBACK) {
                throw new IllegalStateException("There is no read or rewind or length check in progress.");
            }
            this.mdG = UserCallback.NOT_IN_CALLBACK;
            this.mByteBuffer = null;
            dqw();
        }
        this.mdB.u(th);
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void vH(boolean z) {
        synchronized (this.mLock) {
            a(UserCallback.READ);
            if (z && this.mdC >= 0) {
                throw new IllegalArgumentException("Non-chunked upload can't have last chunk");
            }
            int position = this.mByteBuffer.position();
            this.mdD -= position;
            if (this.mdD < 0 && this.mdC >= 0) {
                throw new IllegalArgumentException(String.format("Read upload data length %d exceeds expected length %d", Long.valueOf(this.mdC - this.mdD), Long.valueOf(this.mdC)));
            }
            this.mByteBuffer = null;
            this.mdG = UserCallback.NOT_IN_CALLBACK;
            dqw();
            if (this.mdF != 0) {
                nativeOnReadSucceeded(this.mdF, position, z);
            }
        }
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void dqu() {
        synchronized (this.mLock) {
            a(UserCallback.REWIND);
            this.mdG = UserCallback.NOT_IN_CALLBACK;
            this.mdD = this.mdC;
            if (this.mdF != 0) {
                nativeOnRewindSucceeded(this.mdF);
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
            this.mdB.u(th);
        }
    }

    private void dqv() {
        synchronized (this.mLock) {
            if (this.mdG == UserCallback.READ) {
                this.mdH = true;
            } else if (this.mdF != 0) {
                nativeDestroy(this.mdF);
                this.mdF = 0L;
                if (this.mdp != null) {
                    this.mdp.run();
                }
                C(new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            CronetUploadDataStream.this.mdA.close();
                        } catch (IOException e) {
                            Log.e("CronetUploadDataStream", "Exception thrown when closing", e);
                        }
                    }
                });
            }
        }
    }

    private void dqw() {
        synchronized (this.mLock) {
            if (this.mdG == UserCallback.READ) {
                throw new IllegalStateException("Method should not be called when read has not completed.");
            }
            if (this.mdH) {
                dqv();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dqx() {
        synchronized (this.mLock) {
            this.mdG = UserCallback.GET_LENGTH;
        }
        try {
            this.mdC = this.mdA.getLength();
            this.mdD = this.mdC;
        } catch (Throwable th) {
            onError(th);
        }
        synchronized (this.mLock) {
            this.mdG = UserCallback.NOT_IN_CALLBACK;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fx(long j) {
        synchronized (this.mLock) {
            this.mdF = nativeAttachUploadDataToRequest(j, this.mdC);
        }
    }
}
