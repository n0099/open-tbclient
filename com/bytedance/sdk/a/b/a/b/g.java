package com.bytedance.sdk.a.b.a.b;

import com.baidu.searchbox.http.response.ResponseException;
import com.bytedance.sdk.a.b.a.b.f;
import com.bytedance.sdk.a.b.a.e.o;
import com.bytedance.sdk.a.b.h;
import com.bytedance.sdk.a.b.m;
import com.bytedance.sdk.a.b.t;
import com.bytedance.sdk.a.b.x;
import com.bytedance.sdk.a.b.z;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;
/* loaded from: classes6.dex */
public final class g {
    static final /* synthetic */ boolean d;
    private final Object h;
    private int j;
    private boolean l;
    private boolean m;
    private boolean n;
    private final m pre;
    public final com.bytedance.sdk.a.b.a prn;
    private f.a prr;
    private com.bytedance.sdk.a.b.d prs;
    public final h prt;
    public final t pru;
    private final f prv;
    private c prw;
    private com.bytedance.sdk.a.b.a.c.c prx;

    static {
        d = !g.class.desiredAssertionStatus();
    }

    public g(m mVar, com.bytedance.sdk.a.b.a aVar, h hVar, t tVar, Object obj) {
        this.pre = mVar;
        this.prn = aVar;
        this.prt = hVar;
        this.pru = tVar;
        this.prv = new f(aVar, ept(), hVar, tVar);
        this.h = obj;
    }

    public com.bytedance.sdk.a.b.a.c.c a(z zVar, x.a aVar, boolean z) {
        try {
            com.bytedance.sdk.a.b.a.c.c a2 = a(aVar.b(), aVar.c(), aVar.d(), zVar.r(), z).a(zVar, aVar, this);
            synchronized (this.pre) {
                this.prx = a2;
            }
            return a2;
        } catch (IOException e) {
            throw new e(e);
        }
    }

    private c a(int i, int i2, int i3, boolean z, boolean z2) throws IOException {
        c f;
        while (true) {
            f = f(i, i2, i3, z);
            synchronized (this.pre) {
                if (f.b != 0) {
                    if (f.a(z2)) {
                        break;
                    }
                    d();
                } else {
                    break;
                }
            }
        }
        return f;
    }

    private c f(int i, int i2, int i3, boolean z) throws IOException {
        c cVar;
        Socket epr;
        c cVar2;
        boolean z2 = false;
        c cVar3 = null;
        com.bytedance.sdk.a.b.d dVar = null;
        synchronized (this.pre) {
            if (this.m) {
                throw new IllegalStateException("released");
            }
            if (this.prx != null) {
                throw new IllegalStateException("codec != null");
            }
            if (this.n) {
                throw new IOException(ResponseException.CANCELED);
            }
            cVar = this.prw;
            epr = epr();
            if (this.prw != null) {
                cVar3 = this.prw;
                cVar = null;
            }
            if (!this.l) {
                cVar = null;
            }
            if (cVar3 == null) {
                com.bytedance.sdk.a.b.a.a.pqK.a(this.pre, this.prn, this, null);
                if (this.prw != null) {
                    z2 = true;
                    cVar3 = this.prw;
                } else {
                    dVar = this.prs;
                }
            }
        }
        com.bytedance.sdk.a.b.a.c.a(epr);
        if (cVar != null) {
            this.pru.b(this.prt, cVar);
        }
        if (z2) {
            this.pru.a(this.prt, cVar3);
        }
        if (cVar3 != null) {
            return cVar3;
        }
        boolean z3 = false;
        if (dVar == null && (this.prr == null || !this.prr.a())) {
            z3 = true;
            this.prr = this.prv.epo();
        }
        synchronized (this.pre) {
            if (this.n) {
                throw new IOException(ResponseException.CANCELED);
            }
            if (z3) {
                List<com.bytedance.sdk.a.b.d> c = this.prr.c();
                int size = c.size();
                for (int i4 = 0; i4 < size; i4++) {
                    com.bytedance.sdk.a.b.d dVar2 = c.get(i4);
                    com.bytedance.sdk.a.b.a.a.pqK.a(this.pre, this.prn, this, dVar2);
                    if (this.prw != null) {
                        z2 = true;
                        c cVar4 = this.prw;
                        this.prs = dVar2;
                        cVar2 = cVar4;
                        break;
                    }
                }
            }
            cVar2 = cVar3;
            if (!z2) {
                com.bytedance.sdk.a.b.d epq = dVar == null ? this.prr.epq() : dVar;
                this.prs = epq;
                this.j = 0;
                cVar2 = new c(this.pre, epq);
                a(cVar2, false);
            }
        }
        if (z2) {
            this.pru.a(this.prt, cVar2);
            return cVar2;
        }
        cVar2.a(i, i2, i3, z, this.prt, this.pru);
        ept().b(cVar2.epl());
        Socket socket = null;
        synchronized (this.pre) {
            this.l = true;
            com.bytedance.sdk.a.b.a.a.pqK.a(this.pre, cVar2);
            if (cVar2.d()) {
                socket = com.bytedance.sdk.a.b.a.a.pqK.a(this.pre, this.prn, this);
                cVar2 = this.prw;
            }
        }
        com.bytedance.sdk.a.b.a.c.a(socket);
        this.pru.a(this.prt, cVar2);
        return cVar2;
    }

    private Socket epr() {
        if (d || Thread.holdsLock(this.pre)) {
            c cVar = this.prw;
            if (cVar == null || !cVar.f3951a) {
                return null;
            }
            return n(false, false, true);
        }
        throw new AssertionError();
    }

