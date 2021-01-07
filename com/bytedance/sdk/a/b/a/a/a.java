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
        com.bytedance.sdk.a.b.b b2 = this.pis != null ? this.pis.b(aVar.eqO()) : null;
        c eqv = new c.a(System.currentTimeMillis(), aVar.eqO(), b2).eqv();
        ab abVar = eqv.piw;
        com.bytedance.sdk.a.b.b bVar = eqv.pix;
        if (this.pis != null) {
            this.pis.a(eqv);
        }
        if (b2 != null && bVar == null) {
            com.bytedance.sdk.a.b.a.c.a(b2.erh());
        }
        if (abVar == null && bVar == null) {
            return new b.a().f(aVar.eqO()).a(w.HTTP_1_1).PR(504).YI("Unsatisfiable Request (only-if-cached)").a(com.bytedance.sdk.a.b.a.c.pjf).ip(-1L).iq(System.currentTimeMillis()).erl();
        }
        if (abVar == null) {
            return bVar.eri().i(a(bVar)).erl();
        }
        try {
            com.bytedance.sdk.a.b.b b3 = aVar.b(abVar);
            if (b3 == null && b2 != null) {
                com.bytedance.sdk.a.b.a.c.a(b2.erh());
            }
            if (bVar != null) {
                if (b3.c() == 304) {
                    com.bytedance.sdk.a.b.b erl = bVar.eri().c(a(bVar.erg(), b3.erg())).ip(b3.k()).iq(b3.l()).i(a(bVar)).h(a(b3)).erl();
                    b3.erh().close();
                    this.pis.a();
                    this.pis.a(bVar, erl);
                    return erl;
                }
                com.bytedance.sdk.a.b.a.c.a(bVar.erh());
            }
            com.bytedance.sdk.a.b.b erl2 = b3.eri().i(a(bVar)).h(a(b3)).erl();
            if (this.pis != null) {
                if (com.bytedance.sdk.a.b.a.c.e.e(erl2) && c.a(erl2, abVar)) {
                    return a(this.pis.b(erl2), erl2);
                }
                if (f.a(abVar.b())) {
                    try {
                        this.pis.c(abVar);
                        return erl2;
                    } catch (IOException e) {
                        return erl2;
                    }
                }
                return erl2;
            }
            return erl2;
        } catch (Throwable th) {
            if (0 == 0 && b2 != null) {
                com.bytedance.sdk.a.b.a.c.a(b2.erh());
            }
            throw th;
        }
    }

    private static com.bytedance.sdk.a.b.b a(com.bytedance.sdk.a.b.b bVar) {
        if (bVar == null || bVar.erh() == null) {
            return bVar;
        }
        return bVar.eri().a((com.bytedance.sdk.a.b.c) null).erl();
    }

    private com.bytedance.sdk.a.b.b a(final b bVar, com.bytedance.sdk.a.b.b bVar2) throws IOException {
        r equ;
        if (bVar != null && (equ = bVar.equ()) != null) {
            final com.bytedance.sdk.a.a.e eqQ = bVar2.erh().eqQ();
            final com.bytedance.sdk.a.a.d b2 = l.b(equ);
            return bVar2.eri().a(new h(bVar2.a("Content-Type"), bVar2.erh().b(), l.c(new s() { // from class: com.bytedance.sdk.a.b.a.a.a.1

                /* renamed from: a  reason: collision with root package name */
                boolean f6154a;

                @Override // com.bytedance.sdk.a.a.s
                public long b(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
                    try {
                        long b3 = eqQ.b(cVar, j);
                        if (b3 == -1) {
                            if (!this.f6154a) {
                                this.f6154a = true;
                                b2.close();
                            }
                            return -1L;
                        }
                        cVar.a(b2.epT(), cVar.b() - b3, b3);
                        b2.eqc();
                        return b3;
                    } catch (IOException e) {
                        if (!this.f6154a) {
                            this.f6154a = true;
                            bVar.b();
                        }
                        throw e;
                    }
                }

                @Override // com.bytedance.sdk.a.a.s
                public t epS() {
                    return eqQ.epS();
                }

                @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    if (!this.f6154a && !com.bytedance.sdk.a.b.a.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                        this.f6154a = true;
                        bVar.b();
                    }
                    eqQ.close();
                }
            }))).erl();
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
        return aVar.ery();
    }

    static boolean a(String str) {
        return (HTTP.CONN_DIRECTIVE.equalsIgnoreCase(str) || HTTP.CONN_KEEP_ALIVE.equalsIgnoreCase(str) || AUTH.PROXY_AUTH.equalsIgnoreCase(str) || AUTH.PROXY_AUTH_RESP.equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }
}
