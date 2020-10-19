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
    private Runnable nAb;
    private final UploadDataProvider nAm;
    private final CronetUrlRequest nAn;
    private long nAo;
    private long nAp;
    private final Runnable nAq = new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (CronetUploadDataStream.this.mLock) {
                if (CronetUploadDataStream.this.nAr != 0) {
                    CronetUploadDataStream.this.a(UserCallback.NOT_IN_CALLBACK);
                    if (CronetUploadDataStream.this.mByteBuffer == null) {
                        throw new IllegalStateException("Unexpected readData call. Buffer is null");
                    }
                    CronetUploadDataStream.this.nAs = UserCallback.READ;
                    try {
                        CronetUploadDataStream.this.nAm.a(CronetUploadDataStream.this, CronetUploadDataStream.this.mByteBuffer);
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
    private long nAr = 0;
    @GuardedBy("mLock")
    private UserCallback nAs = UserCallback.NOT_IN_CALLBACK;
    @GuardedBy("mLock")
    private boolean nAt = false;

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
        this.nAm = uploadDataProvider;
        this.nAn = cronetUrlRequest;
    }

    @CalledByNative
    void readData(ByteBuffer byteBuffer) {
        this.mByteBuffer = byteBuffer;
        y(this.nAq);
    }

    @CalledByNative
    void rewind() {
        y(new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUploadDataStream.this.mLock) {
                    if (CronetUploadDataStream.this.nAr != 0) {
                        CronetUploadDataStream.this.a(UserCallback.NOT_IN_CALLBACK);
                        CronetUploadDataStream.this.nAs = UserCallback.REWIND;
                        try {
                            CronetUploadDataStream.this.nAm.a(CronetUploadDataStream.this);
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
        if (this.nAs != userCallback) {
            throw new IllegalStateException("Expected " + userCallback + ", but was " + this.nAs);
        }
    }

    @CalledByNative
    void onUploadDataStreamDestroyed() {
        dRY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(Throwable th) {
        synchronized (this.mLock) {
            if (this.nAs == UserCallback.NOT_IN_CALLBACK) {
                throw new IllegalStateException("There is no read or rewind or length check in progress.");
            }
            this.nAs = UserCallback.NOT_IN_CALLBACK;
            this.mByteBuffer = null;
            dRZ();
        }
        this.nAn.s(th);
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void yq(boolean z) {
        synchronized (this.mLock) {
            a(UserCallback.READ);
            if (z && this.nAo >= 0) {
                throw new IllegalArgumentException("Non-chunked upload can't have last chunk");
            }
            int position = this.mByteBuffer.position();
            this.nAp -= position;
            if (this.nAp < 0 && this.nAo >= 0) {
                throw new IllegalArgumentException(String.format("Read upload data length %d exceeds expected length %d", Long.valueOf(this.nAo - this.nAp), Long.valueOf(this.nAo)));
            }
            this.mByteBuffer = null;
            this.nAs = UserCallback.NOT_IN_CALLBACK;
            dRZ();
            if (this.nAr != 0) {
                nativeOnReadSucceeded(this.nAr, position, z);
            }
        }
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void dRX() {
        synchronized (this.mLock) {
            a(UserCallback.REWIND);
            this.nAs = UserCallback.NOT_IN_CALLBACK;
            this.nAp = this.nAo;
            if (this.nAr != 0) {
                nativeOnRewindSucceeded(this.nAr);
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
            this.nAn.s(th);
        }
    }

    private void dRY() {
        synchronized (this.mLock) {
            if (this.nAs == UserCallback.READ) {
                this.nAt = true;
            } else if (this.nAr != 0) {
                nativeDestroy(this.nAr);
                this.nAr = 0L;
                if (this.nAb != null) {
                    this.nAb.run();
                }
                y(new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            CronetUploadDataStream.this.nAm.close();
                        } catch (IOException e) {
                            Log.e("CronetUploadDataStream", "Exception thrown when closing", e);
                        }
                    }
                });
            }
        }
    }

    private void dRZ() {
        synchronized (this.mLock) {
            if (this.nAs == UserCallback.READ) {
                throw new IllegalStateException("Method should not be called when read has not completed.");
            }
            if (this.nAt) {
                dRY();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dSa() {
        synchronized (this.mLock) {
            this.nAs = UserCallback.GET_LENGTH;
        }
        try {
            this.nAo = this.nAm.getLength();
            this.nAp = this.nAo;
        } catch (Throwable th) {
            onError(th);
        }
        synchronized (this.mLock) {
            this.nAs = UserCallback.NOT_IN_CALLBACK;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void gJ(long j) {
        synchronized (this.mLock) {
            this.nAr = nativeAttachUploadDataToRequest(j, this.nAo);
        }
    }
}
