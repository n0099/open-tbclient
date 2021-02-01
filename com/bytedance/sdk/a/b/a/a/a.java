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
    final e pob;

    public a(e eVar) {
        this.pob = eVar;
    }

    @Override // com.bytedance.sdk.a.b.x
    public com.bytedance.sdk.a.b.b a(x.a aVar) throws IOException {
        com.bytedance.sdk.a.b.b b2 = this.pob != null ? this.pob.b(aVar.epm()) : null;
        c eoT = new c.a(System.currentTimeMillis(), aVar.epm(), b2).eoT();
        ab abVar = eoT.pof;
        com.bytedance.sdk.a.b.b bVar = eoT.pog;
        if (this.pob != null) {
            this.pob.a(eoT);
        }
        if (b2 != null && bVar == null) {
            com.bytedance.sdk.a.b.a.c.a(b2.epF());
        }
        if (abVar == null && bVar == null) {
            return new b.a().f(aVar.epm()).a(w.HTTP_1_1).OF(504).YC("Unsatisfiable Request (only-if-cached)").a(com.bytedance.sdk.a.b.a.c.poR).is(-1L).it(System.currentTimeMillis()).epJ();
        }
        if (abVar == null) {
            return bVar.epG().i(a(bVar)).epJ();
        }
        try {
            com.bytedance.sdk.a.b.b b3 = aVar.b(abVar);
            if (b3 == null && b2 != null) {
                com.bytedance.sdk.a.b.a.c.a(b2.epF());
            }
            if (bVar != null) {
                if (b3.c() == 304) {
                    com.bytedance.sdk.a.b.b epJ = bVar.epG().c(a(bVar.epE(), b3.epE())).is(b3.k()).it(b3.l()).i(a(bVar)).h(a(b3)).epJ();
                    b3.epF().close();
                    this.pob.a();
                    this.pob.a(bVar, epJ);
                    return epJ;
                }
                com.bytedance.sdk.a.b.a.c.a(bVar.epF());
            }
            com.bytedance.sdk.a.b.b epJ2 = b3.epG().i(a(bVar)).h(a(b3)).epJ();
            if (this.pob != null) {
                if (com.bytedance.sdk.a.b.a.c.e.e(epJ2) && c.a(epJ2, abVar)) {
                    return a(this.pob.b(epJ2), epJ2);
                }
                if (f.a(abVar.b())) {
                    try {
                        this.pob.c(abVar);
                        return epJ2;
                    } catch (IOException e) {
                        return epJ2;
                    }
                }
                return epJ2;
            }
            return epJ2;
        } catch (Throwable th) {
            if (0 == 0 && b2 != null) {
                com.bytedance.sdk.a.b.a.c.a(b2.epF());
            }
            throw th;
        }
    }

    private static com.bytedance.sdk.a.b.b a(com.bytedance.sdk.a.b.b bVar) {
        if (bVar == null || bVar.epF() == null) {
            return bVar;
        }
        return bVar.epG().a((com.bytedance.sdk.a.b.c) null).epJ();
    }

    private com.bytedance.sdk.a.b.b a(final b bVar, com.bytedance.sdk.a.b.b bVar2) throws IOException {
        r eoS;
        if (bVar != null && (eoS = bVar.eoS()) != null) {
            final com.bytedance.sdk.a.a.e epo = bVar2.epF().epo();
            final com.bytedance.sdk.a.a.d b2 = l.b(eoS);
            return bVar2.epG().a(new h(bVar2.a("Content-Type"), bVar2.epF().b(), l.c(new s() { // from class: com.bytedance.sdk.a.b.a.a.a.1

                /* renamed from: a  reason: collision with root package name */
                boolean f5856a;

                @Override // com.bytedance.sdk.a.a.s
                public long b(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
                    try {
                        long b3 = epo.b(cVar, j);
                        if (b3 == -1) {
                            if (!this.f5856a) {
                                this.f5856a = true;
                                b2.close();
                            }
                            return -1L;
                        }
                        cVar.a(b2.eor(), cVar.b() - b3, b3);
                        b2.eoA();
                        return b3;
                    } catch (IOException e) {
                        if (!this.f5856a) {
                            this.f5856a = true;
                            bVar.b();
                        }
                        throw e;
                    }
                }

                @Override // com.bytedance.sdk.a.a.s
                public t eoq() {
                    return epo.eoq();
                }

                @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    if (!this.f5856a && !com.bytedance.sdk.a.b.a.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                        this.f5856a = true;
                        bVar.b();
                    }
                    epo.close();
                }
            }))).epJ();
        }
        return bVar2;
    }

    private static v a(v vVar, v vVar2) {
        v.a aVar = new v.a();
        int a2 = vVar.a();
        for (int i = 0; i < a2; i++) {
            String a3 = vVar.a(i);
            String b2 = vVar.b(i);
            if ((!"Warning".equalsIgnoreCase(a3) || !b2.startsWith("1")) && (!a(a3) || vVar2.a(a3) == null)) {
                com.bytedance.sdk.a.b.a.a.poa.a(aVar, a3, b2);
            }
        }
        int a4 = vVar2.a();
        for (int i2 = 0; i2 < a4; i2++) {
            String a5 = vVar2.a(i2);
            if (!"Content-Length".equalsIgnoreCase(a5) && a(a5)) {
                com.bytedance.sdk.a.b.a.a.poa.a(aVar, a5, vVar2.b(i2));
            }
        }
        return aVar.epV();
    }

    static boolean a(String str) {
        return (HTTP.CONN_DIRECTIVE.equalsIgnoreCase(str) || HTTP.CONN_KEEP_ALIVE.equalsIgnoreCase(str) || AUTH.PROXY_AUTH.equalsIgnoreCase(str) || AUTH.PROXY_AUTH_RESP.equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }
}
