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
    final e pdO;

    public a(e eVar) {
        this.pdO = eVar;
    }

    @Override // com.bytedance.sdk.a.b.x
    public com.bytedance.sdk.a.b.b a(x.a aVar) throws IOException {
        com.bytedance.sdk.a.b.b b2 = this.pdO != null ? this.pdO.b(aVar.emS()) : null;
        c emz = new c.a(System.currentTimeMillis(), aVar.emS(), b2).emz();
        ab abVar = emz.pdS;
        com.bytedance.sdk.a.b.b bVar = emz.pdT;
        if (this.pdO != null) {
            this.pdO.a(emz);
        }
        if (b2 != null && bVar == null) {
            com.bytedance.sdk.a.b.a.c.a(b2.enm());
        }
        if (abVar == null && bVar == null) {
            return new b.a().f(aVar.emS()).a(w.HTTP_1_1).Ok(504).XB("Unsatisfiable Request (only-if-cached)").a(com.bytedance.sdk.a.b.a.c.peB).ip(-1L).iq(System.currentTimeMillis()).enq();
        }
        if (abVar == null) {
            return bVar.enn().i(a(bVar)).enq();
        }
        try {
            com.bytedance.sdk.a.b.b b3 = aVar.b(abVar);
            if (b3 == null && b2 != null) {
                com.bytedance.sdk.a.b.a.c.a(b2.enm());
            }
            if (bVar != null) {
                if (b3.c() == 304) {
                    com.bytedance.sdk.a.b.b enq = bVar.enn().c(a(bVar.enl(), b3.enl())).ip(b3.k()).iq(b3.l()).i(a(bVar)).h(a(b3)).enq();
                    b3.enm().close();
                    this.pdO.a();
                    this.pdO.a(bVar, enq);
                    return enq;
                }
                com.bytedance.sdk.a.b.a.c.a(bVar.enm());
            }
            com.bytedance.sdk.a.b.b enq2 = b3.enn().i(a(bVar)).h(a(b3)).enq();
            if (this.pdO != null) {
                if (com.bytedance.sdk.a.b.a.c.e.e(enq2) && c.a(enq2, abVar)) {
                    return a(this.pdO.b(enq2), enq2);
                }
                if (f.a(abVar.b())) {
                    try {
                        this.pdO.c(abVar);
                        return enq2;
                    } catch (IOException e) {
                        return enq2;
                    }
                }
                return enq2;
            }
            return enq2;
        } catch (Throwable th) {
            if (0 == 0 && b2 != null) {
                com.bytedance.sdk.a.b.a.c.a(b2.enm());
            }
            throw th;
        }
    }

    private static com.bytedance.sdk.a.b.b a(com.bytedance.sdk.a.b.b bVar) {
        if (bVar == null || bVar.enm() == null) {
            return bVar;
        }
        return bVar.enn().a((com.bytedance.sdk.a.b.c) null).enq();
    }

    private com.bytedance.sdk.a.b.b a(final b bVar, com.bytedance.sdk.a.b.b bVar2) throws IOException {
        r emy;
        if (bVar != null && (emy = bVar.emy()) != null) {
            final com.bytedance.sdk.a.a.e emU = bVar2.enm().emU();
            final com.bytedance.sdk.a.a.d b2 = l.b(emy);
            return bVar2.enn().a(new h(bVar2.a("Content-Type"), bVar2.enm().b(), l.c(new s() { // from class: com.bytedance.sdk.a.b.a.a.a.1

                /* renamed from: a  reason: collision with root package name */
                boolean f5854a;

                @Override // com.bytedance.sdk.a.a.s
                public long b(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
                    try {
                        long b3 = emU.b(cVar, j);
                        if (b3 == -1) {
                            if (!this.f5854a) {
                                this.f5854a = true;
                                b2.close();
                            }
                            return -1L;
                        }
                        cVar.a(b2.elX(), cVar.b() - b3, b3);
                        b2.emg();
                        return b3;
                    } catch (IOException e) {
                        if (!this.f5854a) {
                            this.f5854a = true;
                            bVar.b();
                        }
                        throw e;
                    }
                }

                @Override // com.bytedance.sdk.a.a.s
                public t elW() {
                    return emU.elW();
                }

                @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    if (!this.f5854a && !com.bytedance.sdk.a.b.a.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                        this.f5854a = true;
                        bVar.b();
                    }
                    emU.close();
                }
            }))).enq();
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
                com.bytedance.sdk.a.b.a.a.pdN.a(aVar, a3, b2);
            }
        }
        int a4 = vVar2.a();
        for (int i2 = 0; i2 < a4; i2++) {
            String a5 = vVar2.a(i2);
            if (!"Content-Length".equalsIgnoreCase(a5) && a(a5)) {
                com.bytedance.sdk.a.b.a.a.pdN.a(aVar, a5, vVar2.b(i2));
            }
        }
        return aVar.enC();
    }

    static boolean a(String str) {
        return (HTTP.CONN_DIRECTIVE.equalsIgnoreCase(str) || HTTP.CONN_KEEP_ALIVE.equalsIgnoreCase(str) || AUTH.PROXY_AUTH.equalsIgnoreCase(str) || AUTH.PROXY_AUTH_RESP.equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }
}
