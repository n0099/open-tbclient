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
    private Runnable olG;
    private final UploadDataProvider olR;
    private final CronetUrlRequest olS;
    private long olT;
    private long olU;
    private final Runnable olV = new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (CronetUploadDataStream.this.mLock) {
                if (CronetUploadDataStream.this.olW != 0) {
                    CronetUploadDataStream.this.a(UserCallback.NOT_IN_CALLBACK);
                    if (CronetUploadDataStream.this.mByteBuffer == null) {
                        throw new IllegalStateException("Unexpected readData call. Buffer is null");
                    }
                    CronetUploadDataStream.this.olX = UserCallback.READ;
                    try {
                        CronetUploadDataStream.this.olR.a(CronetUploadDataStream.this, CronetUploadDataStream.this.mByteBuffer);
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
    private long olW = 0;
    @GuardedBy("mLock")
    private UserCallback olX = UserCallback.NOT_IN_CALLBACK;
    @GuardedBy("mLock")
    private boolean olY = false;

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
        this.olR = uploadDataProvider;
        this.olS = cronetUrlRequest;
    }

    @CalledByNative
    void readData(ByteBuffer byteBuffer) {
        this.mByteBuffer = byteBuffer;
        z(this.olV);
    }

    @CalledByNative
    void rewind() {
        z(new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUploadDataStream.this.mLock) {
                    if (CronetUploadDataStream.this.olW != 0) {
                        CronetUploadDataStream.this.a(UserCallback.NOT_IN_CALLBACK);
                        CronetUploadDataStream.this.olX = UserCallback.REWIND;
                        try {
                            CronetUploadDataStream.this.olR.a(CronetUploadDataStream.this);
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
        if (this.olX != userCallback) {
            throw new IllegalStateException("Expected " + userCallback + ", but was " + this.olX);
        }
    }

    @CalledByNative
    void onUploadDataStreamDestroyed() {
        eby();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(Throwable th) {
        synchronized (this.mLock) {
            if (this.olX == UserCallback.NOT_IN_CALLBACK) {
                throw new IllegalStateException("There is no read or rewind or length check in progress.");
            }
            this.olX = UserCallback.NOT_IN_CALLBACK;
            this.mByteBuffer = null;
            ebz();
        }
        this.olS.s(th);
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void zr(boolean z) {
        synchronized (this.mLock) {
            a(UserCallback.READ);
            if (z && this.olT >= 0) {
                throw new IllegalArgumentException("Non-chunked upload can't have last chunk");
            }
            int position = this.mByteBuffer.position();
            this.olU -= position;
            if (this.olU < 0 && this.olT >= 0) {
                throw new IllegalArgumentException(String.format("Read upload data length %d exceeds expected length %d", Long.valueOf(this.olT - this.olU), Long.valueOf(this.olT)));
            }
            this.mByteBuffer = null;
            this.olX = UserCallback.NOT_IN_CALLBACK;
            ebz();
            if (this.olW != 0) {
                nativeOnReadSucceeded(this.olW, position, z);
            }
        }
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void ebx() {
        synchronized (this.mLock) {
            a(UserCallback.REWIND);
            this.olX = UserCallback.NOT_IN_CALLBACK;
            this.olU = this.olT;
            if (this.olW != 0) {
                nativeOnRewindSucceeded(this.olW);
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
            this.olS.s(th);
        }
    }

    private void eby() {
        synchronized (this.mLock) {
            if (this.olX == UserCallback.READ) {
                this.olY = true;
            } else if (this.olW != 0) {
                nativeDestroy(this.olW);
                this.olW = 0L;
                if (this.olG != null) {
                    this.olG.run();
                }
                z(new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            CronetUploadDataStream.this.olR.close();
                        } catch (IOException e) {
                            Log.e("CronetUploadDataStream", "Exception thrown when closing", e);
                        }
                    }
                });
            }
        }
    }

    private void ebz() {
        synchronized (this.mLock) {
            if (this.olX == UserCallback.READ) {
                throw new IllegalStateException("Method should not be called when read has not completed.");
            }
            if (this.olY) {
                eby();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ebA() {
        synchronized (this.mLock) {
            this.olX = UserCallback.GET_LENGTH;
        }
        try {
            this.olT = this.olR.getLength();
            this.olU = this.olT;
        } catch (Throwable th) {
            onError(th);
        }
        synchronized (this.mLock) {
            this.olX = UserCallback.NOT_IN_CALLBACK;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hm(long j) {
        synchronized (this.mLock) {
            this.olW = nativeAttachUploadDataToRequest(j, this.olT);
        }
    }
}
