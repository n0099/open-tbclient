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
    public final Executor f22361a;

    /* renamed from: b  reason: collision with root package name */
    public final UploadDataProvider f22362b;

    /* renamed from: c  reason: collision with root package name */
    public final CronetUrlRequest f22363c;

    /* renamed from: d  reason: collision with root package name */
    public long f22364d;

    /* renamed from: e  reason: collision with root package name */
    public long f22365e;

    /* renamed from: f  reason: collision with root package name */
    public final Runnable f22366f = new a();

    /* renamed from: g  reason: collision with root package name */
    public ByteBuffer f22367g = null;

    /* renamed from: h  reason: collision with root package name */
    public final Object f22368h = new Object();
    @GuardedBy("mLock")

    /* renamed from: i  reason: collision with root package name */
    public long f22369i = 0;
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
            synchronized (CronetUploadDataStream.this.f22368h) {
                if (CronetUploadDataStream.this.f22369i == 0) {
                    return;
                }
                CronetUploadDataStream.this.l(UserCallback.NOT_IN_CALLBACK);
                if (CronetUploadDataStream.this.f22367g != null) {
                    CronetUploadDataStream.this.j = UserCallback.READ;
                    try {
                        CronetUploadDataStream.this.f22362b.o(CronetUploadDataStream.this, CronetUploadDataStream.this.f22367g);
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
            synchronized (CronetUploadDataStream.this.f22368h) {
                if (CronetUploadDataStream.this.f22369i == 0) {
                    return;
                }
                CronetUploadDataStream.this.l(UserCallback.NOT_IN_CALLBACK);
                CronetUploadDataStream.this.j = UserCallback.REWIND;
                try {
                    CronetUploadDataStream.this.f22362b.p(CronetUploadDataStream.this);
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
                CronetUploadDataStream.this.f22362b.close();
            } catch (IOException e2) {
                Log.e(aegon.chrome.net.impl.CronetUploadDataStream.TAG, "Exception thrown when closing", e2);
            }
        }
    }

    public CronetUploadDataStream(UploadDataProvider uploadDataProvider, Executor executor, CronetUrlRequest cronetUrlRequest) {
        this.f22361a = executor;
        this.f22362b = uploadDataProvider;
        this.f22363c = cronetUrlRequest;
    }

    private native long nativeAttachUploadDataToRequest(long j, long j2);

    private native long nativeCreateAdapterForTesting();

    private native long nativeCreateUploadDataStreamForTesting(long j, long j2);

    @NativeClassQualifiedName
    public static native void nativeDestroy(long j);

    @NativeClassQualifiedName
    private native void nativeOnReadSucceeded(long j, int i2, boolean z);

    @NativeClassQualifiedName
    private native void nativeOnRewindSucceeded(long j);

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void a() {
        synchronized (this.f22368h) {
            l(UserCallback.REWIND);
            this.j = UserCallback.NOT_IN_CALLBACK;
            this.f22365e = this.f22364d;
            if (this.f22369i == 0) {
                return;
            }
            nativeOnRewindSucceeded(this.f22369i);
        }
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void b(Exception exc) {
        synchronized (this.f22368h) {
            l(UserCallback.REWIND);
            p(exc);
        }
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void c(boolean z) {
        synchronized (this.f22368h) {
            l(UserCallback.READ);
            if (z && this.f22364d >= 0) {
                throw new IllegalArgumentException("Non-chunked upload can't have last chunk");
            }
            int position = this.f22367g.position();
            long j = this.f22365e - position;
            this.f22365e = j;
            if (j < 0 && this.f22364d >= 0) {
                throw new IllegalArgumentException(String.format("Read upload data length %d exceeds expected length %d", Long.valueOf(this.f22364d - this.f22365e), Long.valueOf(this.f22364d)));
            }
            this.f22367g = null;
            this.j = UserCallback.NOT_IN_CALLBACK;
            n();
            if (this.f22369i == 0) {
                return;
            }
            nativeOnReadSucceeded(this.f22369i, position, z);
        }
    }

    public void k(long j) {
        synchronized (this.f22368h) {
            this.f22369i = nativeAttachUploadDataToRequest(j, this.f22364d);
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
        synchronized (this.f22368h) {
            if (this.j == UserCallback.READ) {
                this.k = true;
            } else if (this.f22369i == 0) {
            } else {
                nativeDestroy(this.f22369i);
                this.f22369i = 0L;
                if (this.l != null) {
                    this.l.run();
                }
                q(new c());
            }
        }
    }

    public final void n() {
        synchronized (this.f22368h) {
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
        synchronized (this.f22368h) {
            this.j = UserCallback.GET_LENGTH;
        }
        try {
            long n = this.f22362b.n();
            this.f22364d = n;
            this.f22365e = n;
        } catch (Throwable th) {
            p(th);
        }
        synchronized (this.f22368h) {
            this.j = UserCallback.NOT_IN_CALLBACK;
        }
    }

    @CalledByNative
    public void onUploadDataStreamDestroyed() {
        m();
    }

    public final void p(Throwable th) {
        synchronized (this.f22368h) {
            if (this.j != UserCallback.NOT_IN_CALLBACK) {
                this.j = UserCallback.NOT_IN_CALLBACK;
                this.f22367g = null;
                n();
            } else {
                throw new IllegalStateException("There is no read or rewind or length check in progress.");
            }
        }
        this.f22363c.E(th);
    }

    public void q(Runnable runnable) {
        try {
            this.f22361a.execute(runnable);
        } catch (Throwable th) {
            this.f22363c.E(th);
        }
    }

    @CalledByNative
    public void readData(ByteBuffer byteBuffer) {
        this.f22367g = byteBuffer;
        q(this.f22366f);
    }

    @CalledByNative
    public void rewind() {
        q(new b());
    }
}
