package com.baidu.turbonet.net;

import com.baidu.turbonet.base.annotations.CalledByNative;
import com.baidu.turbonet.base.annotations.JNINamespace;
import com.baidu.turbonet.base.annotations.NativeClassQualifiedName;
import com.baidu.turbonet.net.BidirectionalStream;
import com.baidu.turbonet.net.UrlResponseInfo;
import java.nio.ByteBuffer;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import javax.annotation.concurrent.GuardedBy;
@JNINamespace
/* loaded from: classes5.dex */
public class CronetBidirectionalStream extends BidirectionalStream {

    /* renamed from: a  reason: collision with root package name */
    public final CronetUrlRequestContext f22229a;

    /* renamed from: b  reason: collision with root package name */
    public final Executor f22230b;

    /* renamed from: c  reason: collision with root package name */
    public final BidirectionalStream.Callback f22231c;

    /* renamed from: d  reason: collision with root package name */
    public final String f22232d;

    /* renamed from: e  reason: collision with root package name */
    public final String f22233e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f22234f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f22235g;
    @GuardedBy("mNativeStreamLock")

    /* renamed from: h  reason: collision with root package name */
    public LinkedList<ByteBuffer> f22236h;
    @GuardedBy("mNativeStreamLock")

    /* renamed from: i  reason: collision with root package name */
    public LinkedList<ByteBuffer> f22237i;
    @GuardedBy("mNativeStreamLock")
    public boolean j;
    @GuardedBy("mNativeStreamLock")
    public boolean k;
    @GuardedBy("mNativeStreamLock")
    public long l;
    @GuardedBy("mNativeStreamLock")
    public State m;
    @GuardedBy("mNativeStreamLock")
    public State n;
    public UrlResponseInfo o;
    public f p;
    public Runnable q;

    /* loaded from: classes5.dex */
    public enum State {
        NOT_STARTED,
        STARTED,
        WAITING_FOR_READ,
        READING,
        READING_DONE,
        CANCELED,
        ERROR,
        SUCCESS,
        WAITING_FOR_FLUSH,
        WRITING,
        WRITING_DONE
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f22238e;

