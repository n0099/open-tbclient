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
/* loaded from: classes4.dex */
public final class a implements x {
    final e pis;

    public a(e eVar) {
        this.pis = eVar;
    }

    @Override // com.bytedance.sdk.a.b.x
    public com.bytedance.sdk.a.b.b a(x.a aVar) throws IOException {
        com.bytedance.sdk.a.b.b b2 = this.pis != null ? this.pis.b(aVar.eqN()) : null;
        c equ = new c.a(System.currentTimeMillis(), aVar.eqN(), b2).equ();
        ab abVar = equ.piw;
        com.bytedance.sdk.a.b.b bVar = equ.pix;
        if (this.pis != null) {
            this.pis.a(equ);
        }
        if (b2 != null && bVar == null) {
            com.bytedance.sdk.a.b.a.c.a(b2.erg());
        }
        if (abVar == null && bVar == null) {
            return new b.a().f(aVar.eqN()).a(w.HTTP_1_1).PR(504).YJ("Unsatisfiable Request (only-if-cached)").a(com.bytedance.sdk.a.b.a.c.pjf).ip(-1L).iq(System.currentTimeMillis()).erk();
        }
        if (abVar == null) {
            return bVar.erh().i(a(bVar)).erk();
        }
        try {
            com.bytedance.sdk.a.b.b b3 = aVar.b(abVar);
            if (b3 == null && b2 != null) {
                com.bytedance.sdk.a.b.a.c.a(b2.erg());
            }
            if (bVar != null) {
                if (b3.c() == 304) {
                    com.bytedance.sdk.a.b.b erk = bVar.erh().c(a(bVar.erf(), b3.erf())).ip(b3.k()).iq(b3.l()).i(a(bVar)).h(a(b3)).erk();
                    b3.erg().close();
                    this.pis.a();
                    this.pis.a(bVar, erk);
                    return erk;
                }
                com.bytedance.sdk.a.b.a.c.a(bVar.erg());
            }
            com.bytedance.sdk.a.b.b erk2 = b3.erh().i(a(bVar)).h(a(b3)).erk();
            if (this.pis != null) {
                if (com.bytedance.sdk.a.b.a.c.e.e(erk2) && c.a(erk2, abVar)) {
                    return a(this.pis.b(erk2), erk2);
                }
                if (f.a(abVar.b())) {
                    try {
                        this.pis.c(abVar);
                        return erk2;
                    } catch (IOException e) {
                        return erk2;
                    }
                }
                return erk2;
            }
            return erk2;
        } catch (Throwable th) {
            if (0 == 0 && b2 != null) {
                com.bytedance.sdk.a.b.a.c.a(b2.erg());
            }
            throw th;
        }
    }

    private static com.bytedance.sdk.a.b.b a(com.bytedance.sdk.a.b.b bVar) {
        if (bVar == null || bVar.erg() == null) {
            return bVar;
        }
        return bVar.erh().a((com.bytedance.sdk.a.b.c) null).erk();
    }

    private com.bytedance.sdk.a.b.b a(final b bVar, com.bytedance.sdk.a.b.b bVar2) throws IOException {
        r eqt;
        if (bVar != null && (eqt = bVar.eqt()) != null) {
            final com.bytedance.sdk.a.a.e eqP = bVar2.erg().eqP();
            final com.bytedance.sdk.a.a.d b2 = l.b(eqt);
            return bVar2.erh().a(new h(bVar2.a("Content-Type"), bVar2.erg().b(), l.c(new s() { // from class: com.bytedance.sdk.a.b.a.a.a.1

                /* renamed from: a  reason: collision with root package name */
                boolean f6153a;

                @Override // com.bytedance.sdk.a.a.s
                public long b(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
                    try {
                        long b3 = eqP.b(cVar, j);
                        if (b3 == -1) {
                            if (!this.f6153a) {
                                this.f6153a = true;
                                b2.close();
                            }
                            return -1L;
                        }
                        cVar.a(b2.epS(), cVar.b() - b3, b3);
                        b2.eqb();
                        return b3;
                    } catch (IOException e) {
                        if (!this.f6153a) {
                            this.f6153a = true;
                            bVar.b();
                        }
                        throw e;
                    }
                }

                @Override // com.bytedance.sdk.a.a.s
                public t epR() {
                    return eqP.epR();
                }

                @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    if (!this.f6153a && !com.bytedance.sdk.a.b.a.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                        this.f6153a = true;
                        bVar.b();
                    }
                    eqP.close();
                }
            }))).erk();
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
                com.bytedance.sdk.a.b.a.a.pir.a(aVar, a3, b2);
            }
        }
        int a4 = vVar2.a();
        for (int i2 = 0; i2 < a4; i2++) {
            String a5 = vVar2.a(i2);
            if (!"Content-Length".equalsIgnoreCase(a5) && a(a5)) {
                com.bytedance.sdk.a.b.a.a.pir.a(aVar, a5, vVar2.b(i2));
            }
        }
        return aVar.erx();
    }

    static boolean a(String str) {
        return (HTTP.CONN_DIRECTIVE.equalsIgnoreCase(str) || HTTP.CONN_KEEP_ALIVE.equalsIgnoreCase(str) || AUTH.PROXY_AUTH.equalsIgnoreCase(str) || AUTH.PROXY_AUTH_RESP.equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }
}
