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
    private Runnable oCi;
    private final UploadDataProvider oCt;
    private final CronetUrlRequest oCu;
    private long oCv;
    private long oCw;
    private final Runnable oCx = new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (CronetUploadDataStream.this.mLock) {
                if (CronetUploadDataStream.this.oCy != 0) {
                    CronetUploadDataStream.this.a(UserCallback.NOT_IN_CALLBACK);
                    if (CronetUploadDataStream.this.mByteBuffer == null) {
                        throw new IllegalStateException("Unexpected readData call. Buffer is null");
                    }
                    CronetUploadDataStream.this.oCz = UserCallback.READ;
                    try {
                        CronetUploadDataStream.this.oCt.a(CronetUploadDataStream.this, CronetUploadDataStream.this.mByteBuffer);
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
    private long oCy = 0;
    @GuardedBy("mLock")
    private UserCallback oCz = UserCallback.NOT_IN_CALLBACK;
    @GuardedBy("mLock")
    private boolean oCA = false;

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
        this.oCt = uploadDataProvider;
        this.oCu = cronetUrlRequest;
    }

    @CalledByNative
    void readData(ByteBuffer byteBuffer) {
        this.mByteBuffer = byteBuffer;
        z(this.oCx);
    }

    @CalledByNative
    void rewind() {
        z(new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUploadDataStream.this.mLock) {
                    if (CronetUploadDataStream.this.oCy != 0) {
                        CronetUploadDataStream.this.a(UserCallback.NOT_IN_CALLBACK);
                        CronetUploadDataStream.this.oCz = UserCallback.REWIND;
                        try {
                            CronetUploadDataStream.this.oCt.a(CronetUploadDataStream.this);
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
        if (this.oCz != userCallback) {
            throw new IllegalStateException("Expected " + userCallback + ", but was " + this.oCz);
        }
    }

    @CalledByNative
    void onUploadDataStreamDestroyed() {
        ehc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(Throwable th) {
        synchronized (this.mLock) {
            if (this.oCz == UserCallback.NOT_IN_CALLBACK) {
                throw new IllegalStateException("There is no read or rewind or length check in progress.");
            }
            this.oCz = UserCallback.NOT_IN_CALLBACK;
            this.mByteBuffer = null;
            ehd();
        }
        this.oCu.s(th);
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void Ac(boolean z) {
        synchronized (this.mLock) {
            a(UserCallback.READ);
            if (z && this.oCv >= 0) {
                throw new IllegalArgumentException("Non-chunked upload can't have last chunk");
            }
            int position = this.mByteBuffer.position();
            this.oCw -= position;
            if (this.oCw < 0 && this.oCv >= 0) {
                throw new IllegalArgumentException(String.format("Read upload data length %d exceeds expected length %d", Long.valueOf(this.oCv - this.oCw), Long.valueOf(this.oCv)));
            }
            this.mByteBuffer = null;
            this.oCz = UserCallback.NOT_IN_CALLBACK;
            ehd();
            if (this.oCy != 0) {
                nativeOnReadSucceeded(this.oCy, position, z);
            }
        }
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void ehb() {
        synchronized (this.mLock) {
            a(UserCallback.REWIND);
            this.oCz = UserCallback.NOT_IN_CALLBACK;
            this.oCw = this.oCv;
            if (this.oCy != 0) {
                nativeOnRewindSucceeded(this.oCy);
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
            this.oCu.s(th);
        }
    }

    private void ehc() {
        synchronized (this.mLock) {
            if (this.oCz == UserCallback.READ) {
                this.oCA = true;
            } else if (this.oCy != 0) {
                nativeDestroy(this.oCy);
                this.oCy = 0L;
                if (this.oCi != null) {
                    this.oCi.run();
                }
                z(new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            CronetUploadDataStream.this.oCt.close();
                        } catch (IOException e) {
                            Log.e("CronetUploadDataStream", "Exception thrown when closing", e);
                        }
                    }
                });
            }
        }
    }

    private void ehd() {
        synchronized (this.mLock) {
            if (this.oCz == UserCallback.READ) {
                throw new IllegalStateException("Method should not be called when read has not completed.");
            }
            if (this.oCA) {
                ehc();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ehe() {
        synchronized (this.mLock) {
            this.oCz = UserCallback.GET_LENGTH;
        }
        try {
            this.oCv = this.oCt.getLength();
            this.oCw = this.oCv;
        } catch (Throwable th) {
            onError(th);
        }
        synchronized (this.mLock) {
            this.oCz = UserCallback.NOT_IN_CALLBACK;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hU(long j) {
        synchronized (this.mLock) {
            this.oCy = nativeAttachUploadDataToRequest(j, this.oCv);
        }
    }
}