        public a(boolean z) {
            this.f22238e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (CronetBidirectionalStream.this.f22235g) {
                if (CronetBidirectionalStream.this.x()) {
                    return;
                }
                CronetBidirectionalStream.this.k = this.f22238e;
                CronetBidirectionalStream.this.m = State.WAITING_FOR_READ;
                if (!CronetBidirectionalStream.s(CronetBidirectionalStream.this.f22233e) && CronetBidirectionalStream.this.k) {
                    CronetBidirectionalStream.this.n = State.WRITING_DONE;
                } else {
                    CronetBidirectionalStream.this.n = State.WAITING_FOR_FLUSH;
                }
                try {
                    CronetBidirectionalStream.this.f22231c.f(CronetBidirectionalStream.this);
                } catch (Exception e2) {
                    CronetBidirectionalStream.this.z(e2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (CronetBidirectionalStream.this.f22235g) {
                if (CronetBidirectionalStream.this.x()) {
                    return;
                }
                CronetBidirectionalStream.this.m = State.WAITING_FOR_READ;
                try {
                    CronetBidirectionalStream.this.f22231c.d(CronetBidirectionalStream.this, CronetBidirectionalStream.this.o);
                } catch (Exception e2) {
                    CronetBidirectionalStream.this.z(e2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UrlResponseInfo.HeaderBlock f22241e;

        public c(UrlResponseInfo.HeaderBlock headerBlock) {
            this.f22241e = headerBlock;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (CronetBidirectionalStream.this.f22235g) {
                if (CronetBidirectionalStream.this.x()) {
                    return;
                }
                try {
                    CronetBidirectionalStream.this.f22231c.e(CronetBidirectionalStream.this, CronetBidirectionalStream.this.o, this.f22241e);
                } catch (Exception e2) {
                    CronetBidirectionalStream.this.z(e2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                CronetBidirectionalStream.this.f22231c.a(CronetBidirectionalStream.this, CronetBidirectionalStream.this.o);
            } catch (Exception e2) {
                d.a.o0.a.a.c("ChromiumNetwork", "Exception in onCanceled method", e2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TurbonetException f22244e;

        public e(TurbonetException turbonetException) {
            this.f22244e = turbonetException;
        }

        @Override // java.lang.Runnable
        public void run() {
            CronetBidirectionalStream.this.u(this.f22244e);
        }
    }

    /* loaded from: classes5.dex */
    public final class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public ByteBuffer f22246e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f22247f;

        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ByteBuffer byteBuffer = this.f22246e;
                this.f22246e = null;
                synchronized (CronetBidirectionalStream.this.f22235g) {
                    if (CronetBidirectionalStream.this.x()) {
                        return;
                    }
                    boolean z = false;
                    if (this.f22247f) {
                        CronetBidirectionalStream.this.m = State.READING_DONE;
                        if (CronetBidirectionalStream.this.n == State.WRITING_DONE) {
                            z = true;
                        }
                    } else {
                        CronetBidirectionalStream.this.m = State.WAITING_FOR_READ;
                    }
                    CronetBidirectionalStream.this.f22231c.c(CronetBidirectionalStream.this, CronetBidirectionalStream.this.o, byteBuffer, this.f22247f);
                    if (z) {
                        CronetBidirectionalStream.this.y();
                    }
                }
            } catch (Exception e2) {
                CronetBidirectionalStream.this.z(e2);
            }
        }

        public /* synthetic */ f(CronetBidirectionalStream cronetBidirectionalStream, a aVar) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public final class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public ByteBuffer f22249e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f22250f;

        public g(ByteBuffer byteBuffer, boolean z) {
            this.f22249e = byteBuffer;
            this.f22250f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ByteBuffer byteBuffer = this.f22249e;
                this.f22249e = null;
                synchronized (CronetBidirectionalStream.this.f22235g) {
                    if (CronetBidirectionalStream.this.x()) {
                        return;
                    }
                    boolean z = false;
                    if (this.f22250f) {
                        CronetBidirectionalStream.this.n = State.WRITING_DONE;
                        if (CronetBidirectionalStream.this.m == State.READING_DONE) {
                            z = true;
                        }
                    }
                    CronetBidirectionalStream.this.f22231c.h(CronetBidirectionalStream.this, CronetBidirectionalStream.this.o, byteBuffer, this.f22250f);
                    if (z) {
                        CronetBidirectionalStream.this.y();
                    }
                }
            } catch (Exception e2) {
                CronetBidirectionalStream.this.z(e2);
            }
        }
    }

    private native long nativeCreateBidirectionalStream(long j, boolean z);

    @NativeClassQualifiedName
    private native void nativeDestroy(long j, boolean z);

    @NativeClassQualifiedName
    private native boolean nativeReadData(long j, ByteBuffer byteBuffer, int i2, int i3);

    @NativeClassQualifiedName
    private native void nativeSendRequestHeaders(long j);

    @NativeClassQualifiedName
    private native int nativeStart(long j, String str, int i2, String str2, String[] strArr, boolean z);

    @NativeClassQualifiedName
    private native boolean nativeWritevData(long j, ByteBuffer[] byteBufferArr, int[] iArr, int[] iArr2, boolean z);

    @CalledByNative
    private void onCanceled() {
        A(new d());
    }

    @CalledByNative
    private void onError(int i2, int i3, int i4, String str, long j) {
        UrlResponseInfo urlResponseInfo = this.o;
        if (urlResponseInfo != null) {
            urlResponseInfo.j(j);
        }
        if (i2 == 11) {
            t(new QuicException("Exception in BidirectionalStream: " + str, i3, i4));
            return;
        }
        t(new TurbonetException("Exception in BidirectionalStream: " + str, i2, i3));
    }

    @CalledByNative
    private void onReadCompleted(ByteBuffer byteBuffer, int i2, int i3, int i4, long j) {
        int i5;
        this.o.j(j);
        if (byteBuffer.position() != i3 || byteBuffer.limit() != i4) {
            t(new TurbonetException("ByteBuffer modified externally during read", null));
        } else if (i2 >= 0 && (i5 = i3 + i2) <= i4) {
            byteBuffer.position(i5);
            f fVar = this.p;
            fVar.f22246e = byteBuffer;
            fVar.f22247f = i2 == 0;
            A(this.p);
        } else {
            t(new TurbonetException("Invalid number of bytes read", null));
        }
    }

    @CalledByNative
    private void onResponseHeadersReceived(int i2, String str, String[] strArr, long j) {
        try {
            this.o = B(i2, str, strArr, j);
            A(new b());
        } catch (Exception unused) {
            t(new TurbonetException("Cannot prepare ResponseInfo", null));
        }
    }

    @CalledByNative
    private void onResponseTrailersReceived(String[] strArr) {
        A(new c(new UrlResponseInfo.HeaderBlock(w(strArr))));
    }

    @CalledByNative
    private void onStreamReady(boolean z) {
        A(new a(z));
    }

    @CalledByNative
    private void onWritevCompleted(ByteBuffer[] byteBufferArr, int[] iArr, int[] iArr2, boolean z) {
        synchronized (this.f22235g) {
            this.n = State.WAITING_FOR_FLUSH;
            if (!this.f22237i.isEmpty()) {
                C();
            }
        }
        for (int i2 = 0; i2 < byteBufferArr.length; i2++) {
            ByteBuffer byteBuffer = byteBufferArr[i2];
            if (byteBuffer.position() == iArr[i2] && byteBuffer.limit() == iArr2[i2]) {
                byteBuffer.position(byteBuffer.limit());
                boolean z2 = true;
                if (!z || i2 != byteBufferArr.length - 1) {
                    z2 = false;
                }
                A(new g(byteBuffer, z2));
            } else {
                t(new TurbonetException("ByteBuffer modified externally during write", null));
                return;
            }
        }
    }

    public static boolean s(String str) {
        return (str.equals("GET") || str.equals("HEAD")) ? false : true;
    }

    public static ArrayList<Map.Entry<String, String>> w(String[] strArr) {
        ArrayList<Map.Entry<String, String>> arrayList = new ArrayList<>(strArr.length / 2);
        for (int i2 = 0; i2 < strArr.length; i2 += 2) {
            arrayList.add(new AbstractMap.SimpleImmutableEntry(strArr[i2], strArr[i2 + 1]));
        }
        return arrayList;
    }

    public final void A(Runnable runnable) {
        try {
            this.f22230b.execute(runnable);
        } catch (RejectedExecutionException e2) {
            d.a.o0.a.a.c("ChromiumNetwork", "Exception posting task to executor", e2);
            synchronized (this.f22235g) {
                State state = State.ERROR;
                this.n = state;
                this.m = state;
                r(false);
            }
        }
    }

    public final UrlResponseInfo B(int i2, String str, String[] strArr, long j) {
        UrlResponseInfo urlResponseInfo = new UrlResponseInfo(Arrays.asList(this.f22232d), i2, "", w(strArr), false, str, null);
        urlResponseInfo.j(j);
        return urlResponseInfo;
    }

    public final void C() {
        int size = this.f22237i.size();
        ByteBuffer[] byteBufferArr = new ByteBuffer[size];
        int[] iArr = new int[size];
        int[] iArr2 = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            ByteBuffer poll = this.f22237i.poll();
            byteBufferArr[i2] = poll;
            iArr[i2] = poll.position();
            iArr2[i2] = poll.limit();
        }
        this.n = State.WRITING;
        if (nativeWritevData(this.l, byteBufferArr, iArr, iArr2, this.j && this.f22236h.isEmpty())) {
            return;
        }
        this.n = State.WAITING_FOR_FLUSH;
        throw new IllegalArgumentException("Unable to call native writev.");
    }

    @Override // com.baidu.turbonet.net.BidirectionalStream
    public void a(ByteBuffer byteBuffer) {
        synchronized (this.f22235g) {
            d.a.o0.b.b.b(byteBuffer);
            d.a.o0.b.b.a(byteBuffer);
            if (this.m == State.WAITING_FOR_READ) {
                if (x()) {
                    return;
                }
                if (this.p == null) {
                    this.p = new f(this, null);
                }
                this.m = State.READING;
                if (nativeReadData(this.l, byteBuffer, byteBuffer.position(), byteBuffer.limit())) {
                    return;
                }
                this.m = State.WAITING_FOR_READ;
                throw new IllegalArgumentException("Unable to call native read");
            }
            throw new IllegalStateException("Unexpected read attempt.");
        }
    }

    @Override // com.baidu.turbonet.net.BidirectionalStream
    public void b(ByteBuffer byteBuffer, boolean z) {
        synchronized (this.f22235g) {
            d.a.o0.b.b.a(byteBuffer);
            if (!byteBuffer.hasRemaining() && !z) {
                throw new IllegalArgumentException("Empty buffer before end of stream.");
            }
            if (!this.j) {
                if (x()) {
                    return;
                }
                this.f22236h.add(byteBuffer);
                if (z) {
                    this.j = true;
                }
                if (!this.f22234f) {
                    v();
                }
                return;
            }
            throw new IllegalArgumentException("Write after writing end of stream.");
        }
    }

    @GuardedBy("mNativeStreamLock")
    public final void r(boolean z) {
        d.a.o0.a.a.h("ChromiumNetwork", "destroyNativeStreamLocked " + toString(), new Object[0]);
        long j = this.l;
        if (j == 0) {
            return;
        }
        nativeDestroy(j, z);
        this.l = 0L;
        this.f22229a.s();
        Runnable runnable = this.q;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void t(TurbonetException turbonetException) {
        A(new e(turbonetException));
    }

    public final void u(TurbonetException turbonetException) {
        synchronized (this.f22235g) {
            if (x()) {
                return;
            }
            State state = State.ERROR;
            this.n = state;
            this.m = state;
            r(false);
            try {
                this.f22231c.b(this, this.o, turbonetException);
            } catch (Exception e2) {
                d.a.o0.a.a.c("ChromiumNetwork", "Exception notifying of failed request", e2);
            }
        }
    }

    public final void v() {
        if (x()) {
            return;
        }
        State state = this.n;
        if (state == State.WAITING_FOR_FLUSH || state == State.WRITING) {
            if (this.f22236h.isEmpty() && this.f22237i.isEmpty()) {
                if (this.k) {
                    return;
                }
                this.k = true;
                nativeSendRequestHeaders(this.l);
                if (s(this.f22233e)) {
                    return;
                }
                this.n = State.WRITING_DONE;
                return;
            }
            if (!this.f22236h.isEmpty()) {
                this.f22237i.addAll(this.f22236h);
                this.f22236h.clear();
            }
            if (this.n == State.WRITING) {
                return;
            }
            C();
        }
    }

    @GuardedBy("mNativeStreamLock")
    public final boolean x() {
        return this.m != State.NOT_STARTED && this.l == 0;
    }

    public final void y() {
        synchronized (this.f22235g) {
            if (x()) {
                return;
            }
            if (this.n == State.WRITING_DONE && this.m == State.READING_DONE) {
                State state = State.SUCCESS;
                this.n = state;
                this.m = state;
                r(false);
                try {
                    this.f22231c.g(this, this.o);
                } catch (Exception e2) {
                    d.a.o0.a.a.c("ChromiumNetwork", "Exception in onSucceeded method", e2);
                }
            }
        }
    }

    public final void z(Exception exc) {
        TurbonetException turbonetException = new TurbonetException("CalledByNative method has thrown an exception", exc);
        d.a.o0.a.a.c("ChromiumNetwork", "Exception in CalledByNative method", exc);
        u(turbonetException);
    }
}
