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
    private Runnable mcf;
    private final UploadDataProvider mcq;
    private final CronetUrlRequest mcr;
    private long mcs;
    private long mct;
    private final Runnable mcu = new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (CronetUploadDataStream.this.mLock) {
                if (CronetUploadDataStream.this.mcv != 0) {
                    CronetUploadDataStream.this.a(UserCallback.NOT_IN_CALLBACK);
                    if (CronetUploadDataStream.this.mByteBuffer == null) {
                        throw new IllegalStateException("Unexpected readData call. Buffer is null");
                    }
                    CronetUploadDataStream.this.mcw = UserCallback.READ;
                    try {
                        CronetUploadDataStream.this.mcq.a(CronetUploadDataStream.this, CronetUploadDataStream.this.mByteBuffer);
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
    private long mcv = 0;
    @GuardedBy("mLock")
    private UserCallback mcw = UserCallback.NOT_IN_CALLBACK;
    @GuardedBy("mLock")
    private boolean mcx = false;

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
        this.mcq = uploadDataProvider;
        this.mcr = cronetUrlRequest;
    }

    @CalledByNative
    void readData(ByteBuffer byteBuffer) {
        this.mByteBuffer = byteBuffer;
        C(this.mcu);
    }

    @CalledByNative
    void rewind() {
        C(new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUploadDataStream.this.mLock) {
                    if (CronetUploadDataStream.this.mcv != 0) {
                        CronetUploadDataStream.this.a(UserCallback.NOT_IN_CALLBACK);
                        CronetUploadDataStream.this.mcw = UserCallback.REWIND;
                        try {
                            CronetUploadDataStream.this.mcq.a(CronetUploadDataStream.this);
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
        if (this.mcw != userCallback) {
            throw new IllegalStateException("Expected " + userCallback + ", but was " + this.mcw);
        }
    }

    @CalledByNative
    void onUploadDataStreamDestroyed() {
        dqh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(Throwable th) {
        synchronized (this.mLock) {
            if (this.mcw == UserCallback.NOT_IN_CALLBACK) {
                throw new IllegalStateException("There is no read or rewind or length check in progress.");
            }
            this.mcw = UserCallback.NOT_IN_CALLBACK;
            this.mByteBuffer = null;
            dqi();
        }
        this.mcr.u(th);
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void vF(boolean z) {
        synchronized (this.mLock) {
            a(UserCallback.READ);
            if (z && this.mcs >= 0) {
                throw new IllegalArgumentException("Non-chunked upload can't have last chunk");
            }
            int position = this.mByteBuffer.position();
            this.mct -= position;
            if (this.mct < 0 && this.mcs >= 0) {
                throw new IllegalArgumentException(String.format("Read upload data length %d exceeds expected length %d", Long.valueOf(this.mcs - this.mct), Long.valueOf(this.mcs)));
            }
            this.mByteBuffer = null;
            this.mcw = UserCallback.NOT_IN_CALLBACK;
            dqi();
            if (this.mcv != 0) {
                nativeOnReadSucceeded(this.mcv, position, z);
            }
        }
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void dqg() {
        synchronized (this.mLock) {
            a(UserCallback.REWIND);
            this.mcw = UserCallback.NOT_IN_CALLBACK;
            this.mct = this.mcs;
            if (this.mcv != 0) {
                nativeOnRewindSucceeded(this.mcv);
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
            this.mcr.u(th);
        }
    }

    private void dqh() {
        synchronized (this.mLock) {
            if (this.mcw == UserCallback.READ) {
                this.mcx = true;
            } else if (this.mcv != 0) {
                nativeDestroy(this.mcv);
                this.mcv = 0L;
                if (this.mcf != null) {
                    this.mcf.run();
                }
                C(new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            CronetUploadDataStream.this.mcq.close();
                        } catch (IOException e) {
                            Log.e("CronetUploadDataStream", "Exception thrown when closing", e);
                        }
                    }
                });
            }
        }
    }

    private void dqi() {
        synchronized (this.mLock) {
            if (this.mcw == UserCallback.READ) {
                throw new IllegalStateException("Method should not be called when read has not completed.");
            }
            if (this.mcx) {
                dqh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dqj() {
        synchronized (this.mLock) {
            this.mcw = UserCallback.GET_LENGTH;
        }
        try {
            this.mcs = this.mcq.getLength();
            this.mct = this.mcs;
        } catch (Throwable th) {
            onError(th);
        }
        synchronized (this.mLock) {
            this.mcw = UserCallback.NOT_IN_CALLBACK;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fx(long j) {
        synchronized (this.mLock) {
            this.mcv = nativeAttachUploadDataToRequest(j, this.mcs);
        }
    }
}
