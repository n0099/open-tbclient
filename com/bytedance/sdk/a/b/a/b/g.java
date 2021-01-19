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
    private com.bytedance.sdk.a.b.a.c.c peA;
    private final m peh;
    public final com.bytedance.sdk.a.b.a peq;
    private f.a peu;
    private com.bytedance.sdk.a.b.d pev;
    public final h pew;
    public final t pex;
    private final f pey;
    private c pez;

    static {
        d = !g.class.desiredAssertionStatus();
    }

    public g(m mVar, com.bytedance.sdk.a.b.a aVar, h hVar, t tVar, Object obj) {
        this.peh = mVar;
        this.peq = aVar;
        this.pew = hVar;
        this.pex = tVar;
        this.pey = new f(aVar, emK(), hVar, tVar);
        this.h = obj;
    }

    public com.bytedance.sdk.a.b.a.c.c a(z zVar, x.a aVar, boolean z) {
        try {
            com.bytedance.sdk.a.b.a.c.c a2 = a(aVar.b(), aVar.c(), aVar.d(), zVar.r(), z).a(zVar, aVar, this);
            synchronized (this.peh) {
                this.peA = a2;
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
            synchronized (this.peh) {
                if (f.f5863b != 0) {
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
        Socket emI;
        c cVar2;
        boolean z2 = false;
        c cVar3 = null;
        com.bytedance.sdk.a.b.d dVar = null;
        synchronized (this.peh) {
            if (this.m) {
                throw new IllegalStateException("released");
            }
            if (this.peA != null) {
                throw new IllegalStateException("codec != null");
            }
            if (this.n) {
                throw new IOException(ResponseException.CANCELED);
            }
            cVar = this.pez;
            emI = emI();
            if (this.pez != null) {
                cVar3 = this.pez;
                cVar = null;
            }
            if (!this.l) {
                cVar = null;
            }
            if (cVar3 == null) {
                com.bytedance.sdk.a.b.a.a.pdN.a(this.peh, this.peq, this, null);
                if (this.pez != null) {
                    z2 = true;
                    cVar3 = this.pez;
                } else {
                    dVar = this.pev;
                }
            }
        }
        com.bytedance.sdk.a.b.a.c.a(emI);
        if (cVar != null) {
            this.pex.b(this.pew, cVar);
        }
        if (z2) {
            this.pex.a(this.pew, cVar3);
        }
        if (cVar3 != null) {
            return cVar3;
        }
        boolean z3 = false;
        if (dVar == null && (this.peu == null || !this.peu.a())) {
            z3 = true;
            this.peu = this.pey.emF();
        }
        synchronized (this.peh) {
            if (this.n) {
                throw new IOException(ResponseException.CANCELED);
            }
            if (z3) {
                List<com.bytedance.sdk.a.b.d> c = this.peu.c();
                int size = c.size();
                for (int i4 = 0; i4 < size; i4++) {
                    com.bytedance.sdk.a.b.d dVar2 = c.get(i4);
                    com.bytedance.sdk.a.b.a.a.pdN.a(this.peh, this.peq, this, dVar2);
                    if (this.pez != null) {
                        z2 = true;
                        c cVar4 = this.pez;
                        this.pev = dVar2;
                        cVar2 = cVar4;
                        break;
                    }
                }
            }
            cVar2 = cVar3;
            if (!z2) {
                com.bytedance.sdk.a.b.d emH = dVar == null ? this.peu.emH() : dVar;
                this.pev = emH;
                this.j = 0;
                cVar2 = new c(this.peh, emH);
                a(cVar2, false);
            }
        }
        if (z2) {
            this.pex.a(this.pew, cVar2);
            return cVar2;
        }
        cVar2.a(i, i2, i3, z, this.pew, this.pex);
        emK().b(cVar2.emC());
        Socket socket = null;
        synchronized (this.peh) {
            this.l = true;
            com.bytedance.sdk.a.b.a.a.pdN.a(this.peh, cVar2);
            if (cVar2.d()) {
                socket = com.bytedance.sdk.a.b.a.a.pdN.a(this.peh, this.peq, this);
                cVar2 = this.pez;
            }
        }
        com.bytedance.sdk.a.b.a.c.a(socket);
        this.pex.a(this.pew, cVar2);
        return cVar2;
    }

    private Socket emI() {
        if (d || Thread.holdsLock(this.peh)) {
            c cVar = this.pez;
            if (cVar == null || !cVar.f5862a) {
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
        this.pex.b(this.pew, j);
        synchronized (this.peh) {
            if (cVar != null) {
                if (cVar == this.peA) {
                    if (!z) {
                        this.pez.f5863b++;
                    }
                    cVar2 = this.pez;
                    n = n(z, false, true);
                    if (this.pez != null) {
                        cVar2 = null;
                    }
                    z2 = this.m;
                }
            }
            throw new IllegalStateException("expected " + this.peA + " but was " + cVar);
        }
        com.bytedance.sdk.a.b.a.c.a(n);
        if (cVar2 != null) {
            this.pex.b(this.pew, cVar2);
        }
        if (iOException != null) {
            this.pex.a(this.pew, iOException);
        } else if (z2) {
            this.pex.g(this.pew);
        }
    }

    public com.bytedance.sdk.a.b.a.c.c emJ() {
        com.bytedance.sdk.a.b.a.c.c cVar;
        synchronized (this.peh) {
            cVar = this.peA;
        }
        return cVar;
    }

    private d emK() {
        return com.bytedance.sdk.a.b.a.a.pdN.a(this.peh);
    }

    public synchronized c emL() {
        return this.pez;
    }

    public void c() {
        c cVar;
        Socket n;
        synchronized (this.peh) {
            cVar = this.pez;
            n = n(false, true, false);
            if (this.pez != null) {
                cVar = null;
            }
        }
        com.bytedance.sdk.a.b.a.c.a(n);
        if (cVar != null) {
            this.pex.b(this.pew, cVar);
        }
    }

    public void d() {
        c cVar;
        Socket n;
        synchronized (this.peh) {
            cVar = this.pez;
            n = n(true, false, false);
            if (this.pez != null) {
                cVar = null;
            }
        }
        com.bytedance.sdk.a.b.a.c.a(n);
        if (cVar != null) {
            this.pex.b(this.pew, cVar);
        }
    }

    private Socket n(boolean z, boolean z2, boolean z3) {
        Socket socket;
        if (d || Thread.holdsLock(this.peh)) {
            if (z3) {
                this.peA = null;
            }
            if (z2) {
                this.m = true;
            }
            if (this.pez != null) {
                if (z) {
                    this.pez.f5862a = true;
                }
                if (this.peA == null) {
                    if (this.m || this.pez.f5862a) {
                        a(this.pez);
                        if (this.pez.d.isEmpty()) {
                            this.pez.e = System.nanoTime();
                            if (com.bytedance.sdk.a.b.a.a.pdN.b(this.peh, this.pez)) {
                                socket = this.pez.emD();
                                this.pez = null;
                                return socket;
                            }
                        }
                        socket = null;
                        this.pez = null;
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
        synchronized (this.peh) {
            if (iOException instanceof o) {
                o oVar = (o) iOException;
                if (oVar.f5926a == com.bytedance.sdk.a.b.a.e.b.REFUSED_STREAM) {
                    this.j++;
                }
                if (oVar.f5926a != com.bytedance.sdk.a.b.a.e.b.REFUSED_STREAM || this.j > 1) {
                    this.pev = null;
                    z = true;
                }
                z2 = z;
            } else if (this.pez == null || (this.pez.d() && !(iOException instanceof com.bytedance.sdk.a.b.a.e.a))) {
                z2 = false;
            } else if (this.pez.f5863b == 0) {
                if (this.pev != null && iOException != null) {
                    this.pey.a(this.pev, iOException);
                }
                this.pev = null;
            }
            cVar = this.pez;
            n = n(z2, false, true);
            if (this.pez != null || !this.l) {
                cVar = null;
            }
        }
        com.bytedance.sdk.a.b.a.c.a(n);
        if (cVar != null) {
            this.pex.b(this.pew, cVar);
        }
    }

    public void a(c cVar, boolean z) {
        if (!d && !Thread.holdsLock(this.peh)) {
            throw new AssertionError();
        }
        if (this.pez != null) {
            throw new IllegalStateException();
        }
        this.pez = cVar;
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
        if (d || Thread.holdsLock(this.peh)) {
            if (this.peA == null && this.pez.d.size() == 1) {
                Socket n = n(true, false, false);
                this.pez = cVar;
                cVar.d.add(this.pez.d.get(0));
                return n;
            }
            throw new IllegalStateException();
        }
        throw new AssertionError();
    }

    public boolean e() {
        return this.pev != null || (this.peu != null && this.peu.a()) || this.pey.a();
    }

    public String toString() {
        c emL = emL();
        return emL != null ? emL.toString() : this.peq.toString();
    }

    /* loaded from: classes4.dex */
    public static final class a extends WeakReference<g> {

        /* renamed from: a  reason: collision with root package name */
        public final Object f5869a;

        a(g gVar, Object obj) {
            super(gVar);
            this.f5869a = obj;
        }
    }
}
