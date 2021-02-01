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
    final ab pof;
    final u pqP;
    final v pqQ;
    final c pqR;
    final b pqS;
    final b pqT;
    final b pqU;
    private volatile g pqV;

    b(a aVar) {
        this.pof = aVar.pof;
        this.f5955b = aVar.f5956b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.pqP = aVar.pqP;
        this.pqQ = aVar.pqW.epV();
        this.pqR = aVar.pqR;
        this.pqS = aVar.pqS;
        this.pqT = aVar.pqT;
        this.pqU = aVar.pqU;
        this.k = aVar.k;
        this.l = aVar.l;
    }

    public ab epm() {
        return this.pof;
    }

    public w epC() {
        return this.f5955b;
    }

    public int c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public u epD() {
        return this.pqP;
    }

    public String a(String str) {
        return a(str, null);
    }

    public String a(String str, String str2) {
        String a2 = this.pqQ.a(str);
        return a2 != null ? a2 : str2;
    }

    public v epE() {
        return this.pqQ;
    }

    public c epF() {
        return this.pqR;
    }

    public a epG() {
        return new a(this);
    }

    public b epH() {
        return this.pqU;
    }

    public g epI() {
        g gVar = this.pqV;
        if (gVar != null) {
            return gVar;
        }
        g d = g.d(this.pqQ);
        this.pqV = d;
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
        if (this.pqR == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        this.pqR.close();
    }

    public String toString() {
        return "Response{protocol=" + this.f5955b + ", code=" + this.c + ", message=" + this.d + ", url=" + this.pof.eoJ() + '}';
    }

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: b  reason: collision with root package name */
        w f5956b;
        int c;
        String d;
        long k;
        long l;
        ab pof;
        u pqP;
        c pqR;
        b pqS;
        b pqT;
        b pqU;
        v.a pqW;

        public a() {
            this.c = -1;
            this.pqW = new v.a();
        }

        a(b bVar) {
            this.c = -1;
            this.pof = bVar.pof;
            this.f5956b = bVar.f5955b;
            this.c = bVar.c;
            this.d = bVar.d;
            this.pqP = bVar.pqP;
            this.pqW = bVar.pqQ.epU();
            this.pqR = bVar.pqR;
            this.pqS = bVar.pqS;
            this.pqT = bVar.pqT;
            this.pqU = bVar.pqU;
            this.k = bVar.k;
            this.l = bVar.l;
        }

        public a f(ab abVar) {
            this.pof = abVar;
            return this;
        }

        public a a(w wVar) {
            this.f5956b = wVar;
            return this;
        }

        public a OF(int i) {
            this.c = i;
            return this;
        }

        public a YC(String str) {
            this.d = str;
            return this;
        }

        public a a(u uVar) {
            this.pqP = uVar;
            return this;
        }

        public a hi(String str, String str2) {
            this.pqW.hj(str, str2);
            return this;
        }

        public a c(v vVar) {
            this.pqW = vVar.epU();
            return this;
        }

        public a a(c cVar) {
            this.pqR = cVar;
            return this;
        }

        public a h(b bVar) {
            if (bVar != null) {
                a("networkResponse", bVar);
            }
            this.pqS = bVar;
            return this;
        }

        public a i(b bVar) {
            if (bVar != null) {
                a("cacheResponse", bVar);
            }
            this.pqT = bVar;
            return this;
        }

        private void a(String str, b bVar) {
            if (bVar.pqR != null) {
                throw new IllegalArgumentException(str + ".body != null");
            }
            if (bVar.pqS != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            if (bVar.pqT != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            }
            if (bVar.pqU != null) {
                throw new IllegalArgumentException(str + ".priorResponse != null");
            }
        }

        public a j(b bVar) {
            if (bVar != null) {
                k(bVar);
            }
            this.pqU = bVar;
            return this;
        }

        private void k(b bVar) {
            if (bVar.pqR != null) {
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

        public b epJ() {
            if (this.pof == null) {
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
