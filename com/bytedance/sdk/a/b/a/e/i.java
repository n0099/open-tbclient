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
    long b;
    final int c;
    private final List<com.bytedance.sdk.a.b.a.e.c> j;
    private List<com.bytedance.sdk.a.b.a.e.c> k;
    private boolean l;
    final g psD;
    private final b psU;
    final a psV;

    /* renamed from: a  reason: collision with root package name */
    long f3981a = 0;
    final c psW = new c();
    final c psX = new c();
    com.bytedance.sdk.a.b.a.e.b psY = null;

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
        this.psD = gVar;
        this.b = gVar.psy.d();
        this.psU = new b(gVar.psx.d());
        this.psV = new a();
        this.psU.b = z2;
        this.psV.b = z;
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
            if (this.psY == null) {
                if ((this.psU.b || this.psU.f3983a) && (this.psV.b || this.psV.f3982a)) {
                }
                z = true;
            }
        }
        return z;
    }

    public boolean c() {
        return this.psD.b == ((this.c & 1) == 1);
    }

    public synchronized List<com.bytedance.sdk.a.b.a.e.c> d() throws IOException {
        List<com.bytedance.sdk.a.b.a.e.c> list;
        if (!c()) {
            throw new IllegalStateException("servers cannot read response headers");
        }
        this.psW.a();
        while (this.k == null && this.psY == null) {
            l();
        }
        this.psW.h();
        list = this.k;
        if (list != null) {
            this.k = null;
        } else {
            throw new o(this.psY);
        }
        return list;
    }

    public t eoT() {
        return this.psW;
    }

    public t eoU() {
        return this.psX;
    }

    public s epI() {
        return this.psU;
    }

    public r epJ() {
        synchronized (this) {
            if (!this.l && !c()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.psV;
    }

    public void a(com.bytedance.sdk.a.b.a.e.b bVar) throws IOException {
        if (c(bVar)) {
            this.psD.b(this.c, bVar);
        }
    }

    public void b(com.bytedance.sdk.a.b.a.e.b bVar) {
        if (c(bVar)) {
            this.psD.a(this.c, bVar);
        }
    }

    private boolean c(com.bytedance.sdk.a.b.a.e.b bVar) {
        if (i || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (this.psY != null) {
                    return false;
                }
                if (this.psU.b && this.psV.b) {
                    return false;
                }
                this.psY = bVar;
                notifyAll();
                this.psD.OI(this.c);
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
            this.psD.OI(this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.bytedance.sdk.a.a.e eVar, int i2) throws IOException {
        if (!i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        this.psU.a(eVar, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        boolean b2;
        if (!i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.psU.b = true;
            b2 = b();
            notifyAll();
        }
        if (!b2) {
            this.psD.OI(this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void d(com.bytedance.sdk.a.b.a.e.b bVar) {
        if (this.psY == null) {
            this.psY = bVar;
            notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public final class b implements s {
        static final /* synthetic */ boolean c;

        /* renamed from: a  reason: collision with root package name */
        boolean f3983a;
        boolean b;
        private final long g;
        private final com.bytedance.sdk.a.a.c psZ = new com.bytedance.sdk.a.a.c();
        private final com.bytedance.sdk.a.a.c ptb = new com.bytedance.sdk.a.a.c();

        static {
            c = !i.class.desiredAssertionStatus();
        }

        b(long j) {
            this.g = j;
        }

        @Override // com.bytedance.sdk.a.a.s
        public long b(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
            long b;
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            synchronized (i.this) {
                b();
                c();
                if (this.ptb.b() == 0) {
                    b = -1;
                } else {
                    b = this.ptb.b(cVar, Math.min(j, this.ptb.b()));
                    i.this.f3981a += b;
                    if (i.this.f3981a >= i.this.psD.psx.d() / 2) {
                        i.this.psD.a(i.this.c, i.this.f3981a);
                        i.this.f3981a = 0L;
                    }
                    synchronized (i.this.psD) {
                        i.this.psD.j += b;
                        if (i.this.psD.j >= i.this.psD.psx.d() / 2) {
                            i.this.psD.a(0, i.this.psD.j);
                            i.this.psD.j = 0L;
                        }
                    }
                }
            }
            return b;
        }

        private void b() throws IOException {
            i.this.psW.a();
            while (this.ptb.b() == 0 && !this.b && !this.f3983a && i.this.psY == null) {
                try {
                    i.this.l();
                } finally {
                    i.this.psW.h();
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
                    z = this.b;
                    z2 = this.ptb.b() + j > this.g;
                }
                if (z2) {
                    eVar.h(j);
                    i.this.b(com.bytedance.sdk.a.b.a.e.b.FLOW_CONTROL_ERROR);
                    return;
                } else if (z) {
                    eVar.h(j);
                    return;
                } else {
                    long b = eVar.b(this.psZ, j);
                    if (b == -1) {
                        throw new EOFException();
                    }
                    j -= b;
                    synchronized (i.this) {
                        boolean z3 = this.ptb.b() == 0;
                        this.ptb.b(this.psZ);
                        if (z3) {
                            i.this.notifyAll();
                        }
                    }
                }
            }
        }

        @Override // com.bytedance.sdk.a.a.s
        public t eoF() {
            return i.this.psW;
        }

        @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (i.this) {
                this.f3983a = true;
                this.ptb.r();
                i.this.notifyAll();
            }
            i.this.j();
        }

        private void c() throws IOException {
            if (this.f3983a) {
                throw new IOException("stream closed");
            }
            if (i.this.psY != null) {
                throw new o(i.this.psY);
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
            z = !this.psU.b && this.psU.f3983a && (this.psV.b || this.psV.f3982a);
            b2 = b();
        }
        if (z) {
            a(com.bytedance.sdk.a.b.a.e.b.CANCEL);
        } else if (!b2) {
            this.psD.OI(this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public final class a implements r {
        static final /* synthetic */ boolean c;

        /* renamed from: a  reason: collision with root package name */
        boolean f3982a;
        boolean b;
        private final com.bytedance.sdk.a.a.c psZ = new com.bytedance.sdk.a.a.c();

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
            this.psZ.a(cVar, j);
            while (this.psZ.b() >= 16384) {
                a(false);
            }
        }

        private void a(boolean z) throws IOException {
            long min;
            synchronized (i.this) {
                i.this.psX.a();
                while (i.this.b <= 0 && !this.b && !this.f3982a && i.this.psY == null) {
                    i.this.l();
                }
                i.this.psX.h();
                i.this.k();
                min = Math.min(i.this.b, this.psZ.b());
                i.this.b -= min;
            }
            i.this.psX.a();
            try {
                i.this.psD.a(i.this.c, z && min == this.psZ.b(), this.psZ, min);
            } finally {
                i.this.psX.h();
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
            while (this.psZ.b() > 0) {
                a(false);
                i.this.psD.b();
            }
        }

        @Override // com.bytedance.sdk.a.a.r
        public t eoF() {
            return i.this.psX;
        }

        @Override // com.bytedance.sdk.a.a.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!c && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            synchronized (i.this) {
                if (!this.f3982a) {
                    if (!i.this.psV.b) {
                        if (this.psZ.b() > 0) {
                            while (this.psZ.b() > 0) {
                                a(true);
                            }
                        } else {
                            i.this.psD.a(i.this.c, true, (com.bytedance.sdk.a.a.c) null, 0L);
                        }
                    }
                    synchronized (i.this) {
                        this.f3982a = true;
                    }
                    i.this.psD.b();
                    i.this.j();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j) {
        this.b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    void k() throws IOException {
        if (this.psV.f3982a) {
            throw new IOException("stream closed");
        }
        if (this.psV.b) {
            throw new IOException("stream finished");
        }
        if (this.psY != null) {
            throw new o(this.psY);
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
        protected void eoD() {
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
