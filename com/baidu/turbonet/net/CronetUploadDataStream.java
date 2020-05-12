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
    private Runnable lIO;
    private final UploadDataProvider lIZ;
    private final CronetUrlRequest lJa;
    private long lJb;
    private long lJc;
    private final Executor mExecutor;
    private final Runnable lJd = new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (CronetUploadDataStream.this.mLock) {
                if (CronetUploadDataStream.this.lJe != 0) {
                    CronetUploadDataStream.this.a(UserCallback.NOT_IN_CALLBACK);
                    if (CronetUploadDataStream.this.mByteBuffer == null) {
                        throw new IllegalStateException("Unexpected readData call. Buffer is null");
                    }
                    CronetUploadDataStream.this.lJf = UserCallback.READ;
                    try {
                        CronetUploadDataStream.this.lIZ.a(CronetUploadDataStream.this, CronetUploadDataStream.this.mByteBuffer);
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
    private long lJe = 0;
    @GuardedBy("mLock")
    private UserCallback lJf = UserCallback.NOT_IN_CALLBACK;
    @GuardedBy("mLock")
    private boolean lJg = false;

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
        this.lIZ = uploadDataProvider;
        this.lJa = cronetUrlRequest;
    }

    @CalledByNative
    void readData(ByteBuffer byteBuffer) {
        this.mByteBuffer = byteBuffer;
        A(this.lJd);
    }

    @CalledByNative
    void rewind() {
        A(new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUploadDataStream.this.mLock) {
                    if (CronetUploadDataStream.this.lJe != 0) {
                        CronetUploadDataStream.this.a(UserCallback.NOT_IN_CALLBACK);
                        CronetUploadDataStream.this.lJf = UserCallback.REWIND;
                        try {
                            CronetUploadDataStream.this.lIZ.a(CronetUploadDataStream.this);
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
        if (this.lJf != userCallback) {
            throw new IllegalStateException("Expected " + userCallback + ", but was " + this.lJf);
        }
    }

    @CalledByNative
    void onUploadDataStreamDestroyed() {
        diR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(Throwable th) {
        synchronized (this.mLock) {
            if (this.lJf == UserCallback.NOT_IN_CALLBACK) {
                throw new IllegalStateException("There is no read or rewind or length check in progress.");
            }
            this.lJf = UserCallback.NOT_IN_CALLBACK;
            this.mByteBuffer = null;
            diS();
        }
        this.lJa.t(th);
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void vh(boolean z) {
        synchronized (this.mLock) {
            a(UserCallback.READ);
            if (z && this.lJb >= 0) {
                throw new IllegalArgumentException("Non-chunked upload can't have last chunk");
            }
            int position = this.mByteBuffer.position();
            this.lJc -= position;
            if (this.lJc < 0 && this.lJb >= 0) {
                throw new IllegalArgumentException(String.format("Read upload data length %d exceeds expected length %d", Long.valueOf(this.lJb - this.lJc), Long.valueOf(this.lJb)));
            }
            this.mByteBuffer = null;
            this.lJf = UserCallback.NOT_IN_CALLBACK;
            diS();
            if (this.lJe != 0) {
                nativeOnReadSucceeded(this.lJe, position, z);
            }
        }
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void diQ() {
        synchronized (this.mLock) {
            a(UserCallback.REWIND);
            this.lJf = UserCallback.NOT_IN_CALLBACK;
            this.lJc = this.lJb;
            if (this.lJe != 0) {
                nativeOnRewindSucceeded(this.lJe);
            }
        }
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void o(Exception exc) {
        synchronized (this.mLock) {
            a(UserCallback.REWIND);
            onError(exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(Runnable runnable) {
        try {
            this.mExecutor.execute(runnable);
        } catch (Throwable th) {
            this.lJa.t(th);
        }
    }

    private void diR() {
        synchronized (this.mLock) {
            if (this.lJf == UserCallback.READ) {
                this.lJg = true;
            } else if (this.lJe != 0) {
                nativeDestroy(this.lJe);
                this.lJe = 0L;
                if (this.lIO != null) {
                    this.lIO.run();
                }
                A(new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            CronetUploadDataStream.this.lIZ.close();
                        } catch (IOException e) {
                            Log.e("CronetUploadDataStream", "Exception thrown when closing", e);
                        }
                    }
                });
            }
        }
    }

    private void diS() {
        synchronized (this.mLock) {
            if (this.lJf == UserCallback.READ) {
                throw new IllegalStateException("Method should not be called when read has not completed.");
            }
            if (this.lJg) {
                diR();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void diT() {
        synchronized (this.mLock) {
            this.lJf = UserCallback.GET_LENGTH;
        }
        try {
            this.lJb = this.lIZ.getLength();
            this.lJc = this.lJb;
        } catch (Throwable th) {
            onError(th);
        }
        synchronized (this.mLock) {
            this.lJf = UserCallback.NOT_IN_CALLBACK;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fx(long j) {
        synchronized (this.mLock) {
            this.lJe = nativeAttachUploadDataToRequest(j, this.lJb);
        }
    }
}
