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
    private Runnable mzh;
    private final UploadDataProvider mzs;
    private final CronetUrlRequest mzt;
    private long mzu;
    private long mzv;
    private final Runnable mzw = new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (CronetUploadDataStream.this.mLock) {
                if (CronetUploadDataStream.this.mzx != 0) {
                    CronetUploadDataStream.this.a(UserCallback.NOT_IN_CALLBACK);
                    if (CronetUploadDataStream.this.mByteBuffer == null) {
                        throw new IllegalStateException("Unexpected readData call. Buffer is null");
                    }
                    CronetUploadDataStream.this.mzy = UserCallback.READ;
                    try {
                        CronetUploadDataStream.this.mzs.a(CronetUploadDataStream.this, CronetUploadDataStream.this.mByteBuffer);
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
    private long mzx = 0;
    @GuardedBy("mLock")
    private UserCallback mzy = UserCallback.NOT_IN_CALLBACK;
    @GuardedBy("mLock")
    private boolean mzz = false;

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
        this.mzs = uploadDataProvider;
        this.mzt = cronetUrlRequest;
    }

    @CalledByNative
    void readData(ByteBuffer byteBuffer) {
        this.mByteBuffer = byteBuffer;
        C(this.mzw);
    }

    @CalledByNative
    void rewind() {
        C(new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUploadDataStream.this.mLock) {
                    if (CronetUploadDataStream.this.mzx != 0) {
                        CronetUploadDataStream.this.a(UserCallback.NOT_IN_CALLBACK);
                        CronetUploadDataStream.this.mzy = UserCallback.REWIND;
                        try {
                            CronetUploadDataStream.this.mzs.a(CronetUploadDataStream.this);
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
        if (this.mzy != userCallback) {
            throw new IllegalStateException("Expected " + userCallback + ", but was " + this.mzy);
        }
    }

    @CalledByNative
    void onUploadDataStreamDestroyed() {
        dve();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(Throwable th) {
        synchronized (this.mLock) {
            if (this.mzy == UserCallback.NOT_IN_CALLBACK) {
                throw new IllegalStateException("There is no read or rewind or length check in progress.");
            }
            this.mzy = UserCallback.NOT_IN_CALLBACK;
            this.mByteBuffer = null;
            dvf();
        }
        this.mzt.u(th);
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void wd(boolean z) {
        synchronized (this.mLock) {
            a(UserCallback.READ);
            if (z && this.mzu >= 0) {
                throw new IllegalArgumentException("Non-chunked upload can't have last chunk");
            }
            int position = this.mByteBuffer.position();
            this.mzv -= position;
            if (this.mzv < 0 && this.mzu >= 0) {
                throw new IllegalArgumentException(String.format("Read upload data length %d exceeds expected length %d", Long.valueOf(this.mzu - this.mzv), Long.valueOf(this.mzu)));
            }
            this.mByteBuffer = null;
            this.mzy = UserCallback.NOT_IN_CALLBACK;
            dvf();
            if (this.mzx != 0) {
                nativeOnReadSucceeded(this.mzx, position, z);
            }
        }
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void dvd() {
        synchronized (this.mLock) {
            a(UserCallback.REWIND);
            this.mzy = UserCallback.NOT_IN_CALLBACK;
            this.mzv = this.mzu;
            if (this.mzx != 0) {
                nativeOnRewindSucceeded(this.mzx);
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
            this.mzt.u(th);
        }
    }

    private void dve() {
        synchronized (this.mLock) {
            if (this.mzy == UserCallback.READ) {
                this.mzz = true;
            } else if (this.mzx != 0) {
                nativeDestroy(this.mzx);
                this.mzx = 0L;
                if (this.mzh != null) {
                    this.mzh.run();
                }
                C(new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            CronetUploadDataStream.this.mzs.close();
                        } catch (IOException e) {
                            Log.e("CronetUploadDataStream", "Exception thrown when closing", e);
                        }
                    }
                });
            }
        }
    }

    private void dvf() {
        synchronized (this.mLock) {
            if (this.mzy == UserCallback.READ) {
                throw new IllegalStateException("Method should not be called when read has not completed.");
            }
            if (this.mzz) {
                dve();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dvg() {
        synchronized (this.mLock) {
            this.mzy = UserCallback.GET_LENGTH;
        }
        try {
            this.mzu = this.mzs.getLength();
            this.mzv = this.mzu;
        } catch (Throwable th) {
            onError(th);
        }
        synchronized (this.mLock) {
            this.mzy = UserCallback.NOT_IN_CALLBACK;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fC(long j) {
        synchronized (this.mLock) {
            this.mzx = nativeAttachUploadDataToRequest(j, this.mzu);
        }
    }
}
