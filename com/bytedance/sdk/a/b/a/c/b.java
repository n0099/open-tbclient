package com.bytedance.sdk.a.b.a.c;

import com.bytedance.sdk.a.a.r;
import com.bytedance.sdk.a.b.ab;
import com.bytedance.sdk.a.b.b;
import com.bytedance.sdk.a.b.x;
import java.io.IOException;
import java.net.ProtocolException;
import org.apache.http.protocol.HTTP;
/* loaded from: classes4.dex */
public final class b implements x {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f6174a;

    public b(boolean z) {
        this.f6174a = z;
    }

    @Override // com.bytedance.sdk.a.b.x
    public com.bytedance.sdk.a.b.b a(x.a aVar) throws IOException {
        b.a aVar2;
        com.bytedance.sdk.a.b.b erl;
        g gVar = (g) aVar;
        c eqL = gVar.eqL();
        com.bytedance.sdk.a.b.a.b.g eqK = gVar.eqK();
        com.bytedance.sdk.a.b.a.b.c cVar = (com.bytedance.sdk.a.b.a.b.c) gVar.eqJ();
        ab eqO = gVar.eqO();
        long currentTimeMillis = System.currentTimeMillis();
        gVar.eqN().c(gVar.eqM());
        eqL.d(eqO);
        gVar.eqN().a(gVar.eqM(), eqO);
        b.a aVar3 = null;
        if (!f.c(eqO.b()) || eqO.erX() == null) {
            aVar2 = null;
        } else {
            if (HTTP.EXPECT_CONTINUE.equalsIgnoreCase(eqO.a(HTTP.EXPECT_DIRECTIVE))) {
                eqL.a();
                gVar.eqN().e(gVar.eqM());
                aVar3 = eqL.AL(true);
            }
            if (aVar3 == null) {
                gVar.eqN().d(gVar.eqM());
                a aVar4 = new a(eqL.a(eqO, eqO.erX().b()));
                com.bytedance.sdk.a.a.d b2 = com.bytedance.sdk.a.a.l.b(aVar4);
                eqO.erX().a(b2);
                b2.close();
                gVar.eqN().a(gVar.eqM(), aVar4.f6175a);
                aVar2 = aVar3;
            } else {
                if (!cVar.d()) {
                    eqK.d();
                }
                aVar2 = aVar3;
            }
        }
        eqL.b();
        if (aVar2 == null) {
            gVar.eqN().e(gVar.eqM());
            aVar2 = eqL.AL(false);
        }
        com.bytedance.sdk.a.b.b erl2 = aVar2.f(eqO).a(eqK.eqH().eqA()).ip(currentTimeMillis).iq(System.currentTimeMillis()).erl();
        gVar.eqN().a(gVar.eqM(), erl2);
        int c = erl2.c();
        if (this.f6174a && c == 101) {
            erl = erl2.eri().a(com.bytedance.sdk.a.b.a.c.pjf).erl();
        } else {
            erl = erl2.eri().a(eqL.c(erl2)).erl();
        }
        if ("close".equalsIgnoreCase(erl.eqO().a(HTTP.CONN_DIRECTIVE)) || "close".equalsIgnoreCase(erl.a(HTTP.CONN_DIRECTIVE))) {
            eqK.d();
        }
        if ((c == 204 || c == 205) && erl.erh().b() > 0) {
            throw new ProtocolException("HTTP " + c + " had non-zero Content-Length: " + erl.erh().b());
        }
        return erl;
    }

    /* loaded from: classes4.dex */
    static final class a extends com.bytedance.sdk.a.a.g {

        /* renamed from: a  reason: collision with root package name */
        long f6175a;

        a(r rVar) {
            super(rVar);
        }

        @Override // com.bytedance.sdk.a.a.g, com.bytedance.sdk.a.a.r
        public void a(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
            super.a(cVar, j);
            this.f6175a += j;
        }
    }
}
