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
/* loaded from: classes15.dex */
public final class CronetUploadDataStream implements UploadDataSink {
    private final Executor mExecutor;
    private Runnable nkE;
    private final UploadDataProvider nkP;
    private final CronetUrlRequest nkQ;
    private long nkR;
    private long nkS;
    private final Runnable nkT = new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (CronetUploadDataStream.this.mLock) {
                if (CronetUploadDataStream.this.nkU != 0) {
                    CronetUploadDataStream.this.a(UserCallback.NOT_IN_CALLBACK);
                    if (CronetUploadDataStream.this.mByteBuffer == null) {
                        throw new IllegalStateException("Unexpected readData call. Buffer is null");
                    }
                    CronetUploadDataStream.this.nkV = UserCallback.READ;
                    try {
                        CronetUploadDataStream.this.nkP.a(CronetUploadDataStream.this, CronetUploadDataStream.this.mByteBuffer);
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
    private long nkU = 0;
    @GuardedBy("mLock")
    private UserCallback nkV = UserCallback.NOT_IN_CALLBACK;
    @GuardedBy("mLock")
    private boolean nkW = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
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
        this.nkP = uploadDataProvider;
        this.nkQ = cronetUrlRequest;
    }

    @CalledByNative
    void readData(ByteBuffer byteBuffer) {
        this.mByteBuffer = byteBuffer;
        y(this.nkT);
    }

    @CalledByNative
    void rewind() {
        y(new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUploadDataStream.this.mLock) {
                    if (CronetUploadDataStream.this.nkU != 0) {
                        CronetUploadDataStream.this.a(UserCallback.NOT_IN_CALLBACK);
                        CronetUploadDataStream.this.nkV = UserCallback.REWIND;
                        try {
                            CronetUploadDataStream.this.nkP.a(CronetUploadDataStream.this);
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
        if (this.nkV != userCallback) {
            throw new IllegalStateException("Expected " + userCallback + ", but was " + this.nkV);
        }
    }

    @CalledByNative
    void onUploadDataStreamDestroyed() {
        dOm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(Throwable th) {
        synchronized (this.mLock) {
            if (this.nkV == UserCallback.NOT_IN_CALLBACK) {
                throw new IllegalStateException("There is no read or rewind or length check in progress.");
            }
            this.nkV = UserCallback.NOT_IN_CALLBACK;
            this.mByteBuffer = null;
            dOn();
        }
        this.nkQ.s(th);
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void xJ(boolean z) {
        synchronized (this.mLock) {
            a(UserCallback.READ);
            if (z && this.nkR >= 0) {
                throw new IllegalArgumentException("Non-chunked upload can't have last chunk");
            }
            int position = this.mByteBuffer.position();
            this.nkS -= position;
            if (this.nkS < 0 && this.nkR >= 0) {
                throw new IllegalArgumentException(String.format("Read upload data length %d exceeds expected length %d", Long.valueOf(this.nkR - this.nkS), Long.valueOf(this.nkR)));
            }
            this.mByteBuffer = null;
            this.nkV = UserCallback.NOT_IN_CALLBACK;
            dOn();
            if (this.nkU != 0) {
                nativeOnReadSucceeded(this.nkU, position, z);
            }
        }
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void dOl() {
        synchronized (this.mLock) {
            a(UserCallback.REWIND);
            this.nkV = UserCallback.NOT_IN_CALLBACK;
            this.nkS = this.nkR;
            if (this.nkU != 0) {
                nativeOnRewindSucceeded(this.nkU);
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
    public void y(Runnable runnable) {
        try {
            this.mExecutor.execute(runnable);
        } catch (Throwable th) {
            this.nkQ.s(th);
        }
    }

    private void dOm() {
        synchronized (this.mLock) {
            if (this.nkV == UserCallback.READ) {
                this.nkW = true;
            } else if (this.nkU != 0) {
                nativeDestroy(this.nkU);
                this.nkU = 0L;
                if (this.nkE != null) {
                    this.nkE.run();
                }
                y(new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            CronetUploadDataStream.this.nkP.close();
                        } catch (IOException e) {
                            Log.e("CronetUploadDataStream", "Exception thrown when closing", e);
                        }
                    }
                });
            }
        }
    }

    private void dOn() {
        synchronized (this.mLock) {
            if (this.nkV == UserCallback.READ) {
                throw new IllegalStateException("Method should not be called when read has not completed.");
            }
            if (this.nkW) {
                dOm();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dOo() {
        synchronized (this.mLock) {
            this.nkV = UserCallback.GET_LENGTH;
        }
        try {
            this.nkR = this.nkP.getLength();
            this.nkS = this.nkR;
        } catch (Throwable th) {
            onError(th);
        }
        synchronized (this.mLock) {
            this.nkV = UserCallback.NOT_IN_CALLBACK;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void gr(long j) {
        synchronized (this.mLock) {
            this.nkU = nativeAttachUploadDataToRequest(j, this.nkR);
        }
    }
}
