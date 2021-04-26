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
    public final CronetUrlRequestContext f23055a;

    /* renamed from: b  reason: collision with root package name */
    public final Executor f23056b;

    /* renamed from: c  reason: collision with root package name */
    public final BidirectionalStream.Callback f23057c;

    /* renamed from: d  reason: collision with root package name */
    public final String f23058d;

    /* renamed from: e  reason: collision with root package name */
    public final String f23059e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f23060f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f23061g;
    @GuardedBy("mNativeStreamLock")

    /* renamed from: h  reason: collision with root package name */
    public LinkedList<ByteBuffer> f23062h;
    @GuardedBy("mNativeStreamLock")

    /* renamed from: i  reason: collision with root package name */
    public LinkedList<ByteBuffer> f23063i;
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
        public final /* synthetic */ boolean f23064e;

        public a(boolean z) {
            this.f23064e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (CronetBidirectionalStream.this.f23061g) {
                if (CronetBidirectionalStream.this.x()) {
                    return;
                }
                CronetBidirectionalStream.this.k = this.f23064e;
                CronetBidirectionalStream.this.m = State.WAITING_FOR_READ;
                if (!CronetBidirectionalStream.s(CronetBidirectionalStream.this.f23059e) && CronetBidirectionalStream.this.k) {
                    CronetBidirectionalStream.this.n = State.WRITING_DONE;
                } else {
                    CronetBidirectionalStream.this.n = State.WAITING_FOR_FLUSH;
                }
                try {
                    CronetBidirectionalStream.this.f23057c.f(CronetBidirectionalStream.this);
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
            synchronized (CronetBidirectionalStream.this.f23061g) {
                if (CronetBidirectionalStream.this.x()) {
                    return;
                }
                CronetBidirectionalStream.this.m = State.WAITING_FOR_READ;
                try {
                    CronetBidirectionalStream.this.f23057c.d(CronetBidirectionalStream.this, CronetBidirectionalStream.this.o);
                } catch (Exception e2) {
                    CronetBidirectionalStream.this.z(e2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UrlResponseInfo.HeaderBlock f23067e;

        public c(UrlResponseInfo.HeaderBlock headerBlock) {
            this.f23067e = headerBlock;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (CronetBidirectionalStream.this.f23061g) {
                if (CronetBidirectionalStream.this.x()) {
                    return;
                }
                try {
                    CronetBidirectionalStream.this.f23057c.e(CronetBidirectionalStream.this, CronetBidirectionalStream.this.o, this.f23067e);
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
                CronetBidirectionalStream.this.f23057c.a(CronetBidirectionalStream.this, CronetBidirectionalStream.this.o);
            } catch (Exception e2) {
                d.a.k0.a.a.c("ChromiumNetwork", "Exception in onCanceled method", e2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TurbonetException f23070e;

        public e(TurbonetException turbonetException) {
            this.f23070e = turbonetException;
        }

        @Override // java.lang.Runnable
        public void run() {
            CronetBidirectionalStream.this.u(this.f23070e);
        }
    }

    /* loaded from: classes5.dex */
    public final class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public ByteBuffer f23072e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f23073f;

        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ByteBuffer byteBuffer = this.f23072e;
                this.f23072e = null;
                synchronized (CronetBidirectionalStream.this.f23061g) {
                    if (CronetBidirectionalStream.this.x()) {
                        return;
                    }
                    boolean z = false;
                    if (this.f23073f) {
                        CronetBidirectionalStream.this.m = State.READING_DONE;
                        if (CronetBidirectionalStream.this.n == State.WRITING_DONE) {
                            z = true;
                        }
                    } else {
                        CronetBidirectionalStream.this.m = State.WAITING_FOR_READ;
                    }
                    CronetBidirectionalStream.this.f23057c.c(CronetBidirectionalStream.this, CronetBidirectionalStream.this.o, byteBuffer, this.f23073f);
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
        public ByteBuffer f23075e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f23076f;

        public g(ByteBuffer byteBuffer, boolean z) {
            this.f23075e = byteBuffer;
            this.f23076f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ByteBuffer byteBuffer = this.f23075e;
                this.f23075e = null;
                synchronized (CronetBidirectionalStream.this.f23061g) {
                    if (CronetBidirectionalStream.this.x()) {
                        return;
                    }
                    boolean z = false;
                    if (this.f23076f) {
                        CronetBidirectionalStream.this.n = State.WRITING_DONE;
                        if (CronetBidirectionalStream.this.m == State.READING_DONE) {
                            z = true;
                        }
                    }
                    CronetBidirectionalStream.this.f23057c.h(CronetBidirectionalStream.this, CronetBidirectionalStream.this.o, byteBuffer, this.f23076f);
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
            fVar.f23072e = byteBuffer;
            fVar.f23073f = i2 == 0;
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
        synchronized (this.f23061g) {
            this.n = State.WAITING_FOR_FLUSH;
            if (!this.f23063i.isEmpty()) {
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
            this.f23056b.execute(runnable);
        } catch (RejectedExecutionException e2) {
            d.a.k0.a.a.c("ChromiumNetwork", "Exception posting task to executor", e2);
            synchronized (this.f23061g) {
                State state = State.ERROR;
                this.n = state;
                this.m = state;
                r(false);
            }
        }
    }

    public final UrlResponseInfo B(int i2, String str, String[] strArr, long j) {
        UrlResponseInfo urlResponseInfo = new UrlResponseInfo(Arrays.asList(this.f23058d), i2, "", w(strArr), false, str, null);
        urlResponseInfo.j(j);
        return urlResponseInfo;
    }

    public final void C() {
        int size = this.f23063i.size();
        ByteBuffer[] byteBufferArr = new ByteBuffer[size];
        int[] iArr = new int[size];
        int[] iArr2 = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            ByteBuffer poll = this.f23063i.poll();
            byteBufferArr[i2] = poll;
            iArr[i2] = poll.position();
            iArr2[i2] = poll.limit();
        }
        this.n = State.WRITING;
        if (nativeWritevData(this.l, byteBufferArr, iArr, iArr2, this.j && this.f23062h.isEmpty())) {
            return;
        }
        this.n = State.WAITING_FOR_FLUSH;
        throw new IllegalArgumentException("Unable to call native writev.");
    }

    @Override // com.baidu.turbonet.net.BidirectionalStream
    public void a(ByteBuffer byteBuffer) {
        synchronized (this.f23061g) {
            d.a.k0.b.b.b(byteBuffer);
            d.a.k0.b.b.a(byteBuffer);
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
        synchronized (this.f23061g) {
            d.a.k0.b.b.a(byteBuffer);
            if (!byteBuffer.hasRemaining() && !z) {
                throw new IllegalArgumentException("Empty buffer before end of stream.");
            }
            if (!this.j) {
                if (x()) {
                    return;
                }
                this.f23062h.add(byteBuffer);
                if (z) {
                    this.j = true;
                }
                if (!this.f23060f) {
                    v();
                }
                return;
            }
            throw new IllegalArgumentException("Write after writing end of stream.");
        }
    }

    @GuardedBy("mNativeStreamLock")
    public final void r(boolean z) {
        d.a.k0.a.a.h("ChromiumNetwork", "destroyNativeStreamLocked " + toString(), new Object[0]);
        long j = this.l;
        if (j == 0) {
            return;
        }
        nativeDestroy(j, z);
        this.l = 0L;
        this.f23055a.s();
        Runnable runnable = this.q;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void t(TurbonetException turbonetException) {
        A(new e(turbonetException));
    }

    public final void u(TurbonetException turbonetException) {
        synchronized (this.f23061g) {
            if (x()) {
                return;
            }
            State state = State.ERROR;
            this.n = state;
            this.m = state;
            r(false);
            try {
                this.f23057c.b(this, this.o, turbonetException);
            } catch (Exception e2) {
                d.a.k0.a.a.c("ChromiumNetwork", "Exception notifying of failed request", e2);
            }
        }
    }

    public final void v() {
        if (x()) {
            return;
        }
        State state = this.n;
        if (state == State.WAITING_FOR_FLUSH || state == State.WRITING) {
            if (this.f23062h.isEmpty() && this.f23063i.isEmpty()) {
                if (this.k) {
                    return;
                }
                this.k = true;
                nativeSendRequestHeaders(this.l);
                if (s(this.f23059e)) {
                    return;
                }
                this.n = State.WRITING_DONE;
                return;
            }
            if (!this.f23062h.isEmpty()) {
                this.f23063i.addAll(this.f23062h);
                this.f23062h.clear();
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
        synchronized (this.f23061g) {
            if (x()) {
                return;
            }
            if (this.n == State.WRITING_DONE && this.m == State.READING_DONE) {
                State state = State.SUCCESS;
                this.n = state;
                this.m = state;
                r(false);
                try {
                    this.f23057c.g(this, this.o);
                } catch (Exception e2) {
                    d.a.k0.a.a.c("ChromiumNetwork", "Exception in onSucceeded method", e2);
                }
            }
        }
    }

    public final void z(Exception exc) {
        TurbonetException turbonetException = new TurbonetException("CalledByNative method has thrown an exception", exc);
        d.a.k0.a.a.c("ChromiumNetwork", "Exception in CalledByNative method", exc);
        u(turbonetException);
    }
}
