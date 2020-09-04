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
/* loaded from: classes10.dex */
public final class CronetUploadDataStream implements UploadDataSink {
    private final Executor mExecutor;
    private Runnable naF;
    private final UploadDataProvider naQ;
    private final CronetUrlRequest naR;
    private long naS;
    private long naT;
    private final Runnable naU = new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (CronetUploadDataStream.this.mLock) {
                if (CronetUploadDataStream.this.naV != 0) {
                    CronetUploadDataStream.this.a(UserCallback.NOT_IN_CALLBACK);
                    if (CronetUploadDataStream.this.mByteBuffer == null) {
                        throw new IllegalStateException("Unexpected readData call. Buffer is null");
                    }
                    CronetUploadDataStream.this.naW = UserCallback.READ;
                    try {
                        CronetUploadDataStream.this.naQ.a(CronetUploadDataStream.this, CronetUploadDataStream.this.mByteBuffer);
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
    private long naV = 0;
    @GuardedBy("mLock")
    private UserCallback naW = UserCallback.NOT_IN_CALLBACK;
    @GuardedBy("mLock")
    private boolean naX = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
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
        this.naQ = uploadDataProvider;
        this.naR = cronetUrlRequest;
    }

    @CalledByNative
    void readData(ByteBuffer byteBuffer) {
        this.mByteBuffer = byteBuffer;
        y(this.naU);
    }

    @CalledByNative
    void rewind() {
        y(new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUploadDataStream.this.mLock) {
                    if (CronetUploadDataStream.this.naV != 0) {
                        CronetUploadDataStream.this.a(UserCallback.NOT_IN_CALLBACK);
                        CronetUploadDataStream.this.naW = UserCallback.REWIND;
                        try {
                            CronetUploadDataStream.this.naQ.a(CronetUploadDataStream.this);
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
        if (this.naW != userCallback) {
            throw new IllegalStateException("Expected " + userCallback + ", but was " + this.naW);
        }
    }

    @CalledByNative
    void onUploadDataStreamDestroyed() {
        dKo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(Throwable th) {
        synchronized (this.mLock) {
            if (this.naW == UserCallback.NOT_IN_CALLBACK) {
                throw new IllegalStateException("There is no read or rewind or length check in progress.");
            }
            this.naW = UserCallback.NOT_IN_CALLBACK;
            this.mByteBuffer = null;
            dKp();
        }
        this.naR.s(th);
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void xA(boolean z) {
        synchronized (this.mLock) {
            a(UserCallback.READ);
            if (z && this.naS >= 0) {
                throw new IllegalArgumentException("Non-chunked upload can't have last chunk");
            }
            int position = this.mByteBuffer.position();
            this.naT -= position;
            if (this.naT < 0 && this.naS >= 0) {
                throw new IllegalArgumentException(String.format("Read upload data length %d exceeds expected length %d", Long.valueOf(this.naS - this.naT), Long.valueOf(this.naS)));
            }
            this.mByteBuffer = null;
            this.naW = UserCallback.NOT_IN_CALLBACK;
            dKp();
            if (this.naV != 0) {
                nativeOnReadSucceeded(this.naV, position, z);
            }
        }
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void dKn() {
        synchronized (this.mLock) {
            a(UserCallback.REWIND);
            this.naW = UserCallback.NOT_IN_CALLBACK;
            this.naT = this.naS;
            if (this.naV != 0) {
                nativeOnRewindSucceeded(this.naV);
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
            this.naR.s(th);
        }
    }

    private void dKo() {
        synchronized (this.mLock) {
            if (this.naW == UserCallback.READ) {
                this.naX = true;
            } else if (this.naV != 0) {
                nativeDestroy(this.naV);
                this.naV = 0L;
                if (this.naF != null) {
                    this.naF.run();
                }
                y(new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            CronetUploadDataStream.this.naQ.close();
                        } catch (IOException e) {
                            Log.e("CronetUploadDataStream", "Exception thrown when closing", e);
                        }
                    }
                });
            }
        }
    }

    private void dKp() {
        synchronized (this.mLock) {
            if (this.naW == UserCallback.READ) {
                throw new IllegalStateException("Method should not be called when read has not completed.");
            }
            if (this.naX) {
                dKo();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dKq() {
        synchronized (this.mLock) {
            this.naW = UserCallback.GET_LENGTH;
        }
        try {
            this.naS = this.naQ.getLength();
            this.naT = this.naS;
        } catch (Throwable th) {
            onError(th);
        }
        synchronized (this.mLock) {
            this.naW = UserCallback.NOT_IN_CALLBACK;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void gd(long j) {
        synchronized (this.mLock) {
            this.naV = nativeAttachUploadDataToRequest(j, this.naS);
        }
    }
}
