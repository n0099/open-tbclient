package com.bytedance.sdk.a.b;

import com.bytedance.sdk.a.b.v;
import java.io.Closeable;
/* loaded from: classes6.dex */
public final class b implements Closeable {
    final w b;
    final int c;
    final String d;
    final long k;
    final long l;
    final ab pqP;
    final b ptA;
    private volatile g ptB;
    final u ptv;
    final v ptw;
    final c ptx;
    final b pty;
    final b ptz;

    b(a aVar) {
        this.pqP = aVar.pqP;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.ptv = aVar.ptv;
        this.ptw = aVar.ptC.eqk();
        this.ptx = aVar.ptx;
        this.pty = aVar.pty;
        this.ptz = aVar.ptz;
        this.ptA = aVar.ptA;
        this.k = aVar.k;
        this.l = aVar.l;
    }

    public ab epB() {
        return this.pqP;
    }

    public w epR() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public boolean d() {
        return this.c >= 200 && this.c < 300;
    }

    public String e() {
        return this.d;
    }

    public u epS() {
        return this.ptv;
    }

    public String a(String str) {
        return a(str, null);
    }

    public String a(String str, String str2) {
        String a2 = this.ptw.a(str);
        return a2 != null ? a2 : str2;
    }

    public v epT() {
        return this.ptw;
    }

    public c epU() {
        return this.ptx;
    }

    public a epV() {
        return new a(this);
    }

    public b epW() {
        return this.ptA;
    }

    public g epX() {
        g gVar = this.ptB;
        if (gVar != null) {
            return gVar;
        }
        g d = g.d(this.ptw);
        this.ptB = d;
        return d;
    }

    public long l() {
        return this.k;
    }

    public long m() {
        return this.l;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.ptx == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        this.ptx.close();
    }

    public String toString() {
        return "Response{protocol=" + this.b + ", code=" + this.c + ", message=" + this.d + ", url=" + this.pqP.eoY() + '}';
    }

    /* loaded from: classes6.dex */
    public static class a {
        w b;
        int c;
        String d;
        long k;
        long l;
        ab pqP;
        b ptA;
        v.a ptC;
        u ptv;
        c ptx;
        b pty;
        b ptz;

        public a() {
            this.c = -1;
            this.ptC = new v.a();
        }

        a(b bVar) {
            this.c = -1;
            this.pqP = bVar.pqP;
            this.b = bVar.b;
            this.c = bVar.c;
            this.d = bVar.d;
            this.ptv = bVar.ptv;
            this.ptC = bVar.ptw.eqj();
            this.ptx = bVar.ptx;
            this.pty = bVar.pty;
            this.ptz = bVar.ptz;
            this.ptA = bVar.ptA;
            this.k = bVar.k;
            this.l = bVar.l;
        }

        public a f(ab abVar) {
            this.pqP = abVar;
            return this;
        }

        public a a(w wVar) {
            this.b = wVar;
            return this;
        }

        public a OK(int i) {
            this.c = i;
            return this;
        }

        public a YV(String str) {
            this.d = str;
            return this;
        }

        public a a(u uVar) {
            this.ptv = uVar;
            return this;
        }

        public a hk(String str, String str2) {
            this.ptC.hl(str, str2);
            return this;
        }

        public a c(v vVar) {
            this.ptC = vVar.eqj();
            return this;
        }

        public a a(c cVar) {
            this.ptx = cVar;
            return this;
        }

        public a h(b bVar) {
            if (bVar != null) {
                a("networkResponse", bVar);
            }
            this.pty = bVar;
            return this;
        }

        public a i(b bVar) {
            if (bVar != null) {
                a("cacheResponse", bVar);
            }
            this.ptz = bVar;
            return this;
        }

        private void a(String str, b bVar) {
            if (bVar.ptx != null) {
                throw new IllegalArgumentException(str + ".body != null");
            }
            if (bVar.pty != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            if (bVar.ptz != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            }
            if (bVar.ptA != null) {
                throw new IllegalArgumentException(str + ".priorResponse != null");
            }
        }

        public a j(b bVar) {
            if (bVar != null) {
                k(bVar);
            }
            this.ptA = bVar;
            return this;
        }

        private void k(b bVar) {
            if (bVar.ptx != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public a is(long j) {
            this.k = j;
            return this;
        }

        public a it(long j) {
            this.l = j;
            return this;
        }

        public b epY() {
            if (this.pqP == null) {
                throw new IllegalStateException("request == null");
            }
            if (this.b == null) {
                throw new IllegalStateException("protocol == null");
            }
            if (this.c < 0) {
                throw new IllegalStateException("code < 0: " + this.c);
            }
            if (this.d == null) {
                throw new IllegalStateException("message == null");
            }
            return new b(this);
        }
    }
}
