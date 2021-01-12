package com.bytedance.sdk.a.b;

import com.bytedance.sdk.a.b.v;
import java.io.Closeable;
/* loaded from: classes4.dex */
public final class b implements Closeable {

    /* renamed from: b  reason: collision with root package name */
    final w f5953b;
    final int c;
    final String d;
    final long k;
    final long l;
    final ab pdR;
    final b pgA;
    final b pgB;
    private volatile g pgC;
    final u pgw;
    final v pgx;
    final c pgy;
    final b pgz;

    b(a aVar) {
        this.pdR = aVar.pdR;
        this.f5953b = aVar.f5954b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.pgw = aVar.pgw;
        this.pgx = aVar.pgD.enC();
        this.pgy = aVar.pgy;
        this.pgz = aVar.pgz;
        this.pgA = aVar.pgA;
        this.pgB = aVar.pgB;
        this.k = aVar.k;
        this.l = aVar.l;
    }

    public ab emS() {
        return this.pdR;
    }

    public w enj() {
        return this.f5953b;
    }

    public int c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public u enk() {
        return this.pgw;
    }

    public String a(String str) {
        return a(str, null);
    }

    public String a(String str, String str2) {
        String a2 = this.pgx.a(str);
        return a2 != null ? a2 : str2;
    }

    public v enl() {
        return this.pgx;
    }

    public c enm() {
        return this.pgy;
    }

    public a enn() {
        return new a(this);
    }

    public b eno() {
        return this.pgB;
    }

    public g enp() {
        g gVar = this.pgC;
        if (gVar != null) {
            return gVar;
        }
        g d = g.d(this.pgx);
        this.pgC = d;
        return d;
    }

    public long k() {
        return this.k;
    }

    public long l() {
        return this.l;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.pgy == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        this.pgy.close();
    }

    public String toString() {
        return "Response{protocol=" + this.f5953b + ", code=" + this.c + ", message=" + this.d + ", url=" + this.pdR.emp() + '}';
    }

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: b  reason: collision with root package name */
        w f5954b;
        int c;
        String d;
        long k;
        long l;
        ab pdR;
        b pgA;
        b pgB;
        v.a pgD;
        u pgw;
        c pgy;
        b pgz;

        public a() {
            this.c = -1;
            this.pgD = new v.a();
        }

        a(b bVar) {
            this.c = -1;
            this.pdR = bVar.pdR;
            this.f5954b = bVar.f5953b;
            this.c = bVar.c;
            this.d = bVar.d;
            this.pgw = bVar.pgw;
            this.pgD = bVar.pgx.enB();
            this.pgy = bVar.pgy;
            this.pgz = bVar.pgz;
            this.pgA = bVar.pgA;
            this.pgB = bVar.pgB;
            this.k = bVar.k;
            this.l = bVar.l;
        }

        public a f(ab abVar) {
            this.pdR = abVar;
            return this;
        }

        public a a(w wVar) {
            this.f5954b = wVar;
            return this;
        }

        public a Ok(int i) {
            this.c = i;
            return this;
        }

        public a XA(String str) {
            this.d = str;
            return this;
        }

        public a a(u uVar) {
            this.pgw = uVar;
            return this;
        }

        public a hb(String str, String str2) {
            this.pgD.hc(str, str2);
            return this;
        }

        public a c(v vVar) {
            this.pgD = vVar.enB();
            return this;
        }

        public a a(c cVar) {
            this.pgy = cVar;
            return this;
        }

        public a h(b bVar) {
            if (bVar != null) {
                a("networkResponse", bVar);
            }
            this.pgz = bVar;
            return this;
        }

        public a i(b bVar) {
            if (bVar != null) {
                a("cacheResponse", bVar);
            }
            this.pgA = bVar;
            return this;
        }

        private void a(String str, b bVar) {
            if (bVar.pgy != null) {
                throw new IllegalArgumentException(str + ".body != null");
            }
            if (bVar.pgz != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            if (bVar.pgA != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            }
            if (bVar.pgB != null) {
                throw new IllegalArgumentException(str + ".priorResponse != null");
            }
        }

        public a j(b bVar) {
            if (bVar != null) {
                k(bVar);
            }
            this.pgB = bVar;
            return this;
        }

        private void k(b bVar) {
            if (bVar.pgy != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public a ip(long j) {
            this.k = j;
            return this;
        }

        public a iq(long j) {
            this.l = j;
            return this;
        }

        public b enq() {
            if (this.pdR == null) {
                throw new IllegalStateException("request == null");
            }
            if (this.f5954b == null) {
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
