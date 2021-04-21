package com.baidu.turbonet.net;

import android.util.Log;
import com.baidu.turbonet.base.annotations.CalledByNative;
import com.baidu.turbonet.base.annotations.JNINamespace;
import com.baidu.turbonet.base.annotations.NativeClassQualifiedName;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
@JNINamespace
/* loaded from: classes5.dex */
public final class CronetUploadDataStream implements UploadDataSink {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f22391a;

    /* renamed from: b  reason: collision with root package name */
    public final UploadDataProvider f22392b;

    /* renamed from: c  reason: collision with root package name */
    public final CronetUrlRequest f22393c;

    /* renamed from: d  reason: collision with root package name */
    public long f22394d;

    /* renamed from: e  reason: collision with root package name */
    public long f22395e;

    /* renamed from: f  reason: collision with root package name */
    public final Runnable f22396f = new a();

    /* renamed from: g  reason: collision with root package name */
    public ByteBuffer f22397g = null;

    /* renamed from: h  reason: collision with root package name */
    public final Object f22398h = new Object();
    @GuardedBy("mLock")
    public long i = 0;
    @GuardedBy("mLock")
    public UserCallback j = UserCallback.NOT_IN_CALLBACK;
    @GuardedBy("mLock")
    public boolean k = false;
    public Runnable l;

    /* loaded from: classes5.dex */
    public enum UserCallback {
        READ,
        REWIND,
        GET_LENGTH,
        NOT_IN_CALLBACK
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (CronetUploadDataStream.this.f22398h) {
                if (CronetUploadDataStream.this.i == 0) {
                    return;
                }
                CronetUploadDataStream.this.l(UserCallback.NOT_IN_CALLBACK);
                if (CronetUploadDataStream.this.f22397g != null) {
                    CronetUploadDataStream.this.j = UserCallback.READ;
                    try {
                        CronetUploadDataStream.this.f22392b.o(CronetUploadDataStream.this, CronetUploadDataStream.this.f22397g);
                        return;
                    } catch (Exception e2) {
                        CronetUploadDataStream.this.p(e2);
                        return;
                    }
                }
                throw new IllegalStateException("Unexpected readData call. Buffer is null");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (CronetUploadDataStream.this.f22398h) {
                if (CronetUploadDataStream.this.i == 0) {
                    return;
                }
                CronetUploadDataStream.this.l(UserCallback.NOT_IN_CALLBACK);
                CronetUploadDataStream.this.j = UserCallback.REWIND;
                try {
                    CronetUploadDataStream.this.f22392b.p(CronetUploadDataStream.this);
                } catch (Exception e2) {
                    CronetUploadDataStream.this.p(e2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                CronetUploadDataStream.this.f22392b.close();
            } catch (IOException e2) {
                Log.e(aegon.chrome.net.impl.CronetUploadDataStream.TAG, "Exception thrown when closing", e2);
            }
        }
    }

    public CronetUploadDataStream(UploadDataProvider uploadDataProvider, Executor executor, CronetUrlRequest cronetUrlRequest) {
        this.f22391a = executor;
        this.f22392b = uploadDataProvider;
        this.f22393c = cronetUrlRequest;
    }

    private native long nativeAttachUploadDataToRequest(long j, long j2);

    private native long nativeCreateAdapterForTesting();

    private native long nativeCreateUploadDataStreamForTesting(long j, long j2);

    @NativeClassQualifiedName
    public static native void nativeDestroy(long j);

    @NativeClassQualifiedName
    private native void nativeOnReadSucceeded(long j, int i, boolean z);

    @NativeClassQualifiedName
    private native void nativeOnRewindSucceeded(long j);

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void a(Exception exc) {
        synchronized (this.f22398h) {
            l(UserCallback.REWIND);
            p(exc);
        }
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void b() {
        synchronized (this.f22398h) {
            l(UserCallback.REWIND);
            this.j = UserCallback.NOT_IN_CALLBACK;
            this.f22395e = this.f22394d;
            if (this.i == 0) {
                return;
            }
            nativeOnRewindSucceeded(this.i);
        }
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void c(boolean z) {
        synchronized (this.f22398h) {
            l(UserCallback.READ);
            if (z && this.f22394d >= 0) {
                throw new IllegalArgumentException("Non-chunked upload can't have last chunk");
            }
            int position = this.f22397g.position();
            long j = this.f22395e - position;
            this.f22395e = j;
            if (j < 0 && this.f22394d >= 0) {
                throw new IllegalArgumentException(String.format("Read upload data length %d exceeds expected length %d", Long.valueOf(this.f22394d - this.f22395e), Long.valueOf(this.f22394d)));
            }
            this.f22397g = null;
            this.j = UserCallback.NOT_IN_CALLBACK;
            n();
            if (this.i == 0) {
                return;
            }
            nativeOnReadSucceeded(this.i, position, z);
        }
    }

    public void k(long j) {
        synchronized (this.f22398h) {
            this.i = nativeAttachUploadDataToRequest(j, this.f22394d);
        }
    }

    @GuardedBy("mLock")
    public final void l(UserCallback userCallback) {
        if (this.j == userCallback) {
            return;
        }
        throw new IllegalStateException("Expected " + userCallback + ", but was " + this.j);
    }

    public final void m() {
        synchronized (this.f22398h) {
            if (this.j == UserCallback.READ) {
                this.k = true;
            } else if (this.i == 0) {
            } else {
                nativeDestroy(this.i);
                this.i = 0L;
                if (this.l != null) {
                    this.l.run();
                }
                q(new c());
            }
        }
    }

    public final void n() {
        synchronized (this.f22398h) {
            if (this.j != UserCallback.READ) {
                if (this.k) {
                    m();
                }
            } else {
                throw new IllegalStateException("Method should not be called when read has not completed.");
            }
        }
    }

    public void o() {
        synchronized (this.f22398h) {
            this.j = UserCallback.GET_LENGTH;
        }
        try {
            long n = this.f22392b.n();
            this.f22394d = n;
            this.f22395e = n;
        } catch (Throwable th) {
            p(th);
        }
        synchronized (this.f22398h) {
            this.j = UserCallback.NOT_IN_CALLBACK;
        }
    }

    @CalledByNative
    public void onUploadDataStreamDestroyed() {
        m();
    }

    public final void p(Throwable th) {
        synchronized (this.f22398h) {
            if (this.j != UserCallback.NOT_IN_CALLBACK) {
                this.j = UserCallback.NOT_IN_CALLBACK;
                this.f22397g = null;
                n();
            } else {
                throw new IllegalStateException("There is no read or rewind or length check in progress.");
            }
        }
        this.f22393c.E(th);
    }

    public void q(Runnable runnable) {
        try {
            this.f22391a.execute(runnable);
        } catch (Throwable th) {
            this.f22393c.E(th);
        }
    }

    @CalledByNative
    public void readData(ByteBuffer byteBuffer) {
        this.f22397g = byteBuffer;
        q(this.f22396f);
    }

    @CalledByNative
    public void rewind() {
        q(new b());
    }
}
