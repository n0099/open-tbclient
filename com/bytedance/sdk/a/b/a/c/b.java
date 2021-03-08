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
    private final boolean f3958a;

    public b(boolean z) {
        this.f3958a = z;
    }

    @Override // com.bytedance.sdk.a.b.x
    public com.bytedance.sdk.a.b.b a(x.a aVar) throws IOException {
        b.a aVar2;
        com.bytedance.sdk.a.b.b epY;
        g gVar = (g) aVar;
        c epy = gVar.epy();
        com.bytedance.sdk.a.b.a.b.g epx = gVar.epx();
        com.bytedance.sdk.a.b.a.b.c cVar = (com.bytedance.sdk.a.b.a.b.c) gVar.epw();
        ab epB = gVar.epB();
        long currentTimeMillis = System.currentTimeMillis();
        gVar.epA().c(gVar.epz());
        epy.d(epB);
        gVar.epA().a(gVar.epz(), epB);
        b.a aVar3 = null;
        if (!f.c(epB.b()) || epB.eqK() == null) {
            aVar2 = null;
        } else {
            if (HTTP.EXPECT_CONTINUE.equalsIgnoreCase(epB.a(HTTP.EXPECT_DIRECTIVE))) {
                epy.a();
                gVar.epA().e(gVar.epz());
                aVar3 = epy.AZ(true);
            }
            if (aVar3 == null) {
                gVar.epA().d(gVar.epz());
                a aVar4 = new a(epy.a(epB, epB.eqK().b()));
                com.bytedance.sdk.a.a.d b = com.bytedance.sdk.a.a.l.b(aVar4);
                epB.eqK().a(b);
                b.close();
                gVar.epA().a(gVar.epz(), aVar4.f3959a);
                aVar2 = aVar3;
            } else {
                if (!cVar.d()) {
                    epx.d();
                }
                aVar2 = aVar3;
            }
        }
        epy.b();
        if (aVar2 == null) {
            gVar.epA().e(gVar.epz());
            aVar2 = epy.AZ(false);
        }
        com.bytedance.sdk.a.b.b epY2 = aVar2.f(epB).a(epx.epu().epn()).is(currentTimeMillis).it(System.currentTimeMillis()).epY();
        gVar.epA().a(gVar.epz(), epY2);
        int c = epY2.c();
        if (this.f3958a && c == 101) {
            epY = epY2.epV().a(com.bytedance.sdk.a.b.a.c.pry).epY();
        } else {
            epY = epY2.epV().a(epy.c(epY2)).epY();
        }
        if ("close".equalsIgnoreCase(epY.epB().a(HTTP.CONN_DIRECTIVE)) || "close".equalsIgnoreCase(epY.a(HTTP.CONN_DIRECTIVE))) {
            epx.d();
        }
        if ((c == 204 || c == 205) && epY.epU().b() > 0) {
            throw new ProtocolException("HTTP " + c + " had non-zero Content-Length: " + epY.epU().b());
        }
        return epY;
    }

    /* loaded from: classes6.dex */
    static final class a extends com.bytedance.sdk.a.a.g {

        /* renamed from: a  reason: collision with root package name */
        long f3959a;

        a(r rVar) {
            super(rVar);
        }

        @Override // com.bytedance.sdk.a.a.g, com.bytedance.sdk.a.a.r
        public void a(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
            super.a(cVar, j);
            this.f3959a += j;
        }
    }
}
