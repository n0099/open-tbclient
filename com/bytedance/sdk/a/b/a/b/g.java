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
/* loaded from: classes4.dex */
public final class g {
    static final /* synthetic */ boolean d;
    private final Object h;
    private int j;
    private boolean l;
    private boolean m;
    private boolean n;
    private final m piL;
    public final com.bytedance.sdk.a.b.a piU;
    private f.a piY;
    private com.bytedance.sdk.a.b.d piZ;
    public final h pja;
    public final t pjb;
    private final f pjc;
    private c pjd;
    private com.bytedance.sdk.a.b.a.c.c pje;

    static {
        d = !g.class.desiredAssertionStatus();
    }

    public g(m mVar, com.bytedance.sdk.a.b.a aVar, h hVar, t tVar, Object obj) {
        this.piL = mVar;
        this.piU = aVar;
        this.pja = hVar;
        this.pjb = tVar;
        this.pjc = new f(aVar, eqF(), hVar, tVar);
        this.h = obj;
    }

    public com.bytedance.sdk.a.b.a.c.c a(z zVar, x.a aVar, boolean z) {
        try {
            com.bytedance.sdk.a.b.a.c.c a2 = a(aVar.b(), aVar.c(), aVar.d(), zVar.r(), z).a(zVar, aVar, this);
            synchronized (this.piL) {
                this.pje = a2;
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
            synchronized (this.piL) {
                if (f.f6162b != 0) {
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
        Socket eqD;
        c cVar2;
        boolean z2 = false;
        c cVar3 = null;
        com.bytedance.sdk.a.b.d dVar = null;
        synchronized (this.piL) {
            if (this.m) {
                throw new IllegalStateException("released");
            }
            if (this.pje != null) {
                throw new IllegalStateException("codec != null");
            }
            if (this.n) {
                throw new IOException(ResponseException.CANCELED);
            }
            cVar = this.pjd;
            eqD = eqD();
            if (this.pjd != null) {
                cVar3 = this.pjd;
                cVar = null;
            }
            if (!this.l) {
                cVar = null;
            }
            if (cVar3 == null) {
                com.bytedance.sdk.a.b.a.a.pir.a(this.piL, this.piU, this, null);
                if (this.pjd != null) {
                    z2 = true;
                    cVar3 = this.pjd;
                } else {
                    dVar = this.piZ;
                }
            }
        }
        com.bytedance.sdk.a.b.a.c.a(eqD);
        if (cVar != null) {
            this.pjb.b(this.pja, cVar);
        }
        if (z2) {
            this.pjb.a(this.pja, cVar3);
        }
        if (cVar3 != null) {
            return cVar3;
        }
        boolean z3 = false;
        if (dVar == null && (this.piY == null || !this.piY.a())) {
            z3 = true;
            this.piY = this.pjc.eqA();
        }
        synchronized (this.piL) {
            if (this.n) {
                throw new IOException(ResponseException.CANCELED);
            }
            if (z3) {
                List<com.bytedance.sdk.a.b.d> c = this.piY.c();
                int size = c.size();
                for (int i4 = 0; i4 < size; i4++) {
                    com.bytedance.sdk.a.b.d dVar2 = c.get(i4);
                    com.bytedance.sdk.a.b.a.a.pir.a(this.piL, this.piU, this, dVar2);
                    if (this.pjd != null) {
                        z2 = true;
                        c cVar4 = this.pjd;
                        this.piZ = dVar2;
                        cVar2 = cVar4;
                        break;
                    }
                }
            }
            cVar2 = cVar3;
            if (!z2) {
                com.bytedance.sdk.a.b.d eqC = dVar == null ? this.piY.eqC() : dVar;
                this.piZ = eqC;
                this.j = 0;
                cVar2 = new c(this.piL, eqC);
                a(cVar2, false);
            }
        }
        if (z2) {
            this.pjb.a(this.pja, cVar2);
            return cVar2;
        }
        cVar2.a(i, i2, i3, z, this.pja, this.pjb);
        eqF().b(cVar2.eqx());
        Socket socket = null;
        synchronized (this.piL) {
            this.l = true;
            com.bytedance.sdk.a.b.a.a.pir.a(this.piL, cVar2);
            if (cVar2.d()) {
                socket = com.bytedance.sdk.a.b.a.a.pir.a(this.piL, this.piU, this);
                cVar2 = this.pjd;
            }
        }
        com.bytedance.sdk.a.b.a.c.a(socket);
        this.pjb.a(this.pja, cVar2);
        return cVar2;
    }

    private Socket eqD() {
        if (d || Thread.holdsLock(this.piL)) {
            c cVar = this.pjd;
            if (cVar == null || !cVar.f6161a) {
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
        this.pjb.b(this.pja, j);
        synchronized (this.piL) {
            if (cVar != null) {
                if (cVar == this.pje) {
                    if (!z) {
                        this.pjd.f6162b++;
                    }
                    cVar2 = this.pjd;
                    n = n(z, false, true);
                    if (this.pjd != null) {
                        cVar2 = null;
                    }
                    z2 = this.m;
                }
            }
            throw new IllegalStateException("expected " + this.pje + " but was " + cVar);
        }
        com.bytedance.sdk.a.b.a.c.a(n);
        if (cVar2 != null) {
            this.pjb.b(this.pja, cVar2);
        }
        if (iOException != null) {
            this.pjb.a(this.pja, iOException);
        } else if (z2) {
            this.pjb.g(this.pja);
        }
    }

    public com.bytedance.sdk.a.b.a.c.c eqE() {
        com.bytedance.sdk.a.b.a.c.c cVar;
        synchronized (this.piL) {
            cVar = this.pje;
        }
        return cVar;
    }

    private d eqF() {
        return com.bytedance.sdk.a.b.a.a.pir.a(this.piL);
    }

    public synchronized c eqG() {
        return this.pjd;
    }

    public void c() {
        c cVar;
        Socket n;
        synchronized (this.piL) {
            cVar = this.pjd;
            n = n(false, true, false);
            if (this.pjd != null) {
                cVar = null;
            }
        }
        com.bytedance.sdk.a.b.a.c.a(n);
        if (cVar != null) {
            this.pjb.b(this.pja, cVar);
        }
    }

    public void d() {
        c cVar;
        Socket n;
        synchronized (this.piL) {
            cVar = this.pjd;
            n = n(true, false, false);
            if (this.pjd != null) {
                cVar = null;
            }
        }
        com.bytedance.sdk.a.b.a.c.a(n);
        if (cVar != null) {
            this.pjb.b(this.pja, cVar);
        }
    }

    private Socket n(boolean z, boolean z2, boolean z3) {
        Socket socket;
        if (d || Thread.holdsLock(this.piL)) {
            if (z3) {
                this.pje = null;
            }
            if (z2) {
                this.m = true;
            }
            if (this.pjd != null) {
                if (z) {
                    this.pjd.f6161a = true;
                }
                if (this.pje == null) {
                    if (this.m || this.pjd.f6161a) {
                        a(this.pjd);
                        if (this.pjd.d.isEmpty()) {
                            this.pjd.e = System.nanoTime();
                            if (com.bytedance.sdk.a.b.a.a.pir.b(this.piL, this.pjd)) {
                                socket = this.pjd.eqy();
                                this.pjd = null;
                                return socket;
                            }
                        }
                        socket = null;
                        this.pjd = null;
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
        synchronized (this.piL) {
            if (iOException instanceof o) {
                o oVar = (o) iOException;
                if (oVar.f6225a == com.bytedance.sdk.a.b.a.e.b.REFUSED_STREAM) {
                    this.j++;
                }
                if (oVar.f6225a != com.bytedance.sdk.a.b.a.e.b.REFUSED_STREAM || this.j > 1) {
                    this.piZ = null;
                    z = true;
                }
                z2 = z;
            } else if (this.pjd == null || (this.pjd.d() && !(iOException instanceof com.bytedance.sdk.a.b.a.e.a))) {
                z2 = false;
            } else if (this.pjd.f6162b == 0) {
                if (this.piZ != null && iOException != null) {
                    this.pjc.a(this.piZ, iOException);
                }
                this.piZ = null;
            }
            cVar = this.pjd;
            n = n(z2, false, true);
            if (this.pjd != null || !this.l) {
                cVar = null;
            }
        }
        com.bytedance.sdk.a.b.a.c.a(n);
        if (cVar != null) {
            this.pjb.b(this.pja, cVar);
        }
    }

    public void a(c cVar, boolean z) {
        if (!d && !Thread.holdsLock(this.piL)) {
            throw new AssertionError();
        }
        if (this.pjd != null) {
            throw new IllegalStateException();
        }
        this.pjd = cVar;
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
        if (d || Thread.holdsLock(this.piL)) {
            if (this.pje == null && this.pjd.d.size() == 1) {
                Socket n = n(true, false, false);
                this.pjd = cVar;
                cVar.d.add(this.pjd.d.get(0));
                return n;
            }
            throw new IllegalStateException();
        }
        throw new AssertionError();
    }

    public boolean e() {
        return this.piZ != null || (this.piY != null && this.piY.a()) || this.pjc.a();
    }

    public String toString() {
        c eqG = eqG();
        return eqG != null ? eqG.toString() : this.piU.toString();
    }

    /* loaded from: classes4.dex */
    public static final class a extends WeakReference<g> {

        /* renamed from: a  reason: collision with root package name */
        public final Object f6168a;

        a(g gVar, Object obj) {
            super(gVar);
            this.f6168a = obj;
        }
    }
}
