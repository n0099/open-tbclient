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
    private long naA;
    private long naB;
    private Runnable nan;
    private final UploadDataProvider nay;
    private final CronetUrlRequest naz;
    private final Runnable naC = new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (CronetUploadDataStream.this.mLock) {
                if (CronetUploadDataStream.this.naD != 0) {
                    CronetUploadDataStream.this.a(UserCallback.NOT_IN_CALLBACK);
                    if (CronetUploadDataStream.this.mByteBuffer == null) {
                        throw new IllegalStateException("Unexpected readData call. Buffer is null");
                    }
                    CronetUploadDataStream.this.naE = UserCallback.READ;
                    try {
                        CronetUploadDataStream.this.nay.a(CronetUploadDataStream.this, CronetUploadDataStream.this.mByteBuffer);
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
    private long naD = 0;
    @GuardedBy("mLock")
    private UserCallback naE = UserCallback.NOT_IN_CALLBACK;
    @GuardedBy("mLock")
    private boolean naF = false;

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
        this.nay = uploadDataProvider;
        this.naz = cronetUrlRequest;
    }

    @CalledByNative
    void readData(ByteBuffer byteBuffer) {
        this.mByteBuffer = byteBuffer;
        y(this.naC);
    }

    @CalledByNative
    void rewind() {
        y(new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUploadDataStream.this.mLock) {
                    if (CronetUploadDataStream.this.naD != 0) {
                        CronetUploadDataStream.this.a(UserCallback.NOT_IN_CALLBACK);
                        CronetUploadDataStream.this.naE = UserCallback.REWIND;
                        try {
                            CronetUploadDataStream.this.nay.a(CronetUploadDataStream.this);
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
        if (this.naE != userCallback) {
            throw new IllegalStateException("Expected " + userCallback + ", but was " + this.naE);
        }
    }

    @CalledByNative
    void onUploadDataStreamDestroyed() {
        dKf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(Throwable th) {
        synchronized (this.mLock) {
            if (this.naE == UserCallback.NOT_IN_CALLBACK) {
                throw new IllegalStateException("There is no read or rewind or length check in progress.");
            }
            this.naE = UserCallback.NOT_IN_CALLBACK;
            this.mByteBuffer = null;
            dKg();
        }
        this.naz.s(th);
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void xy(boolean z) {
        synchronized (this.mLock) {
            a(UserCallback.READ);
            if (z && this.naA >= 0) {
                throw new IllegalArgumentException("Non-chunked upload can't have last chunk");
            }
            int position = this.mByteBuffer.position();
            this.naB -= position;
            if (this.naB < 0 && this.naA >= 0) {
                throw new IllegalArgumentException(String.format("Read upload data length %d exceeds expected length %d", Long.valueOf(this.naA - this.naB), Long.valueOf(this.naA)));
            }
            this.mByteBuffer = null;
            this.naE = UserCallback.NOT_IN_CALLBACK;
            dKg();
            if (this.naD != 0) {
                nativeOnReadSucceeded(this.naD, position, z);
            }
        }
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void dKe() {
        synchronized (this.mLock) {
            a(UserCallback.REWIND);
            this.naE = UserCallback.NOT_IN_CALLBACK;
            this.naB = this.naA;
            if (this.naD != 0) {
                nativeOnRewindSucceeded(this.naD);
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
            this.naz.s(th);
        }
    }

    private void dKf() {
        synchronized (this.mLock) {
            if (this.naE == UserCallback.READ) {
                this.naF = true;
            } else if (this.naD != 0) {
                nativeDestroy(this.naD);
                this.naD = 0L;
                if (this.nan != null) {
                    this.nan.run();
                }
                y(new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            CronetUploadDataStream.this.nay.close();
                        } catch (IOException e) {
                            Log.e("CronetUploadDataStream", "Exception thrown when closing", e);
                        }
                    }
                });
            }
        }
    }

    private void dKg() {
        synchronized (this.mLock) {
            if (this.naE == UserCallback.READ) {
                throw new IllegalStateException("Method should not be called when read has not completed.");
            }
            if (this.naF) {
                dKf();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dKh() {
        synchronized (this.mLock) {
            this.naE = UserCallback.GET_LENGTH;
        }
        try {
            this.naA = this.nay.getLength();
            this.naB = this.naA;
        } catch (Throwable th) {
            onError(th);
        }
        synchronized (this.mLock) {
            this.naE = UserCallback.NOT_IN_CALLBACK;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void gb(long j) {
        synchronized (this.mLock) {
            this.naD = nativeAttachUploadDataToRequest(j, this.naA);
        }
    }
}
