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
    long f5914b;
    final int c;
    private final List<com.bytedance.sdk.a.b.a.e.c> j;
    private List<com.bytedance.sdk.a.b.a.e.c> k;
    private boolean l;
    final g pfG;
    private final b pfX;
    final a pfY;

    /* renamed from: a  reason: collision with root package name */
    long f5913a = 0;
    final c pfZ = new c();
    final c pga = new c();
    com.bytedance.sdk.a.b.a.e.b pgb = null;

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
        this.pfG = gVar;
        this.f5914b = gVar.pfB.d();
        this.pfX = new b(gVar.pfA.d());
        this.pfY = new a();
        this.pfX.f5918b = z2;
        this.pfY.f5916b = z;
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
            if (this.pgb == null) {
                if ((this.pfX.f5918b || this.pfX.f5917a) && (this.pfY.f5916b || this.pfY.f5915a)) {
                }
                z = true;
            }
        }
        return z;
    }

    public boolean c() {
        return this.pfG.f5900b == ((this.c & 1) == 1);
    }

    public synchronized List<com.bytedance.sdk.a.b.a.e.c> d() throws IOException {
        List<com.bytedance.sdk.a.b.a.e.c> list;
        if (!c()) {
            throw new IllegalStateException("servers cannot read response headers");
        }
        this.pfZ.a();
        while (this.k == null && this.pgb == null) {
            l();
        }
        this.pfZ.h();
        list = this.k;
        if (list != null) {
            this.k = null;
        } else {
            throw new o(this.pgb);
        }
        return list;
    }

    public t emk() {
        return this.pfZ;
    }

    public t eml() {
        return this.pga;
    }

    public s emZ() {
        return this.pfX;
    }

    public r ena() {
        synchronized (this) {
            if (!this.l && !c()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.pfY;
    }

    public void a(com.bytedance.sdk.a.b.a.e.b bVar) throws IOException {
        if (c(bVar)) {
            this.pfG.b(this.c, bVar);
        }
    }

    public void b(com.bytedance.sdk.a.b.a.e.b bVar) {
        if (c(bVar)) {
            this.pfG.a(this.c, bVar);
        }
    }

    private boolean c(com.bytedance.sdk.a.b.a.e.b bVar) {
        if (i || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (this.pgb != null) {
                    return false;
                }
                if (this.pfX.f5918b && this.pfY.f5916b) {
                    return false;
                }
                this.pgb = bVar;
                notifyAll();
                this.pfG.Oi(this.c);
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
            this.pfG.Oi(this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.bytedance.sdk.a.a.e eVar, int i2) throws IOException {
        if (!i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        this.pfX.a(eVar, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        boolean b2;
        if (!i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.pfX.f5918b = true;
            b2 = b();
            notifyAll();
        }
        if (!b2) {
            this.pfG.Oi(this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void d(com.bytedance.sdk.a.b.a.e.b bVar) {
        if (this.pgb == null) {
            this.pgb = bVar;
            notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public final class b implements s {
        static final /* synthetic */ boolean c;

        /* renamed from: a  reason: collision with root package name */
        boolean f5917a;

        /* renamed from: b  reason: collision with root package name */
        boolean f5918b;
        private final long g;
        private final com.bytedance.sdk.a.a.c pgc = new com.bytedance.sdk.a.a.c();
        private final com.bytedance.sdk.a.a.c pge = new com.bytedance.sdk.a.a.c();

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
                if (this.pge.b() == 0) {
                    b2 = -1;
                } else {
                    b2 = this.pge.b(cVar, Math.min(j, this.pge.b()));
                    i.this.f5913a += b2;
                    if (i.this.f5913a >= i.this.pfG.pfA.d() / 2) {
                        i.this.pfG.a(i.this.c, i.this.f5913a);
                        i.this.f5913a = 0L;
                    }
                    synchronized (i.this.pfG) {
                        i.this.pfG.j += b2;
                        if (i.this.pfG.j >= i.this.pfG.pfA.d() / 2) {
                            i.this.pfG.a(0, i.this.pfG.j);
                            i.this.pfG.j = 0L;
                        }
                    }
                }
            }
            return b2;
        }

        private void b() throws IOException {
            i.this.pfZ.a();
            while (this.pge.b() == 0 && !this.f5918b && !this.f5917a && i.this.pgb == null) {
                try {
                    i.this.l();
                } finally {
                    i.this.pfZ.h();
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
                    z = this.f5918b;
                    z2 = this.pge.b() + j > this.g;
                }
                if (z2) {
                    eVar.h(j);
                    i.this.b(com.bytedance.sdk.a.b.a.e.b.FLOW_CONTROL_ERROR);
                    return;
                } else if (z) {
                    eVar.h(j);
                    return;
                } else {
                    long b2 = eVar.b(this.pgc, j);
                    if (b2 == -1) {
                        throw new EOFException();
                    }
                    j -= b2;
                    synchronized (i.this) {
                        boolean z3 = this.pge.b() == 0;
                        this.pge.b(this.pgc);
                        if (z3) {
                            i.this.notifyAll();
                        }
                    }
                }
            }
        }

        @Override // com.bytedance.sdk.a.a.s
        public t elW() {
            return i.this.pfZ;
        }

        @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (i.this) {
                this.f5917a = true;
                this.pge.r();
                i.this.notifyAll();
            }
            i.this.j();
        }

        private void c() throws IOException {
            if (this.f5917a) {
                throw new IOException("stream closed");
            }
            if (i.this.pgb != null) {
                throw new o(i.this.pgb);
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
            z = !this.pfX.f5918b && this.pfX.f5917a && (this.pfY.f5916b || this.pfY.f5915a);
            b2 = b();
        }
        if (z) {
            a(com.bytedance.sdk.a.b.a.e.b.CANCEL);
        } else if (!b2) {
            this.pfG.Oi(this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public final class a implements r {
        static final /* synthetic */ boolean c;

        /* renamed from: a  reason: collision with root package name */
        boolean f5915a;

        /* renamed from: b  reason: collision with root package name */
        boolean f5916b;
        private final com.bytedance.sdk.a.a.c pgc = new com.bytedance.sdk.a.a.c();

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
            this.pgc.a(cVar, j);
            while (this.pgc.b() >= 16384) {
                a(false);
            }
        }

        private void a(boolean z) throws IOException {
            long min;
            synchronized (i.this) {
                i.this.pga.a();
                while (i.this.f5914b <= 0 && !this.f5916b && !this.f5915a && i.this.pgb == null) {
                    i.this.l();
                }
                i.this.pga.h();
                i.this.k();
                min = Math.min(i.this.f5914b, this.pgc.b());
                i.this.f5914b -= min;
            }
            i.this.pga.a();
            try {
                i.this.pfG.a(i.this.c, z && min == this.pgc.b(), this.pgc, min);
            } finally {
                i.this.pga.h();
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
            while (this.pgc.b() > 0) {
                a(false);
                i.this.pfG.b();
            }
        }

        @Override // com.bytedance.sdk.a.a.r
        public t elW() {
            return i.this.pga;
        }

        @Override // com.bytedance.sdk.a.a.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!c && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            synchronized (i.this) {
                if (!this.f5915a) {
                    if (!i.this.pfY.f5916b) {
                        if (this.pgc.b() > 0) {
                            while (this.pgc.b() > 0) {
                                a(true);
                            }
                        } else {
                            i.this.pfG.a(i.this.c, true, (com.bytedance.sdk.a.a.c) null, 0L);
                        }
                    }
                    synchronized (i.this) {
                        this.f5915a = true;
                    }
                    i.this.pfG.b();
                    i.this.j();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j) {
        this.f5914b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    void k() throws IOException {
        if (this.pfY.f5915a) {
            throw new IOException("stream closed");
        }
        if (this.pfY.f5916b) {
            throw new IOException("stream finished");
        }
        if (this.pgb != null) {
            throw new o(this.pgb);
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
        protected void elU() {
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
