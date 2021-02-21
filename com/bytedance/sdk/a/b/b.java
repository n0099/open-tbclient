package com.bytedance.sdk.a.b;

import com.bytedance.sdk.a.b.v;
import java.io.Closeable;
/* loaded from: classes6.dex */
public final class b implements Closeable {

    /* renamed from: b  reason: collision with root package name */
    final w f5955b;
    final int c;
    final String d;
    final long k;
    final long l;
    final ab poI;
    final u prp;
    final v prq;
    final c prr;
    final b prs;
    final b prt;
    final b pru;
    private volatile g prv;

    b(a aVar) {
        this.poI = aVar.poI;
        this.f5955b = aVar.f5956b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.prp = aVar.prp;
        this.prq = aVar.prw.eqd();
        this.prr = aVar.prr;
        this.prs = aVar.prs;
        this.prt = aVar.prt;
        this.pru = aVar.pru;
        this.k = aVar.k;
        this.l = aVar.l;
    }

    public ab epu() {
        return this.poI;
    }

    public w epK() {
        return this.f5955b;
    }

    public int c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public u epL() {
        return this.prp;
    }

    public String a(String str) {
        return a(str, null);
    }

    public String a(String str, String str2) {
        String a2 = this.prq.a(str);
        return a2 != null ? a2 : str2;
    }

    public v epM() {
        return this.prq;
    }

    public c epN() {
        return this.prr;
    }

    public a epO() {
        return new a(this);
    }

    public b epP() {
        return this.pru;
    }

    public g epQ() {
        g gVar = this.prv;
        if (gVar != null) {
            return gVar;
        }
        g d = g.d(this.prq);
        this.prv = d;
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
        if (this.prr == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        this.prr.close();
    }

    public String toString() {
        return "Response{protocol=" + this.f5955b + ", code=" + this.c + ", message=" + this.d + ", url=" + this.poI.eoR() + '}';
    }

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: b  reason: collision with root package name */
        w f5956b;
        int c;
        String d;
        long k;
        long l;
        ab poI;
        u prp;
        c prr;
        b prs;
        b prt;
        b pru;
        v.a prw;

        public a() {
            this.c = -1;
            this.prw = new v.a();
        }

        a(b bVar) {
            this.c = -1;
            this.poI = bVar.poI;
            this.f5956b = bVar.f5955b;
            this.c = bVar.c;
            this.d = bVar.d;
            this.prp = bVar.prp;
            this.prw = bVar.prq.eqc();
            this.prr = bVar.prr;
            this.prs = bVar.prs;
            this.prt = bVar.prt;
            this.pru = bVar.pru;
            this.k = bVar.k;
            this.l = bVar.l;
        }

        public a f(ab abVar) {
            this.poI = abVar;
            return this;
        }

        public a a(w wVar) {
            this.f5956b = wVar;
            return this;
        }

        public a OG(int i) {
            this.c = i;
            return this;
        }

        public a YO(String str) {
            this.d = str;
            return this;
        }

        public a a(u uVar) {
            this.prp = uVar;
            return this;
        }

        public a hk(String str, String str2) {
            this.prw.hl(str, str2);
            return this;
        }

        public a c(v vVar) {
            this.prw = vVar.eqc();
            return this;
        }

        public a a(c cVar) {
            this.prr = cVar;
            return this;
        }

        public a h(b bVar) {
            if (bVar != null) {
                a("networkResponse", bVar);
            }
            this.prs = bVar;
            return this;
        }

        public a i(b bVar) {
            if (bVar != null) {
                a("cacheResponse", bVar);
            }
            this.prt = bVar;
            return this;
        }

        private void a(String str, b bVar) {
            if (bVar.prr != null) {
                throw new IllegalArgumentException(str + ".body != null");
            }
            if (bVar.prs != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            if (bVar.prt != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            }
            if (bVar.pru != null) {
                throw new IllegalArgumentException(str + ".priorResponse != null");
            }
        }

        public a j(b bVar) {
            if (bVar != null) {
                k(bVar);
            }
            this.pru = bVar;
            return this;
        }

        private void k(b bVar) {
            if (bVar.prr != null) {
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

        public b epR() {
            if (this.poI == null) {
                throw new IllegalStateException("request == null");
            }
            if (this.f5956b == null) {
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
