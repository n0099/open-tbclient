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
    final e poE;

    public a(e eVar) {
        this.poE = eVar;
    }

    @Override // com.bytedance.sdk.a.b.x
    public com.bytedance.sdk.a.b.b a(x.a aVar) throws IOException {
        com.bytedance.sdk.a.b.b b2 = this.poE != null ? this.poE.b(aVar.epu()) : null;
        c epb = new c.a(System.currentTimeMillis(), aVar.epu(), b2).epb();
        ab abVar = epb.poI;
        com.bytedance.sdk.a.b.b bVar = epb.poJ;
        if (this.poE != null) {
            this.poE.a(epb);
        }
        if (b2 != null && bVar == null) {
            com.bytedance.sdk.a.b.a.c.a(b2.epN());
        }
        if (abVar == null && bVar == null) {
            return new b.a().f(aVar.epu()).a(w.HTTP_1_1).OG(504).YO("Unsatisfiable Request (only-if-cached)").a(com.bytedance.sdk.a.b.a.c.ppt).is(-1L).it(System.currentTimeMillis()).epR();
        }
        if (abVar == null) {
            return bVar.epO().i(a(bVar)).epR();
        }
        try {
            com.bytedance.sdk.a.b.b b3 = aVar.b(abVar);
            if (b3 == null && b2 != null) {
                com.bytedance.sdk.a.b.a.c.a(b2.epN());
            }
            if (bVar != null) {
                if (b3.c() == 304) {
                    com.bytedance.sdk.a.b.b epR = bVar.epO().c(a(bVar.epM(), b3.epM())).is(b3.k()).it(b3.l()).i(a(bVar)).h(a(b3)).epR();
                    b3.epN().close();
                    this.poE.a();
                    this.poE.a(bVar, epR);
                    return epR;
                }
                com.bytedance.sdk.a.b.a.c.a(bVar.epN());
            }
            com.bytedance.sdk.a.b.b epR2 = b3.epO().i(a(bVar)).h(a(b3)).epR();
            if (this.poE != null) {
                if (com.bytedance.sdk.a.b.a.c.e.e(epR2) && c.a(epR2, abVar)) {
                    return a(this.poE.b(epR2), epR2);
                }
                if (f.a(abVar.b())) {
                    try {
                        this.poE.c(abVar);
                        return epR2;
                    } catch (IOException e) {
                        return epR2;
                    }
                }
                return epR2;
            }
            return epR2;
        } catch (Throwable th) {
            if (0 == 0 && b2 != null) {
                com.bytedance.sdk.a.b.a.c.a(b2.epN());
            }
            throw th;
        }
    }

    private static com.bytedance.sdk.a.b.b a(com.bytedance.sdk.a.b.b bVar) {
        if (bVar == null || bVar.epN() == null) {
            return bVar;
        }
        return bVar.epO().a((com.bytedance.sdk.a.b.c) null).epR();
    }

    private com.bytedance.sdk.a.b.b a(final b bVar, com.bytedance.sdk.a.b.b bVar2) throws IOException {
        r epa;
        if (bVar != null && (epa = bVar.epa()) != null) {
            final com.bytedance.sdk.a.a.e epw = bVar2.epN().epw();
            final com.bytedance.sdk.a.a.d b2 = l.b(epa);
            return bVar2.epO().a(new h(bVar2.a("Content-Type"), bVar2.epN().b(), l.c(new s() { // from class: com.bytedance.sdk.a.b.a.a.a.1

                /* renamed from: a  reason: collision with root package name */
                boolean f5856a;

                @Override // com.bytedance.sdk.a.a.s
                public long b(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
                    try {
                        long b3 = epw.b(cVar, j);
                        if (b3 == -1) {
                            if (!this.f5856a) {
                                this.f5856a = true;
                                b2.close();
                            }
                            return -1L;
                        }
                        cVar.a(b2.eoz(), cVar.b() - b3, b3);
                        b2.eoI();
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
                public t eoy() {
                    return epw.eoy();
                }

                @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    if (!this.f5856a && !com.bytedance.sdk.a.b.a.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                        this.f5856a = true;
                        bVar.b();
                    }
                    epw.close();
                }
            }))).epR();
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
                com.bytedance.sdk.a.b.a.a.poD.a(aVar, a3, b2);
            }
        }
        int a4 = vVar2.a();
        for (int i2 = 0; i2 < a4; i2++) {
            String a5 = vVar2.a(i2);
            if (!"Content-Length".equalsIgnoreCase(a5) && a(a5)) {
                com.bytedance.sdk.a.b.a.a.poD.a(aVar, a5, vVar2.b(i2));
            }
        }
        return aVar.eqd();
    }

    static boolean a(String str) {
        return (HTTP.CONN_DIRECTIVE.equalsIgnoreCase(str) || HTTP.CONN_KEEP_ALIVE.equalsIgnoreCase(str) || AUTH.PROXY_AUTH.equalsIgnoreCase(str) || AUTH.PROXY_AUTH_RESP.equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }
}
