package com.bytedance.sdk.a.b.a.a;

import com.bytedance.sdk.a.a.l;
import com.bytedance.sdk.a.a.r;
import com.bytedance.sdk.a.a.s;
import com.bytedance.sdk.a.a.t;
import com.bytedance.sdk.a.b.a.a.c;
import com.bytedance.sdk.a.b.a.c.f;
import com.bytedance.sdk.a.b.a.c.h;
import com.bytedance.sdk.a.b.ab;
import com.bytedance.sdk.a.b.b;
import com.bytedance.sdk.a.b.v;
import com.bytedance.sdk.a.b.w;
import com.bytedance.sdk.a.b.x;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.http.auth.AUTH;
import org.apache.http.protocol.HTTP;
/* loaded from: classes6.dex */
public final class a implements x {
    final e pqL;

    public a(e eVar) {
        this.pqL = eVar;
    }

    @Override // com.bytedance.sdk.a.b.x
    public com.bytedance.sdk.a.b.b a(x.a aVar) throws IOException {
        com.bytedance.sdk.a.b.b b = this.pqL != null ? this.pqL.b(aVar.epB()) : null;
        c epi = new c.a(System.currentTimeMillis(), aVar.epB(), b).epi();
        ab abVar = epi.pqP;
        com.bytedance.sdk.a.b.b bVar = epi.pqQ;
        if (this.pqL != null) {
            this.pqL.a(epi);
        }
        if (b != null && bVar == null) {
            com.bytedance.sdk.a.b.a.c.a(b.epU());
        }
        if (abVar == null && bVar == null) {
            return new b.a().f(aVar.epB()).a(w.HTTP_1_1).OK(504).YV("Unsatisfiable Request (only-if-cached)").a(com.bytedance.sdk.a.b.a.c.pry).is(-1L).it(System.currentTimeMillis()).epY();
        }
        if (abVar == null) {
            return bVar.epV().i(a(bVar)).epY();
        }
        try {
            com.bytedance.sdk.a.b.b b2 = aVar.b(abVar);
            if (b2 == null && b != null) {
                com.bytedance.sdk.a.b.a.c.a(b.epU());
            }
            if (bVar != null) {
                if (b2.c() == 304) {
                    com.bytedance.sdk.a.b.b epY = bVar.epV().c(a(bVar.epT(), b2.epT())).is(b2.l()).it(b2.m()).i(a(bVar)).h(a(b2)).epY();
                    b2.epU().close();
                    this.pqL.a();
                    this.pqL.a(bVar, epY);
                    return epY;
                }
                com.bytedance.sdk.a.b.a.c.a(bVar.epU());
            }
            com.bytedance.sdk.a.b.b epY2 = b2.epV().i(a(bVar)).h(a(b2)).epY();
            if (this.pqL != null) {
                if (com.bytedance.sdk.a.b.a.c.e.e(epY2) && c.a(epY2, abVar)) {
                    return a(this.pqL.b(epY2), epY2);
                }
                if (f.a(abVar.b())) {
                    try {
                        this.pqL.c(abVar);
                        return epY2;
                    } catch (IOException e) {
                        return epY2;
                    }
                }
                return epY2;
            }
            return epY2;
        } catch (Throwable th) {
            if (0 == 0 && b != null) {
                com.bytedance.sdk.a.b.a.c.a(b.epU());
            }
            throw th;
        }
    }

    private static com.bytedance.sdk.a.b.b a(com.bytedance.sdk.a.b.b bVar) {
        if (bVar == null || bVar.epU() == null) {
            return bVar;
        }
        return bVar.epV().a((com.bytedance.sdk.a.b.c) null).epY();
    }

    private com.bytedance.sdk.a.b.b a(final b bVar, com.bytedance.sdk.a.b.b bVar2) throws IOException {
        r eph;
        if (bVar != null && (eph = bVar.eph()) != null) {
            final com.bytedance.sdk.a.a.e epD = bVar2.epU().epD();
            final com.bytedance.sdk.a.a.d b = l.b(eph);
            return bVar2.epV().a(new h(bVar2.a("Content-Type"), bVar2.epU().b(), l.c(new s() { // from class: com.bytedance.sdk.a.b.a.a.a.1

                /* renamed from: a  reason: collision with root package name */
                boolean f3945a;

                @Override // com.bytedance.sdk.a.a.s
                public long b(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
                    try {
                        long b2 = epD.b(cVar, j);
                        if (b2 == -1) {
                            if (!this.f3945a) {
                                this.f3945a = true;
                                b.close();
                            }
                            return -1L;
                        }
                        cVar.a(b.eoG(), cVar.b() - b2, b2);
                        b.eoP();
                        return b2;
                    } catch (IOException e) {
                        if (!this.f3945a) {
                            this.f3945a = true;
                            bVar.b();
                        }
                        throw e;
                    }
                }

                @Override // com.bytedance.sdk.a.a.s
                public t eoF() {
                    return epD.eoF();
                }

                @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    if (!this.f3945a && !com.bytedance.sdk.a.b.a.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                        this.f3945a = true;
                        bVar.b();
                    }
                    epD.close();
                }
            }))).epY();
        }
        return bVar2;
    }

    private static v a(v vVar, v vVar2) {
        v.a aVar = new v.a();
        int a2 = vVar.a();
        for (int i = 0; i < a2; i++) {
            String a3 = vVar.a(i);
            String b = vVar.b(i);
            if ((!"Warning".equalsIgnoreCase(a3) || !b.startsWith("1")) && (!a(a3) || vVar2.a(a3) == null)) {
                com.bytedance.sdk.a.b.a.a.pqK.a(aVar, a3, b);
            }
        }
        int a4 = vVar2.a();
        for (int i2 = 0; i2 < a4; i2++) {
            String a5 = vVar2.a(i2);
            if (!"Content-Length".equalsIgnoreCase(a5) && a(a5)) {
                com.bytedance.sdk.a.b.a.a.pqK.a(aVar, a5, vVar2.b(i2));
            }
        }
        return aVar.eqk();
    }

    static boolean a(String str) {
        return (HTTP.CONN_DIRECTIVE.equalsIgnoreCase(str) || HTTP.CONN_KEEP_ALIVE.equalsIgnoreCase(str) || AUTH.PROXY_AUTH.equalsIgnoreCase(str) || AUTH.PROXY_AUTH_RESP.equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }
}
