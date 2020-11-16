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
/* loaded from: classes12.dex */
public final class CronetUploadDataStream implements UploadDataSink {
    private final Executor mExecutor;
    private Runnable onk;
    private final UploadDataProvider onv;
    private final CronetUrlRequest onw;
    private long onx;
    private long ony;
    private final Runnable onz = new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (CronetUploadDataStream.this.mLock) {
                if (CronetUploadDataStream.this.onA != 0) {
                    CronetUploadDataStream.this.a(UserCallback.NOT_IN_CALLBACK);
                    if (CronetUploadDataStream.this.mByteBuffer == null) {
                        throw new IllegalStateException("Unexpected readData call. Buffer is null");
                    }
                    CronetUploadDataStream.this.onB = UserCallback.READ;
                    try {
                        CronetUploadDataStream.this.onv.a(CronetUploadDataStream.this, CronetUploadDataStream.this.mByteBuffer);
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
    private long onA = 0;
    @GuardedBy("mLock")
    private UserCallback onB = UserCallback.NOT_IN_CALLBACK;
    @GuardedBy("mLock")
    private boolean onC = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
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
        this.onv = uploadDataProvider;
        this.onw = cronetUrlRequest;
    }

    @CalledByNative
    void readData(ByteBuffer byteBuffer) {
        this.mByteBuffer = byteBuffer;
        z(this.onz);
    }

    @CalledByNative
    void rewind() {
        z(new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUploadDataStream.this.mLock) {
                    if (CronetUploadDataStream.this.onA != 0) {
                        CronetUploadDataStream.this.a(UserCallback.NOT_IN_CALLBACK);
                        CronetUploadDataStream.this.onB = UserCallback.REWIND;
                        try {
                            CronetUploadDataStream.this.onv.a(CronetUploadDataStream.this);
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
        if (this.onB != userCallback) {
            throw new IllegalStateException("Expected " + userCallback + ", but was " + this.onB);
        }
    }

    @CalledByNative
    void onUploadDataStreamDestroyed() {
        ebx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(Throwable th) {
        synchronized (this.mLock) {
            if (this.onB == UserCallback.NOT_IN_CALLBACK) {
                throw new IllegalStateException("There is no read or rewind or length check in progress.");
            }
            this.onB = UserCallback.NOT_IN_CALLBACK;
            this.mByteBuffer = null;
            eby();
        }
        this.onw.s(th);
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void zy(boolean z) {
        synchronized (this.mLock) {
            a(UserCallback.READ);
            if (z && this.onx >= 0) {
                throw new IllegalArgumentException("Non-chunked upload can't have last chunk");
            }
            int position = this.mByteBuffer.position();
            this.ony -= position;
            if (this.ony < 0 && this.onx >= 0) {
                throw new IllegalArgumentException(String.format("Read upload data length %d exceeds expected length %d", Long.valueOf(this.onx - this.ony), Long.valueOf(this.onx)));
            }
            this.mByteBuffer = null;
            this.onB = UserCallback.NOT_IN_CALLBACK;
            eby();
            if (this.onA != 0) {
                nativeOnReadSucceeded(this.onA, position, z);
            }
        }
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void ebw() {
        synchronized (this.mLock) {
            a(UserCallback.REWIND);
            this.onB = UserCallback.NOT_IN_CALLBACK;
            this.ony = this.onx;
            if (this.onA != 0) {
                nativeOnRewindSucceeded(this.onA);
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
            this.onw.s(th);
        }
    }

    private void ebx() {
        synchronized (this.mLock) {
            if (this.onB == UserCallback.READ) {
                this.onC = true;
            } else if (this.onA != 0) {
                nativeDestroy(this.onA);
                this.onA = 0L;
                if (this.onk != null) {
                    this.onk.run();
                }
                z(new Runnable() { // from class: com.baidu.turbonet.net.CronetUploadDataStream.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            CronetUploadDataStream.this.onv.close();
                        } catch (IOException e) {
                            Log.e("CronetUploadDataStream", "Exception thrown when closing", e);
                        }
                    }
                });
            }
        }
    }

    private void eby() {
        synchronized (this.mLock) {
            if (this.onB == UserCallback.READ) {
                throw new IllegalStateException("Method should not be called when read has not completed.");
            }
            if (this.onC) {
                ebx();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ebz() {
        synchronized (this.mLock) {
            this.onB = UserCallback.GET_LENGTH;
        }
        try {
            this.onx = this.onv.getLength();
            this.ony = this.onx;
        } catch (Throwable th) {
            onError(th);
        }
        synchronized (this.mLock) {
            this.onB = UserCallback.NOT_IN_CALLBACK;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hp(long j) {
        synchronized (this.mLock) {
            this.onA = nativeAttachUploadDataToRequest(j, this.onx);
        }
    }
}
