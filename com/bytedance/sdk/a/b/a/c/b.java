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
    private final boolean f5874a;

    public b(boolean z) {
        this.f5874a = z;
    }

    @Override // com.bytedance.sdk.a.b.x
    public com.bytedance.sdk.a.b.b a(x.a aVar) throws IOException {
        b.a aVar2;
        com.bytedance.sdk.a.b.b enq;
        g gVar = (g) aVar;
        c emP = gVar.emP();
        com.bytedance.sdk.a.b.a.b.g emO = gVar.emO();
        com.bytedance.sdk.a.b.a.b.c cVar = (com.bytedance.sdk.a.b.a.b.c) gVar.emN();
        ab emS = gVar.emS();
        long currentTimeMillis = System.currentTimeMillis();
        gVar.emR().c(gVar.emQ());
        emP.d(emS);
        gVar.emR().a(gVar.emQ(), emS);
        b.a aVar3 = null;
        if (!f.c(emS.b()) || emS.eoc() == null) {
            aVar2 = null;
        } else {
            if (HTTP.EXPECT_CONTINUE.equalsIgnoreCase(emS.a(HTTP.EXPECT_DIRECTIVE))) {
                emP.a();
                gVar.emR().e(gVar.emQ());
                aVar3 = emP.AH(true);
            }
            if (aVar3 == null) {
                gVar.emR().d(gVar.emQ());
                a aVar4 = new a(emP.a(emS, emS.eoc().b()));
                com.bytedance.sdk.a.a.d b2 = com.bytedance.sdk.a.a.l.b(aVar4);
                emS.eoc().a(b2);
                b2.close();
                gVar.emR().a(gVar.emQ(), aVar4.f5875a);
                aVar2 = aVar3;
            } else {
                if (!cVar.d()) {
                    emO.d();
                }
                aVar2 = aVar3;
            }
        }
        emP.b();
        if (aVar2 == null) {
            gVar.emR().e(gVar.emQ());
            aVar2 = emP.AH(false);
        }
        com.bytedance.sdk.a.b.b enq2 = aVar2.f(emS).a(emO.emL().emE()).ip(currentTimeMillis).iq(System.currentTimeMillis()).enq();
        gVar.emR().a(gVar.emQ(), enq2);
        int c = enq2.c();
        if (this.f5874a && c == 101) {
            enq = enq2.enn().a(com.bytedance.sdk.a.b.a.c.peA).enq();
        } else {
            enq = enq2.enn().a(emP.c(enq2)).enq();
        }
        if ("close".equalsIgnoreCase(enq.emS().a(HTTP.CONN_DIRECTIVE)) || "close".equalsIgnoreCase(enq.a(HTTP.CONN_DIRECTIVE))) {
            emO.d();
        }
        if ((c == 204 || c == 205) && enq.enm().b() > 0) {
            throw new ProtocolException("HTTP " + c + " had non-zero Content-Length: " + enq.enm().b());
        }
        return enq;
    }

    /* loaded from: classes4.dex */
    static final class a extends com.bytedance.sdk.a.a.g {

        /* renamed from: a  reason: collision with root package name */
        long f5875a;

        a(r rVar) {
            super(rVar);
        }

        @Override // com.bytedance.sdk.a.a.g, com.bytedance.sdk.a.a.r
        public void a(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
            super.a(cVar, j);
            this.f5875a += j;
        }
    }
}
