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
        com.bytedance.sdk.a.b.b epJ;
        g gVar = (g) aVar;
        c epj = gVar.epj();
        com.bytedance.sdk.a.b.a.b.g epi = gVar.epi();
        com.bytedance.sdk.a.b.a.b.c cVar = (com.bytedance.sdk.a.b.a.b.c) gVar.eph();
        ab epm = gVar.epm();
        long currentTimeMillis = System.currentTimeMillis();
        gVar.epl().c(gVar.epk());
        epj.d(epm);
        gVar.epl().a(gVar.epk(), epm);
        b.a aVar3 = null;
        if (!f.c(epm.b()) || epm.eqv() == null) {
            aVar2 = null;
        } else {
            if (HTTP.EXPECT_CONTINUE.equalsIgnoreCase(epm.a(HTTP.EXPECT_DIRECTIVE))) {
                epj.a();
                gVar.epl().e(gVar.epk());
                aVar3 = epj.Ba(true);
            }
            if (aVar3 == null) {
                gVar.epl().d(gVar.epk());
                a aVar4 = new a(epj.a(epm, epm.eqv().b()));
                com.bytedance.sdk.a.a.d b2 = com.bytedance.sdk.a.a.l.b(aVar4);
                epm.eqv().a(b2);
                b2.close();
                gVar.epl().a(gVar.epk(), aVar4.f5877a);
                aVar2 = aVar3;
            } else {
                if (!cVar.d()) {
                    epi.d();
                }
                aVar2 = aVar3;
            }
        }
        epj.b();
        if (aVar2 == null) {
            gVar.epl().e(gVar.epk());
            aVar2 = epj.Ba(false);
        }
        com.bytedance.sdk.a.b.b epJ2 = aVar2.f(epm).a(epi.epf().eoY()).is(currentTimeMillis).it(System.currentTimeMillis()).epJ();
        gVar.epl().a(gVar.epk(), epJ2);
        int c = epJ2.c();
        if (this.f5876a && c == 101) {
            epJ = epJ2.epG().a(com.bytedance.sdk.a.b.a.c.poR).epJ();
        } else {
            epJ = epJ2.epG().a(epj.c(epJ2)).epJ();
        }
        if ("close".equalsIgnoreCase(epJ.epm().a(HTTP.CONN_DIRECTIVE)) || "close".equalsIgnoreCase(epJ.a(HTTP.CONN_DIRECTIVE))) {
            epi.d();
        }
        if ((c == 204 || c == 205) && epJ.epF().b() > 0) {
            throw new ProtocolException("HTTP " + c + " had non-zero Content-Length: " + epJ.epF().b());
        }
        return epJ;
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
