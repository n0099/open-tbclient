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
/* loaded from: classes4.dex */
public final class i {
    static final /* synthetic */ boolean i;

    /* renamed from: b  reason: collision with root package name */
    long f6214b;
    final int c;
    private final List<com.bytedance.sdk.a.b.a.e.c> j;
    private List<com.bytedance.sdk.a.b.a.e.c> k;
    private boolean l;
    private final b pkC;
    final a pkD;
    final g pkl;

    /* renamed from: a  reason: collision with root package name */
    long f6213a = 0;
    final c pkE = new c();
    final c pkF = new c();
    com.bytedance.sdk.a.b.a.e.b pkG = null;

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
        this.pkl = gVar;
        this.f6214b = gVar.pkf.d();
        this.pkC = new b(gVar.pke.d());
        this.pkD = new a();
        this.pkC.f6218b = z2;
        this.pkD.f6216b = z;
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
            if (this.pkG == null) {
                if ((this.pkC.f6218b || this.pkC.f6217a) && (this.pkD.f6216b || this.pkD.f6215a)) {
                }
                z = true;
            }
        }
        return z;
    }

    public boolean c() {
        return this.pkl.f6200b == ((this.c & 1) == 1);
    }

    public synchronized List<com.bytedance.sdk.a.b.a.e.c> d() throws IOException {
        List<com.bytedance.sdk.a.b.a.e.c> list;
        if (!c()) {
            throw new IllegalStateException("servers cannot read response headers");
        }
        this.pkE.a();
        while (this.k == null && this.pkG == null) {
            l();
        }
        this.pkE.h();
        list = this.k;
        if (list != null) {
            this.k = null;
        } else {
            throw new o(this.pkG);
        }
        return list;
    }

    public t eqg() {
        return this.pkE;
    }

    public t eqh() {
        return this.pkF;
    }

    public s eqV() {
        return this.pkC;
    }

    public r eqW() {
        synchronized (this) {
            if (!this.l && !c()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.pkD;
    }

    public void a(com.bytedance.sdk.a.b.a.e.b bVar) throws IOException {
        if (c(bVar)) {
            this.pkl.b(this.c, bVar);
        }
    }

    public void b(com.bytedance.sdk.a.b.a.e.b bVar) {
        if (c(bVar)) {
            this.pkl.a(this.c, bVar);
        }
    }

    private boolean c(com.bytedance.sdk.a.b.a.e.b bVar) {
        if (i || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (this.pkG != null) {
                    return false;
                }
                if (this.pkC.f6218b && this.pkD.f6216b) {
                    return false;
                }
                this.pkG = bVar;
                notifyAll();
                this.pkl.PP(this.c);
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
            this.pkl.PP(this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.bytedance.sdk.a.a.e eVar, int i2) throws IOException {
        if (!i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        this.pkC.a(eVar, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        boolean b2;
        if (!i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.pkC.f6218b = true;
            b2 = b();
            notifyAll();
        }
        if (!b2) {
            this.pkl.PP(this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void d(com.bytedance.sdk.a.b.a.e.b bVar) {
        if (this.pkG == null) {
            this.pkG = bVar;
            notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public final class b implements s {
        static final /* synthetic */ boolean c;

        /* renamed from: a  reason: collision with root package name */
        boolean f6217a;

        /* renamed from: b  reason: collision with root package name */
        boolean f6218b;
        private final long g;
        private final com.bytedance.sdk.a.a.c pkH = new com.bytedance.sdk.a.a.c();
        private final com.bytedance.sdk.a.a.c pkJ = new com.bytedance.sdk.a.a.c();

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
                if (this.pkJ.b() == 0) {
                    b2 = -1;
                } else {
                    b2 = this.pkJ.b(cVar, Math.min(j, this.pkJ.b()));
                    i.this.f6213a += b2;
                    if (i.this.f6213a >= i.this.pkl.pke.d() / 2) {
                        i.this.pkl.a(i.this.c, i.this.f6213a);
                        i.this.f6213a = 0L;
                    }
                    synchronized (i.this.pkl) {
                        i.this.pkl.j += b2;
                        if (i.this.pkl.j >= i.this.pkl.pke.d() / 2) {
                            i.this.pkl.a(0, i.this.pkl.j);
                            i.this.pkl.j = 0L;
                        }
                    }
                }
            }
            return b2;
        }

        private void b() throws IOException {
            i.this.pkE.a();
            while (this.pkJ.b() == 0 && !this.f6218b && !this.f6217a && i.this.pkG == null) {
                try {
                    i.this.l();
                } finally {
                    i.this.pkE.h();
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
                    z = this.f6218b;
                    z2 = this.pkJ.b() + j > this.g;
                }
                if (z2) {
                    eVar.h(j);
                    i.this.b(com.bytedance.sdk.a.b.a.e.b.FLOW_CONTROL_ERROR);
                    return;
                } else if (z) {
                    eVar.h(j);
                    return;
                } else {
                    long b2 = eVar.b(this.pkH, j);
                    if (b2 == -1) {
                        throw new EOFException();
                    }
                    j -= b2;
                    synchronized (i.this) {
                        boolean z3 = this.pkJ.b() == 0;
                        this.pkJ.b(this.pkH);
                        if (z3) {
                            i.this.notifyAll();
                        }
                    }
                }
            }
        }

        @Override // com.bytedance.sdk.a.a.s
        public t epS() {
            return i.this.pkE;
        }

        @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (i.this) {
                this.f6217a = true;
                this.pkJ.r();
                i.this.notifyAll();
            }
            i.this.j();
        }

        private void c() throws IOException {
            if (this.f6217a) {
                throw new IOException("stream closed");
            }
            if (i.this.pkG != null) {
                throw new o(i.this.pkG);
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
            z = !this.pkC.f6218b && this.pkC.f6217a && (this.pkD.f6216b || this.pkD.f6215a);
            b2 = b();
        }
        if (z) {
            a(com.bytedance.sdk.a.b.a.e.b.CANCEL);
        } else if (!b2) {
            this.pkl.PP(this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public final class a implements r {
        static final /* synthetic */ boolean c;

        /* renamed from: a  reason: collision with root package name */
        boolean f6215a;

        /* renamed from: b  reason: collision with root package name */
        boolean f6216b;
        private final com.bytedance.sdk.a.a.c pkH = new com.bytedance.sdk.a.a.c();

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
            this.pkH.a(cVar, j);
            while (this.pkH.b() >= 16384) {
                a(false);
            }
        }

        private void a(boolean z) throws IOException {
            long min;
            synchronized (i.this) {
                i.this.pkF.a();
                while (i.this.f6214b <= 0 && !this.f6216b && !this.f6215a && i.this.pkG == null) {
                    i.this.l();
                }
                i.this.pkF.h();
                i.this.k();
                min = Math.min(i.this.f6214b, this.pkH.b());
                i.this.f6214b -= min;
            }
            i.this.pkF.a();
            try {
                i.this.pkl.a(i.this.c, z && min == this.pkH.b(), this.pkH, min);
            } finally {
                i.this.pkF.h();
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
            while (this.pkH.b() > 0) {
                a(false);
                i.this.pkl.b();
            }
        }

        @Override // com.bytedance.sdk.a.a.r
        public t epS() {
            return i.this.pkF;
        }

        @Override // com.bytedance.sdk.a.a.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!c && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            synchronized (i.this) {
                if (!this.f6215a) {
                    if (!i.this.pkD.f6216b) {
                        if (this.pkH.b() > 0) {
                            while (this.pkH.b() > 0) {
                                a(true);
                            }
                        } else {
                            i.this.pkl.a(i.this.c, true, (com.bytedance.sdk.a.a.c) null, 0L);
                        }
                    }
                    synchronized (i.this) {
                        this.f6215a = true;
                    }
                    i.this.pkl.b();
                    i.this.j();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j) {
        this.f6214b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    void k() throws IOException {
        if (this.pkD.f6215a) {
            throw new IOException("stream closed");
        }
        if (this.pkD.f6216b) {
            throw new IOException("stream finished");
        }
        if (this.pkG != null) {
            throw new o(this.pkG);
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
    /* loaded from: classes4.dex */
    public class c extends com.bytedance.sdk.a.a.a {
        c() {
        }

        @Override // com.bytedance.sdk.a.a.a
        protected void epQ() {
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
