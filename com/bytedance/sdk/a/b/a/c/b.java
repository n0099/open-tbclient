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
    private final boolean f6173a;

    public b(boolean z) {
        this.f6173a = z;
    }

    @Override // com.bytedance.sdk.a.b.x
    public com.bytedance.sdk.a.b.b a(x.a aVar) throws IOException {
        b.a aVar2;
        com.bytedance.sdk.a.b.b erk;
        g gVar = (g) aVar;
        c eqK = gVar.eqK();
        com.bytedance.sdk.a.b.a.b.g eqJ = gVar.eqJ();
        com.bytedance.sdk.a.b.a.b.c cVar = (com.bytedance.sdk.a.b.a.b.c) gVar.eqI();
        ab eqN = gVar.eqN();
        long currentTimeMillis = System.currentTimeMillis();
        gVar.eqM().c(gVar.eqL());
        eqK.d(eqN);
        gVar.eqM().a(gVar.eqL(), eqN);
        b.a aVar3 = null;
        if (!f.c(eqN.b()) || eqN.erW() == null) {
            aVar2 = null;
        } else {
            if (HTTP.EXPECT_CONTINUE.equalsIgnoreCase(eqN.a(HTTP.EXPECT_DIRECTIVE))) {
                eqK.a();
                gVar.eqM().e(gVar.eqL());
                aVar3 = eqK.AL(true);
            }
            if (aVar3 == null) {
                gVar.eqM().d(gVar.eqL());
                a aVar4 = new a(eqK.a(eqN, eqN.erW().b()));
                com.bytedance.sdk.a.a.d b2 = com.bytedance.sdk.a.a.l.b(aVar4);
                eqN.erW().a(b2);
                b2.close();
                gVar.eqM().a(gVar.eqL(), aVar4.f6174a);
                aVar2 = aVar3;
            } else {
                if (!cVar.d()) {
                    eqJ.d();
                }
                aVar2 = aVar3;
            }
        }
        eqK.b();
        if (aVar2 == null) {
            gVar.eqM().e(gVar.eqL());
            aVar2 = eqK.AL(false);
        }
        com.bytedance.sdk.a.b.b erk2 = aVar2.f(eqN).a(eqJ.eqG().eqz()).ip(currentTimeMillis).iq(System.currentTimeMillis()).erk();
        gVar.eqM().a(gVar.eqL(), erk2);
        int c = erk2.c();
        if (this.f6173a && c == 101) {
            erk = erk2.erh().a(com.bytedance.sdk.a.b.a.c.pjf).erk();
        } else {
            erk = erk2.erh().a(eqK.c(erk2)).erk();
        }
        if ("close".equalsIgnoreCase(erk.eqN().a(HTTP.CONN_DIRECTIVE)) || "close".equalsIgnoreCase(erk.a(HTTP.CONN_DIRECTIVE))) {
            eqJ.d();
        }
        if ((c == 204 || c == 205) && erk.erg().b() > 0) {
            throw new ProtocolException("HTTP " + c + " had non-zero Content-Length: " + erk.erg().b());
        }
        return erk;
    }

    /* loaded from: classes4.dex */
    static final class a extends com.bytedance.sdk.a.a.g {

        /* renamed from: a  reason: collision with root package name */
        long f6174a;

        a(r rVar) {
            super(rVar);
        }

        @Override // com.bytedance.sdk.a.a.g, com.bytedance.sdk.a.a.r
        public void a(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
            super.a(cVar, j);
            this.f6174a += j;
        }
    }
}