    public void a(boolean z, com.bytedance.sdk.a.b.a.c.c cVar, long j, IOException iOException) {
        c cVar2;
        Socket n;
        boolean z2;
        this.pru.b(this.prt, j);
        synchronized (this.pre) {
            if (cVar != null) {
                if (cVar == this.prx) {
                    if (!z) {
                        this.prw.b++;
                    }
                    cVar2 = this.prw;
                    n = n(z, false, true);
                    if (this.prw != null) {
                        cVar2 = null;
                    }
                    z2 = this.m;
                }
            }
            throw new IllegalStateException("expected " + this.prx + " but was " + cVar);
        }
        com.bytedance.sdk.a.b.a.c.a(n);
        if (cVar2 != null) {
            this.pru.b(this.prt, cVar2);
        }
        if (iOException != null) {
            this.pru.a(this.prt, iOException);
        } else if (z2) {
            this.pru.g(this.prt);
        }
    }

    public com.bytedance.sdk.a.b.a.c.c eps() {
        com.bytedance.sdk.a.b.a.c.c cVar;
        synchronized (this.pre) {
            cVar = this.prx;
        }
        return cVar;
    }

    private d ept() {
        return com.bytedance.sdk.a.b.a.a.pqK.a(this.pre);
    }

    public synchronized c epu() {
        return this.prw;
    }

    public void c() {
        c cVar;
        Socket n;
        synchronized (this.pre) {
            cVar = this.prw;
            n = n(false, true, false);
            if (this.prw != null) {
                cVar = null;
            }
        }
        com.bytedance.sdk.a.b.a.c.a(n);
        if (cVar != null) {
            this.pru.b(this.prt, cVar);
        }
    }

    public void d() {
        c cVar;
        Socket n;
        synchronized (this.pre) {
            cVar = this.prw;
            n = n(true, false, false);
            if (this.prw != null) {
                cVar = null;
            }
        }
        com.bytedance.sdk.a.b.a.c.a(n);
        if (cVar != null) {
            this.pru.b(this.prt, cVar);
        }
    }

    private Socket n(boolean z, boolean z2, boolean z3) {
        Socket socket;
        if (d || Thread.holdsLock(this.pre)) {
            if (z3) {
                this.prx = null;
            }
            if (z2) {
                this.m = true;
            }
            if (this.prw != null) {
                if (z) {
                    this.prw.f3951a = true;
                }
                if (this.prx == null) {
                    if (this.m || this.prw.f3951a) {
                        a(this.prw);
                        if (this.prw.d.isEmpty()) {
                            this.prw.e = System.nanoTime();
                            if (com.bytedance.sdk.a.b.a.a.pqK.b(this.pre, this.prw)) {
                                socket = this.prw.epm();
                                this.prw = null;
                                return socket;
                            }
                        }
                        socket = null;
                        this.prw = null;
                        return socket;
                    }
                    return null;
                }
                return null;
            }
            return null;
        }
        throw new AssertionError();
    }

    public void a(IOException iOException) {
        c cVar;
        Socket n;
        boolean z = false;
        boolean z2 = true;
        synchronized (this.pre) {
            if (iOException instanceof o) {
                o oVar = (o) iOException;
                if (oVar.f3987a == com.bytedance.sdk.a.b.a.e.b.REFUSED_STREAM) {
                    this.j++;
                }
                if (oVar.f3987a != com.bytedance.sdk.a.b.a.e.b.REFUSED_STREAM || this.j > 1) {
                    this.prs = null;
                    z = true;
                }
                z2 = z;
            } else if (this.prw == null || (this.prw.d() && !(iOException instanceof com.bytedance.sdk.a.b.a.e.a))) {
                z2 = false;
            } else if (this.prw.b == 0) {
                if (this.prs != null && iOException != null) {
                    this.prv.a(this.prs, iOException);
                }
                this.prs = null;
            }
            cVar = this.prw;
            n = n(z2, false, true);
            if (this.prw != null || !this.l) {
                cVar = null;
            }
        }
        com.bytedance.sdk.a.b.a.c.a(n);
        if (cVar != null) {
            this.pru.b(this.prt, cVar);
        }
    }

    public void a(c cVar, boolean z) {
        if (!d && !Thread.holdsLock(this.pre)) {
            throw new AssertionError();
        }
        if (this.prw != null) {
            throw new IllegalStateException();
        }
        this.prw = cVar;
        this.l = z;
        cVar.d.add(new a(this, this.h));
    }

    private void a(c cVar) {
        int size = cVar.d.size();
        for (int i = 0; i < size; i++) {
            if (cVar.d.get(i).get() == this) {
                cVar.d.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    public Socket b(c cVar) {
        if (d || Thread.holdsLock(this.pre)) {
            if (this.prx == null && this.prw.d.size() == 1) {
                Socket n = n(true, false, false);
                this.prw = cVar;
                cVar.d.add(this.prw.d.get(0));
                return n;
            }
            throw new IllegalStateException();
        }
        throw new AssertionError();
    }

    public boolean e() {
        return this.prs != null || (this.prr != null && this.prr.a()) || this.prv.a();
    }

    public String toString() {
        c epu = epu();
        return epu != null ? epu.toString() : this.prn.toString();
    }

    /* loaded from: classes6.dex */
    public static final class a extends WeakReference<g> {

        /* renamed from: a  reason: collision with root package name */
        public final Object f3955a;

        a(g gVar, Object obj) {
            super(gVar);
            this.f3955a = obj;
        }
    }
}
