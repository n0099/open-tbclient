package com.bytedance.sdk.a.b.a.c;

import com.bytedance.sdk.a.a.r;
import com.bytedance.sdk.a.b.ab;
import com.bytedance.sdk.a.b.b;
import com.bytedance.sdk.a.b.x;
import java.io.IOException;
import java.net.ProtocolException;
import org.apache.http.protocol.HTTP;
/* loaded from: classes6.dex */
public final class b implements x {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f5876a;

    public b(boolean z) {
        this.f5876a = z;
    }

    @Override // com.bytedance.sdk.a.b.x
    public com.bytedance.sdk.a.b.b a(x.a aVar) throws IOException {
        b.a aVar2;
        com.bytedance.sdk.a.b.b epR;
        g gVar = (g) aVar;
        c epr = gVar.epr();
        com.bytedance.sdk.a.b.a.b.g epq = gVar.epq();
        com.bytedance.sdk.a.b.a.b.c cVar = (com.bytedance.sdk.a.b.a.b.c) gVar.epp();
        ab epu = gVar.epu();
        long currentTimeMillis = System.currentTimeMillis();
        gVar.ept().c(gVar.eps());
        epr.d(epu);
        gVar.ept().a(gVar.eps(), epu);
        b.a aVar3 = null;
        if (!f.c(epu.b()) || epu.eqD() == null) {
            aVar2 = null;
        } else {
            if (HTTP.EXPECT_CONTINUE.equalsIgnoreCase(epu.a(HTTP.EXPECT_DIRECTIVE))) {
                epr.a();
                gVar.ept().e(gVar.eps());
                aVar3 = epr.Ba(true);
            }
            if (aVar3 == null) {
                gVar.ept().d(gVar.eps());
                a aVar4 = new a(epr.a(epu, epu.eqD().b()));
                com.bytedance.sdk.a.a.d b2 = com.bytedance.sdk.a.a.l.b(aVar4);
                epu.eqD().a(b2);
                b2.close();
                gVar.ept().a(gVar.eps(), aVar4.f5877a);
                aVar2 = aVar3;
            } else {
                if (!cVar.d()) {
                    epq.d();
                }
                aVar2 = aVar3;
            }
        }
        epr.b();
        if (aVar2 == null) {
            gVar.ept().e(gVar.eps());
            aVar2 = epr.Ba(false);
        }
        com.bytedance.sdk.a.b.b epR2 = aVar2.f(epu).a(epq.epn().epg()).is(currentTimeMillis).it(System.currentTimeMillis()).epR();
        gVar.ept().a(gVar.eps(), epR2);
        int c = epR2.c();
        if (this.f5876a && c == 101) {
            epR = epR2.epO().a(com.bytedance.sdk.a.b.a.c.ppt).epR();
        } else {
            epR = epR2.epO().a(epr.c(epR2)).epR();
        }
        if ("close".equalsIgnoreCase(epR.epu().a(HTTP.CONN_DIRECTIVE)) || "close".equalsIgnoreCase(epR.a(HTTP.CONN_DIRECTIVE))) {
            epq.d();
        }
        if ((c == 204 || c == 205) && epR.epN().b() > 0) {
            throw new ProtocolException("HTTP " + c + " had non-zero Content-Length: " + epR.epN().b());
        }
        return epR;
    }

    /* loaded from: classes6.dex */
    static final class a extends com.bytedance.sdk.a.a.g {

        /* renamed from: a  reason: collision with root package name */
        long f5877a;

        a(r rVar) {
            super(rVar);
        }

        @Override // com.bytedance.sdk.a.a.g, com.bytedance.sdk.a.a.r
        public void a(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
            super.a(cVar, j);
            this.f5877a += j;
        }
    }
}
