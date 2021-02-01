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
    public final com.bytedance.sdk.a.b.a poG;
    private f.a poK;
    private com.bytedance.sdk.a.b.d poL;
    public final h poM;
    public final t poN;
    private final f poO;
    private c poP;
    private com.bytedance.sdk.a.b.a.c.c poQ;
    private final m pox;

    static {
        d = !g.class.desiredAssertionStatus();
    }

    public g(m mVar, com.bytedance.sdk.a.b.a aVar, h hVar, t tVar, Object obj) {
        this.pox = mVar;
        this.poG = aVar;
        this.poM = hVar;
        this.poN = tVar;
        this.poO = new f(aVar, epe(), hVar, tVar);
        this.h = obj;
    }

    public com.bytedance.sdk.a.b.a.c.c a(z zVar, x.a aVar, boolean z) {
        try {
            com.bytedance.sdk.a.b.a.c.c a2 = a(aVar.b(), aVar.c(), aVar.d(), zVar.r(), z).a(zVar, aVar, this);
            synchronized (this.pox) {
                this.poQ = a2;
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
            synchronized (this.pox) {
                if (f.f5865b != 0) {
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
        Socket epc;
        c cVar2;
        boolean z2 = false;
        c cVar3 = null;
        com.bytedance.sdk.a.b.d dVar = null;
        synchronized (this.pox) {
            if (this.m) {
                throw new IllegalStateException("released");
            }
            if (this.poQ != null) {
                throw new IllegalStateException("codec != null");
            }
            if (this.n) {
                throw new IOException(ResponseException.CANCELED);
            }
            cVar = this.poP;
            epc = epc();
            if (this.poP != null) {
                cVar3 = this.poP;
                cVar = null;
            }
            if (!this.l) {
                cVar = null;
            }
            if (cVar3 == null) {
                com.bytedance.sdk.a.b.a.a.poa.a(this.pox, this.poG, this, null);
                if (this.poP != null) {
                    z2 = true;
                    cVar3 = this.poP;
                } else {
                    dVar = this.poL;
                }
            }
        }
        com.bytedance.sdk.a.b.a.c.a(epc);
        if (cVar != null) {
            this.poN.b(this.poM, cVar);
        }
        if (z2) {
            this.poN.a(this.poM, cVar3);
        }
        if (cVar3 != null) {
            return cVar3;
        }
        boolean z3 = false;
        if (dVar == null && (this.poK == null || !this.poK.a())) {
            z3 = true;
            this.poK = this.poO.eoZ();
        }
        synchronized (this.pox) {
            if (this.n) {
                throw new IOException(ResponseException.CANCELED);
            }
            if (z3) {
                List<com.bytedance.sdk.a.b.d> c = this.poK.c();
                int size = c.size();
                for (int i4 = 0; i4 < size; i4++) {
                    com.bytedance.sdk.a.b.d dVar2 = c.get(i4);
                    com.bytedance.sdk.a.b.a.a.poa.a(this.pox, this.poG, this, dVar2);
                    if (this.poP != null) {
                        z2 = true;
                        c cVar4 = this.poP;
                        this.poL = dVar2;
                        cVar2 = cVar4;
                        break;
                    }
                }
            }
            cVar2 = cVar3;
            if (!z2) {
                com.bytedance.sdk.a.b.d epb = dVar == null ? this.poK.epb() : dVar;
                this.poL = epb;
                this.j = 0;
                cVar2 = new c(this.pox, epb);
                a(cVar2, false);
            }
        }
        if (z2) {
            this.poN.a(this.poM, cVar2);
            return cVar2;
        }
        cVar2.a(i, i2, i3, z, this.poM, this.poN);
        epe().b(cVar2.eoW());
        Socket socket = null;
        synchronized (this.pox) {
            this.l = true;
            com.bytedance.sdk.a.b.a.a.poa.a(this.pox, cVar2);
            if (cVar2.d()) {
                socket = com.bytedance.sdk.a.b.a.a.poa.a(this.pox, this.poG, this);
                cVar2 = this.poP;
            }
        }
        com.bytedance.sdk.a.b.a.c.a(socket);
        this.poN.a(this.poM, cVar2);
        return cVar2;
    }

    private Socket epc() {
        if (d || Thread.holdsLock(this.pox)) {
            c cVar = this.poP;
            if (cVar == null || !cVar.f5864a) {
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
        this.poN.b(this.poM, j);
        synchronized (this.pox) {
            if (cVar != null) {
                if (cVar == this.poQ) {
                    if (!z) {
                        this.poP.f5865b++;
                    }
                    cVar2 = this.poP;
                    n = n(z, false, true);
                    if (this.poP != null) {
                        cVar2 = null;
                    }
                    z2 = this.m;
                }
            }
            throw new IllegalStateException("expected " + this.poQ + " but was " + cVar);
        }
        com.bytedance.sdk.a.b.a.c.a(n);
        if (cVar2 != null) {
            this.poN.b(this.poM, cVar2);
        }
        if (iOException != null) {
            this.poN.a(this.poM, iOException);
        } else if (z2) {
            this.poN.g(this.poM);
        }
    }

    public com.bytedance.sdk.a.b.a.c.c epd() {
        com.bytedance.sdk.a.b.a.c.c cVar;
        synchronized (this.pox) {
            cVar = this.poQ;
        }
        return cVar;
    }

    private d epe() {
        return com.bytedance.sdk.a.b.a.a.poa.a(this.pox);
    }

    public synchronized c epf() {
        return this.poP;
    }

    public void c() {
        c cVar;
        Socket n;
        synchronized (this.pox) {
            cVar = this.poP;
            n = n(false, true, false);
            if (this.poP != null) {
                cVar = null;
            }
        }
        com.bytedance.sdk.a.b.a.c.a(n);
        if (cVar != null) {
            this.poN.b(this.poM, cVar);
        }
    }

    public void d() {
        c cVar;
        Socket n;
        synchronized (this.pox) {
            cVar = this.poP;
            n = n(true, false, false);
            if (this.poP != null) {
                cVar = null;
            }
        }
        com.bytedance.sdk.a.b.a.c.a(n);
        if (cVar != null) {
            this.poN.b(this.poM, cVar);
        }
    }

    private Socket n(boolean z, boolean z2, boolean z3) {
        Socket socket;
        if (d || Thread.holdsLock(this.pox)) {
            if (z3) {
                this.poQ = null;
            }
            if (z2) {
                this.m = true;
            }
            if (this.poP != null) {
                if (z) {
                    this.poP.f5864a = true;
                }
                if (this.poQ == null) {
                    if (this.m || this.poP.f5864a) {
                        a(this.poP);
                        if (this.poP.d.isEmpty()) {
                            this.poP.e = System.nanoTime();
                            if (com.bytedance.sdk.a.b.a.a.poa.b(this.pox, this.poP)) {
                                socket = this.poP.eoX();
                                this.poP = null;
                                return socket;
                            }
                        }
                        socket = null;
                        this.poP = null;
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
        synchronized (this.pox) {
            if (iOException instanceof o) {
                o oVar = (o) iOException;
                if (oVar.f5928a == com.bytedance.sdk.a.b.a.e.b.REFUSED_STREAM) {
                    this.j++;
                }
                if (oVar.f5928a != com.bytedance.sdk.a.b.a.e.b.REFUSED_STREAM || this.j > 1) {
                    this.poL = null;
                    z = true;
                }
                z2 = z;
            } else if (this.poP == null || (this.poP.d() && !(iOException instanceof com.bytedance.sdk.a.b.a.e.a))) {
                z2 = false;
            } else if (this.poP.f5865b == 0) {
                if (this.poL != null && iOException != null) {
                    this.poO.a(this.poL, iOException);
                }
                this.poL = null;
            }
            cVar = this.poP;
            n = n(z2, false, true);
            if (this.poP != null || !this.l) {
                cVar = null;
            }
        }
        com.bytedance.sdk.a.b.a.c.a(n);
        if (cVar != null) {
            this.poN.b(this.poM, cVar);
        }
    }

    public void a(c cVar, boolean z) {
        if (!d && !Thread.holdsLock(this.pox)) {
            throw new AssertionError();
        }
        if (this.poP != null) {
            throw new IllegalStateException();
        }
        this.poP = cVar;
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
        if (d || Thread.holdsLock(this.pox)) {
            if (this.poQ == null && this.poP.d.size() == 1) {
                Socket n = n(true, false, false);
                this.poP = cVar;
                cVar.d.add(this.poP.d.get(0));
                return n;
            }
            throw new IllegalStateException();
        }
        throw new AssertionError();
    }

    public boolean e() {
        return this.poL != null || (this.poK != null && this.poK.a()) || this.poO.a();
    }

    public String toString() {
        c epf = epf();
        return epf != null ? epf.toString() : this.poG.toString();
    }

    /* loaded from: classes6.dex */
    public static final class a extends WeakReference<g> {

        /* renamed from: a  reason: collision with root package name */
        public final Object f5871a;

        a(g gVar, Object obj) {
            super(gVar);
            this.f5871a = obj;
        }
    }
}
