package com.bytedance.sdk.a.b.a.e;

import com.bytedance.sdk.a.a.r;
import com.bytedance.sdk.a.a.s;
import com.bytedance.sdk.a.a.t;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public final class i {
    static final /* synthetic */ boolean i;

    /* renamed from: b  reason: collision with root package name */
    long f5916b;
    final int c;
    private final List<com.bytedance.sdk.a.b.a.e.c> j;
    private List<com.bytedance.sdk.a.b.a.e.c> k;
    private boolean l;
    private final b pqP;
    final a pqQ;
    final g pqy;

    /* renamed from: a  reason: collision with root package name */
    long f5915a = 0;
    final c pqR = new c();
    final c pqS = new c();
    com.bytedance.sdk.a.b.a.e.b pqT = null;

    static {
        i = !i.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(int i2, g gVar, boolean z, boolean z2, List<com.bytedance.sdk.a.b.a.e.c> list) {
        if (gVar == null) {
            throw new NullPointerException("connection == null");
        }
        if (list == null) {
            throw new NullPointerException("requestHeaders == null");
        }
        this.c = i2;
        this.pqy = gVar;
        this.f5916b = gVar.pqt.d();
        this.pqP = new b(gVar.pqs.d());
        this.pqQ = new a();
        this.pqP.f5920b = z2;
        this.pqQ.f5918b = z;
        this.j = list;
    }

    public int a() {
        return this.c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0022, code lost:
        if (r2.l == false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean b() {
        boolean z = false;
        synchronized (this) {
            if (this.pqT == null) {
                if ((this.pqP.f5920b || this.pqP.f5919a) && (this.pqQ.f5918b || this.pqQ.f5917a)) {
                }
                z = true;
            }
        }
        return z;
    }

    public boolean c() {
        return this.pqy.f5902b == ((this.c & 1) == 1);
    }

    public synchronized List<com.bytedance.sdk.a.b.a.e.c> d() throws IOException {
        List<com.bytedance.sdk.a.b.a.e.c> list;
        if (!c()) {
            throw new IllegalStateException("servers cannot read response headers");
        }
        this.pqR.a();
        while (this.k == null && this.pqT == null) {
            l();
        }
        this.pqR.h();
        list = this.k;
        if (list != null) {
            this.k = null;
        } else {
            throw new o(this.pqT);
        }
        return list;
    }

    public t eoM() {
        return this.pqR;
    }

    public t eoN() {
        return this.pqS;
    }

    public s epB() {
        return this.pqP;
    }

    public r epC() {
        synchronized (this) {
            if (!this.l && !c()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.pqQ;
    }

    public void a(com.bytedance.sdk.a.b.a.e.b bVar) throws IOException {
        if (c(bVar)) {
            this.pqy.b(this.c, bVar);
        }
    }

    public void b(com.bytedance.sdk.a.b.a.e.b bVar) {
        if (c(bVar)) {
            this.pqy.a(this.c, bVar);
        }
    }

    private boolean c(com.bytedance.sdk.a.b.a.e.b bVar) {
        if (i || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (this.pqT != null) {
                    return false;
                }
                if (this.pqP.f5920b && this.pqQ.f5918b) {
                    return false;
                }
                this.pqT = bVar;
                notifyAll();
                this.pqy.OE(this.c);
                return true;
            }
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(List<com.bytedance.sdk.a.b.a.e.c> list) {
        boolean z = true;
        if (!i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.l = true;
            if (this.k == null) {
                this.k = list;
                z = b();
                notifyAll();
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.k);
                arrayList.add(null);
                arrayList.addAll(list);
                this.k = arrayList;
            }
        }
        if (!z) {
            this.pqy.OE(this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.bytedance.sdk.a.a.e eVar, int i2) throws IOException {
        if (!i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        this.pqP.a(eVar, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        boolean b2;
        if (!i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.pqP.f5920b = true;
            b2 = b();
            notifyAll();
        }
        if (!b2) {
            this.pqy.OE(this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void d(com.bytedance.sdk.a.b.a.e.b bVar) {
        if (this.pqT == null) {
            this.pqT = bVar;
            notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public final class b implements s {
        static final /* synthetic */ boolean c;

        /* renamed from: a  reason: collision with root package name */
        boolean f5919a;

        /* renamed from: b  reason: collision with root package name */
        boolean f5920b;
        private final long g;
        private final com.bytedance.sdk.a.a.c pqU = new com.bytedance.sdk.a.a.c();
        private final com.bytedance.sdk.a.a.c pqW = new com.bytedance.sdk.a.a.c();

        static {
            c = !i.class.desiredAssertionStatus();
        }

        b(long j) {
            this.g = j;
        }

        @Override // com.bytedance.sdk.a.a.s
        public long b(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
            long b2;
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            synchronized (i.this) {
                b();
                c();
                if (this.pqW.b() == 0) {
                    b2 = -1;
                } else {
                    b2 = this.pqW.b(cVar, Math.min(j, this.pqW.b()));
                    i.this.f5915a += b2;
                    if (i.this.f5915a >= i.this.pqy.pqs.d() / 2) {
                        i.this.pqy.a(i.this.c, i.this.f5915a);
                        i.this.f5915a = 0L;
                    }
                    synchronized (i.this.pqy) {
                        i.this.pqy.j += b2;
                        if (i.this.pqy.j >= i.this.pqy.pqs.d() / 2) {
                            i.this.pqy.a(0, i.this.pqy.j);
                            i.this.pqy.j = 0L;
                        }
                    }
                }
            }
            return b2;
        }

        private void b() throws IOException {
            i.this.pqR.a();
            while (this.pqW.b() == 0 && !this.f5920b && !this.f5919a && i.this.pqT == null) {
                try {
                    i.this.l();
                } finally {
                    i.this.pqR.h();
                }
            }
        }

        void a(com.bytedance.sdk.a.a.e eVar, long j) throws IOException {
            boolean z;
            boolean z2;
            if (!c && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            while (j > 0) {
                synchronized (i.this) {
                    z = this.f5920b;
                    z2 = this.pqW.b() + j > this.g;
                }
                if (z2) {
                    eVar.h(j);
                    i.this.b(com.bytedance.sdk.a.b.a.e.b.FLOW_CONTROL_ERROR);
                    return;
                } else if (z) {
                    eVar.h(j);
                    return;
                } else {
                    long b2 = eVar.b(this.pqU, j);
                    if (b2 == -1) {
                        throw new EOFException();
                    }
                    j -= b2;
                    synchronized (i.this) {
                        boolean z3 = this.pqW.b() == 0;
                        this.pqW.b(this.pqU);
                        if (z3) {
                            i.this.notifyAll();
                        }
                    }
                }
            }
        }

        @Override // com.bytedance.sdk.a.a.s
        public t eoy() {
            return i.this.pqR;
        }

        @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (i.this) {
                this.f5919a = true;
                this.pqW.r();
                i.this.notifyAll();
            }
            i.this.j();
        }

        private void c() throws IOException {
            if (this.f5919a) {
                throw new IOException("stream closed");
            }
            if (i.this.pqT != null) {
                throw new o(i.this.pqT);
            }
        }
    }

    void j() throws IOException {
        boolean z;
        boolean b2;
        if (!i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            z = !this.pqP.f5920b && this.pqP.f5919a && (this.pqQ.f5918b || this.pqQ.f5917a);
            b2 = b();
        }
        if (z) {
            a(com.bytedance.sdk.a.b.a.e.b.CANCEL);
        } else if (!b2) {
            this.pqy.OE(this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public final class a implements r {
        static final /* synthetic */ boolean c;

        /* renamed from: a  reason: collision with root package name */
        boolean f5917a;

        /* renamed from: b  reason: collision with root package name */
        boolean f5918b;
        private final com.bytedance.sdk.a.a.c pqU = new com.bytedance.sdk.a.a.c();

        static {
            c = !i.class.desiredAssertionStatus();
        }

        a() {
        }

        @Override // com.bytedance.sdk.a.a.r
        public void a(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
            if (!c && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            this.pqU.a(cVar, j);
            while (this.pqU.b() >= 16384) {
                a(false);
            }
        }

        private void a(boolean z) throws IOException {
            long min;
            synchronized (i.this) {
                i.this.pqS.a();
                while (i.this.f5916b <= 0 && !this.f5918b && !this.f5917a && i.this.pqT == null) {
                    i.this.l();
                }
                i.this.pqS.h();
                i.this.k();
                min = Math.min(i.this.f5916b, this.pqU.b());
                i.this.f5916b -= min;
            }
            i.this.pqS.a();
            try {
                i.this.pqy.a(i.this.c, z && min == this.pqU.b(), this.pqU, min);
            } finally {
                i.this.pqS.h();
            }
        }

        @Override // com.bytedance.sdk.a.a.r, java.io.Flushable
        public void flush() throws IOException {
            if (!c && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            synchronized (i.this) {
                i.this.k();
            }
            while (this.pqU.b() > 0) {
                a(false);
                i.this.pqy.b();
            }
        }

        @Override // com.bytedance.sdk.a.a.r
        public t eoy() {
            return i.this.pqS;
        }

        @Override // com.bytedance.sdk.a.a.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!c && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            synchronized (i.this) {
                if (!this.f5917a) {
                    if (!i.this.pqQ.f5918b) {
                        if (this.pqU.b() > 0) {
                            while (this.pqU.b() > 0) {
                                a(true);
                            }
                        } else {
                            i.this.pqy.a(i.this.c, true, (com.bytedance.sdk.a.a.c) null, 0L);
                        }
                    }
                    synchronized (i.this) {
                        this.f5917a = true;
                    }
                    i.this.pqy.b();
                    i.this.j();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j) {
        this.f5916b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    void k() throws IOException {
        if (this.pqQ.f5917a) {
            throw new IOException("stream closed");
        }
        if (this.pqQ.f5918b) {
            throw new IOException("stream finished");
        }
        if (this.pqT != null) {
            throw new o(this.pqT);
        }
    }

    void l() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException e) {
            throw new InterruptedIOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class c extends com.bytedance.sdk.a.a.a {
        c() {
        }

        @Override // com.bytedance.sdk.a.a.a
        protected void eow() {
            i.this.b(com.bytedance.sdk.a.b.a.e.b.CANCEL);
        }

        @Override // com.bytedance.sdk.a.a.a
        protected IOException f(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        public void h() throws IOException {
            if (b()) {
                throw f(null);
            }
        }
    }
}
