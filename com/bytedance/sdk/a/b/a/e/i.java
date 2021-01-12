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
    final g pfF;
    private final b pfW;
    final a pfX;

    /* renamed from: a  reason: collision with root package name */
    long f5913a = 0;
    final c pfY = new c();
    final c pfZ = new c();
    com.bytedance.sdk.a.b.a.e.b pga = null;

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
        this.pfF = gVar;
        this.f5914b = gVar.pfA.d();
        this.pfW = new b(gVar.pfz.d());
        this.pfX = new a();
        this.pfW.f5918b = z2;
        this.pfX.f5916b = z;
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
            if (this.pga == null) {
                if ((this.pfW.f5918b || this.pfW.f5917a) && (this.pfX.f5916b || this.pfX.f5915a)) {
                }
                z = true;
            }
        }
        return z;
    }

    public boolean c() {
        return this.pfF.f5900b == ((this.c & 1) == 1);
    }

    public synchronized List<com.bytedance.sdk.a.b.a.e.c> d() throws IOException {
        List<com.bytedance.sdk.a.b.a.e.c> list;
        if (!c()) {
            throw new IllegalStateException("servers cannot read response headers");
        }
        this.pfY.a();
        while (this.k == null && this.pga == null) {
            l();
        }
        this.pfY.h();
        list = this.k;
        if (list != null) {
            this.k = null;
        } else {
            throw new o(this.pga);
        }
        return list;
    }

    public t emk() {
        return this.pfY;
    }

    public t eml() {
        return this.pfZ;
    }

    public s emZ() {
        return this.pfW;
    }

    public r ena() {
        synchronized (this) {
            if (!this.l && !c()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.pfX;
    }

    public void a(com.bytedance.sdk.a.b.a.e.b bVar) throws IOException {
        if (c(bVar)) {
            this.pfF.b(this.c, bVar);
        }
    }

    public void b(com.bytedance.sdk.a.b.a.e.b bVar) {
        if (c(bVar)) {
            this.pfF.a(this.c, bVar);
        }
    }

    private boolean c(com.bytedance.sdk.a.b.a.e.b bVar) {
        if (i || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (this.pga != null) {
                    return false;
                }
                if (this.pfW.f5918b && this.pfX.f5916b) {
                    return false;
                }
                this.pga = bVar;
                notifyAll();
                this.pfF.Oi(this.c);
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
            this.pfF.Oi(this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.bytedance.sdk.a.a.e eVar, int i2) throws IOException {
        if (!i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        this.pfW.a(eVar, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        boolean b2;
        if (!i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.pfW.f5918b = true;
            b2 = b();
            notifyAll();
        }
        if (!b2) {
            this.pfF.Oi(this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void d(com.bytedance.sdk.a.b.a.e.b bVar) {
        if (this.pga == null) {
            this.pga = bVar;
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
        private final com.bytedance.sdk.a.a.c pgb = new com.bytedance.sdk.a.a.c();
        private final com.bytedance.sdk.a.a.c pgd = new com.bytedance.sdk.a.a.c();

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
                if (this.pgd.b() == 0) {
                    b2 = -1;
                } else {
                    b2 = this.pgd.b(cVar, Math.min(j, this.pgd.b()));
                    i.this.f5913a += b2;
                    if (i.this.f5913a >= i.this.pfF.pfz.d() / 2) {
                        i.this.pfF.a(i.this.c, i.this.f5913a);
                        i.this.f5913a = 0L;
                    }
                    synchronized (i.this.pfF) {
                        i.this.pfF.j += b2;
                        if (i.this.pfF.j >= i.this.pfF.pfz.d() / 2) {
                            i.this.pfF.a(0, i.this.pfF.j);
                            i.this.pfF.j = 0L;
                        }
                    }
                }
            }
            return b2;
        }

        private void b() throws IOException {
            i.this.pfY.a();
            while (this.pgd.b() == 0 && !this.f5918b && !this.f5917a && i.this.pga == null) {
                try {
                    i.this.l();
                } finally {
                    i.this.pfY.h();
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
                    z2 = this.pgd.b() + j > this.g;
                }
                if (z2) {
                    eVar.h(j);
                    i.this.b(com.bytedance.sdk.a.b.a.e.b.FLOW_CONTROL_ERROR);
                    return;
                } else if (z) {
                    eVar.h(j);
                    return;
                } else {
                    long b2 = eVar.b(this.pgb, j);
                    if (b2 == -1) {
                        throw new EOFException();
                    }
                    j -= b2;
                    synchronized (i.this) {
                        boolean z3 = this.pgd.b() == 0;
                        this.pgd.b(this.pgb);
                        if (z3) {
                            i.this.notifyAll();
                        }
                    }
                }
            }
        }

        @Override // com.bytedance.sdk.a.a.s
        public t elW() {
            return i.this.pfY;
        }

        @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (i.this) {
                this.f5917a = true;
                this.pgd.r();
                i.this.notifyAll();
            }
            i.this.j();
        }

        private void c() throws IOException {
            if (this.f5917a) {
                throw new IOException("stream closed");
            }
            if (i.this.pga != null) {
                throw new o(i.this.pga);
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
            z = !this.pfW.f5918b && this.pfW.f5917a && (this.pfX.f5916b || this.pfX.f5915a);
            b2 = b();
        }
        if (z) {
            a(com.bytedance.sdk.a.b.a.e.b.CANCEL);
        } else if (!b2) {
            this.pfF.Oi(this.c);
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
        private final com.bytedance.sdk.a.a.c pgb = new com.bytedance.sdk.a.a.c();

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
            this.pgb.a(cVar, j);
            while (this.pgb.b() >= 16384) {
                a(false);
            }
        }

        private void a(boolean z) throws IOException {
            long min;
            synchronized (i.this) {
                i.this.pfZ.a();
                while (i.this.f5914b <= 0 && !this.f5916b && !this.f5915a && i.this.pga == null) {
                    i.this.l();
                }
                i.this.pfZ.h();
                i.this.k();
                min = Math.min(i.this.f5914b, this.pgb.b());
                i.this.f5914b -= min;
            }
            i.this.pfZ.a();
            try {
                i.this.pfF.a(i.this.c, z && min == this.pgb.b(), this.pgb, min);
            } finally {
                i.this.pfZ.h();
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
            while (this.pgb.b() > 0) {
                a(false);
                i.this.pfF.b();
            }
        }

        @Override // com.bytedance.sdk.a.a.r
        public t elW() {
            return i.this.pfZ;
        }

        @Override // com.bytedance.sdk.a.a.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!c && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            synchronized (i.this) {
                if (!this.f5915a) {
                    if (!i.this.pfX.f5916b) {
                        if (this.pgb.b() > 0) {
                            while (this.pgb.b() > 0) {
                                a(true);
                            }
                        } else {
                            i.this.pfF.a(i.this.c, true, (com.bytedance.sdk.a.a.c) null, 0L);
                        }
                    }
                    synchronized (i.this) {
                        this.f5915a = true;
                    }
                    i.this.pfF.b();
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
        if (this.pfX.f5915a) {
            throw new IOException("stream closed");
        }
        if (this.pfX.f5916b) {
            throw new IOException("stream finished");
        }
        if (this.pga != null) {
            throw new o(this.pga);
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
