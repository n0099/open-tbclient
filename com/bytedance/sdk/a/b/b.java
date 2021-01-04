package com.bytedance.sdk.a.b;

import com.bytedance.sdk.a.b.v;
import java.io.Closeable;
/* loaded from: classes4.dex */
public final class b implements Closeable {

    /* renamed from: b  reason: collision with root package name */
    final w f6252b;
    final int c;
    final String d;
    final long k;
    final long l;
    final ab piw;
    final u plc;
    final v pld;
    final c ple;
    final b plf;
    final b plg;
    final b plh;
    private volatile g pli;

    b(a aVar) {
        this.piw = aVar.piw;
        this.f6252b = aVar.f6253b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.plc = aVar.plc;
        this.pld = aVar.plj.erx();
        this.ple = aVar.ple;
        this.plf = aVar.plf;
        this.plg = aVar.plg;
        this.plh = aVar.plh;
        this.k = aVar.k;
        this.l = aVar.l;
    }

    public ab eqN() {
        return this.piw;
    }

    public w erd() {
        return this.f6252b;
    }

    public int c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public u ere() {
        return this.plc;
    }

    public String a(String str) {
        return a(str, null);
    }

    public String a(String str, String str2) {
        String a2 = this.pld.a(str);
        return a2 != null ? a2 : str2;
    }

    public v erf() {
        return this.pld;
    }

    public c erg() {
        return this.ple;
    }

    public a erh() {
        return new a(this);
    }

    public b eri() {
        return this.plh;
    }

    public g erj() {
        g gVar = this.pli;
        if (gVar != null) {
            return gVar;
        }
        g d = g.d(this.pld);
        this.pli = d;
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
        if (this.ple == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        this.ple.close();
    }

    public String toString() {
        return "Response{protocol=" + this.f6252b + ", code=" + this.c + ", message=" + this.d + ", url=" + this.piw.eqk() + '}';
    }

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: b  reason: collision with root package name */
        w f6253b;
        int c;
        String d;
        long k;
        long l;
        ab piw;
        u plc;
        c ple;
        b plf;
        b plg;
        b plh;
        v.a plj;

        public a() {
            this.c = -1;
            this.plj = new v.a();
        }

        a(b bVar) {
            this.c = -1;
            this.piw = bVar.piw;
            this.f6253b = bVar.f6252b;
            this.c = bVar.c;
            this.d = bVar.d;
            this.plc = bVar.plc;
            this.plj = bVar.pld.erw();
            this.ple = bVar.ple;
            this.plf = bVar.plf;
            this.plg = bVar.plg;
            this.plh = bVar.plh;
            this.k = bVar.k;
            this.l = bVar.l;
        }

        public a f(ab abVar) {
            this.piw = abVar;
            return this;
        }

        public a a(w wVar) {
            this.f6253b = wVar;
            return this;
        }

        public a PR(int i) {
            this.c = i;
            return this;
        }

        public a YJ(String str) {
            this.d = str;
            return this;
        }

        public a a(u uVar) {
            this.plc = uVar;
            return this;
        }

        public a hc(String str, String str2) {
            this.plj.hd(str, str2);
            return this;
        }

        public a c(v vVar) {
            this.plj = vVar.erw();
            return this;
        }

        public a a(c cVar) {
            this.ple = cVar;
            return this;
        }

        public a h(b bVar) {
            if (bVar != null) {
                a("networkResponse", bVar);
            }
            this.plf = bVar;
            return this;
        }

        public a i(b bVar) {
            if (bVar != null) {
                a("cacheResponse", bVar);
            }
            this.plg = bVar;
            return this;
        }

        private void a(String str, b bVar) {
            if (bVar.ple != null) {
                throw new IllegalArgumentException(str + ".body != null");
            }
            if (bVar.plf != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            if (bVar.plg != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            }
            if (bVar.plh != null) {
                throw new IllegalArgumentException(str + ".priorResponse != null");
            }
        }

        public a j(b bVar) {
            if (bVar != null) {
                k(bVar);
            }
            this.plh = bVar;
            return this;
        }

        private void k(b bVar) {
            if (bVar.ple != null) {
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

        public b erk() {
            if (this.piw == null) {
                throw new IllegalStateException("request == null");
            }
            if (this.f6253b == null) {
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
