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
/* loaded from: classes14.dex */
public final class CronetUploadDataStream implements UploadDataSink {
    private final Executor mExecutor;
    private Runnable oCk;
    private final UploadDataProvider oCv;
    private final CronetUrlRequest oCw;
    private long oCx;
    private long oCy;
    private final Runnable oCz = new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (CronetUploadDataStream.this.mLock) {
                if (CronetUploadDataStream.this.oCA != 0) {
                    CronetUploadDataStream.this.a(UserCallback.NOT_IN_CALLBACK);
                    if (CronetUploadDataStream.this.mByteBuffer == null) {
                        throw new IllegalStateException("Unexpected readData call. Buffer is null");
                    }
                    CronetUploadDataStream.this.oCB = UserCallback.READ;
                    try {
                        CronetUploadDataStream.this.oCv.a(CronetUploadDataStream.this, CronetUploadDataStream.this.mByteBuffer);
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
    private long oCA = 0;
    @GuardedBy("mLock")
    private UserCallback oCB = UserCallback.NOT_IN_CALLBACK;
    @GuardedBy("mLock")
    private boolean oCC = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
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
        this.oCv = uploadDataProvider;
        this.oCw = cronetUrlRequest;
    }

    @CalledByNative
    void readData(ByteBuffer byteBuffer) {
        this.mByteBuffer = byteBuffer;
        z(this.oCz);
    }

    @CalledByNative
    void rewind() {
        z(new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUploadDataStream.this.mLock) {
                    if (CronetUploadDataStream.this.oCA != 0) {
                        CronetUploadDataStream.this.a(UserCallback.NOT_IN_CALLBACK);
                        CronetUploadDataStream.this.oCB = UserCallback.REWIND;
                        try {
                            CronetUploadDataStream.this.oCv.a(CronetUploadDataStream.this);
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
        if (this.oCB != userCallback) {
            throw new IllegalStateException("Expected " + userCallback + ", but was " + this.oCB);
        }
    }

    @CalledByNative
    void onUploadDataStreamDestroyed() {
        ehd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(Throwable th) {
        synchronized (this.mLock) {
            if (this.oCB == UserCallback.NOT_IN_CALLBACK) {
                throw new IllegalStateException("There is no read or rewind or length check in progress.");
            }
            this.oCB = UserCallback.NOT_IN_CALLBACK;
            this.mByteBuffer = null;
            ehe();
        }
        this.oCw.s(th);
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void Ac(boolean z) {
        synchronized (this.mLock) {
            a(UserCallback.READ);
            if (z && this.oCx >= 0) {
                throw new IllegalArgumentException("Non-chunked upload can't have last chunk");
            }
            int position = this.mByteBuffer.position();
            this.oCy -= position;
            if (this.oCy < 0 && this.oCx >= 0) {
                throw new IllegalArgumentException(String.format("Read upload data length %d exceeds expected length %d", Long.valueOf(this.oCx - this.oCy), Long.valueOf(this.oCx)));
            }
            this.mByteBuffer = null;
            this.oCB = UserCallback.NOT_IN_CALLBACK;
            ehe();
            if (this.oCA != 0) {
                nativeOnReadSucceeded(this.oCA, position, z);
            }
        }
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void ehc() {
        synchronized (this.mLock) {
            a(UserCallback.REWIND);
            this.oCB = UserCallback.NOT_IN_CALLBACK;
            this.oCy = this.oCx;
            if (this.oCA != 0) {
                nativeOnRewindSucceeded(this.oCA);
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
            this.oCw.s(th);
        }
    }

    private void ehd() {
        synchronized (this.mLock) {
            if (this.oCB == UserCallback.READ) {
                this.oCC = true;
            } else if (this.oCA != 0) {
                nativeDestroy(this.oCA);
                this.oCA = 0L;
                if (this.oCk != null) {
                    this.oCk.run();
                }
                z(new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            CronetUploadDataStream.this.oCv.close();
                        } catch (IOException e) {
                            Log.e("CronetUploadDataStream", "Exception thrown when closing", e);
                        }
                    }
                });
            }
        }
    }

    private void ehe() {
        synchronized (this.mLock) {
            if (this.oCB == UserCallback.READ) {
                throw new IllegalStateException("Method should not be called when read has not completed.");
            }
            if (this.oCC) {
                ehd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ehf() {
        synchronized (this.mLock) {
            this.oCB = UserCallback.GET_LENGTH;
        }
        try {
            this.oCx = this.oCv.getLength();
            this.oCy = this.oCx;
        } catch (Throwable th) {
            onError(th);
        }
        synchronized (this.mLock) {
            this.oCB = UserCallback.NOT_IN_CALLBACK;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hU(long j) {
        synchronized (this.mLock) {
            this.oCA = nativeAttachUploadDataToRequest(j, this.oCx);
        }
    }
}
