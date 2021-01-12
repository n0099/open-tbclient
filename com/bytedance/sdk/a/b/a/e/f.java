package com.bytedance.sdk.a.b.a.e;

import android.net.http.Headers;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.bytedance.sdk.a.a.r;
import com.bytedance.sdk.a.a.s;
import com.bytedance.sdk.a.b.ab;
import com.bytedance.sdk.a.b.b;
import com.bytedance.sdk.a.b.v;
import com.bytedance.sdk.a.b.w;
import com.bytedance.sdk.a.b.x;
import com.bytedance.sdk.a.b.z;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public final class f implements com.bytedance.sdk.a.b.a.c.c {
    private final z pfq;
    private final x.a pfr;
    final com.bytedance.sdk.a.b.a.b.g pfs;
    private final g pft;
    private i pfu;

    /* renamed from: b  reason: collision with root package name */
    private static final com.bytedance.sdk.a.a.f f5896b = com.bytedance.sdk.a.a.f.a(Headers.CONN_DIRECTIVE);
    private static final com.bytedance.sdk.a.a.f pfg = com.bytedance.sdk.a.a.f.a("host");
    private static final com.bytedance.sdk.a.a.f pfh = com.bytedance.sdk.a.a.f.a("keep-alive");
    private static final com.bytedance.sdk.a.a.f pfi = com.bytedance.sdk.a.a.f.a(Headers.PROXY_CONNECTION);
    private static final com.bytedance.sdk.a.a.f pfj = com.bytedance.sdk.a.a.f.a(Headers.TRANSFER_ENCODING);
    private static final com.bytedance.sdk.a.a.f pfk = com.bytedance.sdk.a.a.f.a("te");
    private static final com.bytedance.sdk.a.a.f pfl = com.bytedance.sdk.a.a.f.a("encoding");
    private static final com.bytedance.sdk.a.a.f peC = com.bytedance.sdk.a.a.f.a(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE);
    private static final List<com.bytedance.sdk.a.a.f> j = com.bytedance.sdk.a.b.a.c.P(f5896b, pfg, pfh, pfi, pfk, pfj, pfl, peC, c.pfg, c.pfh, c.pfi, c.pfj);
    private static final List<com.bytedance.sdk.a.a.f> k = com.bytedance.sdk.a.b.a.c.P(f5896b, pfg, pfh, pfi, pfk, pfj, pfl, peC);

    public f(z zVar, x.a aVar, com.bytedance.sdk.a.b.a.b.g gVar, g gVar2) {
        this.pfq = zVar;
        this.pfr = aVar;
        this.pfs = gVar;
        this.pft = gVar2;
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public r a(ab abVar, long j2) {
        return this.pfu.ena();
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public void d(ab abVar) throws IOException {
        if (this.pfu == null) {
            this.pfu = this.pft.A(e(abVar), abVar.eoc() != null);
            this.pfu.emk().c(this.pfr.c(), TimeUnit.MILLISECONDS);
            this.pfu.eml().c(this.pfr.d(), TimeUnit.MILLISECONDS);
        }
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public void a() throws IOException {
        this.pft.b();
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public void b() throws IOException {
        this.pfu.ena().close();
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public b.a AH(boolean z) throws IOException {
        b.a gG = gG(this.pfu.d());
        if (z && com.bytedance.sdk.a.b.a.a.pdM.a(gG) == 100) {
            return null;
        }
        return gG;
    }

    public static List<c> e(ab abVar) {
        v emV = abVar.emV();
        ArrayList arrayList = new ArrayList(emV.a() + 4);
        arrayList.add(new c(c.pfg, abVar.b()));
        arrayList.add(new c(c.pfh, com.bytedance.sdk.a.b.a.c.i.b(abVar.emp())));
        String a2 = abVar.a("Host");
        if (a2 != null) {
            arrayList.add(new c(c.pfj, a2));
        }
        arrayList.add(new c(c.pfi, abVar.emp().b()));
        int a3 = emV.a();
        for (int i = 0; i < a3; i++) {
            com.bytedance.sdk.a.a.f a4 = com.bytedance.sdk.a.a.f.a(emV.a(i).toLowerCase(Locale.US));
            if (!j.contains(a4)) {
                arrayList.add(new c(a4, emV.b(i)));
            }
        }
        return arrayList;
    }

    public static b.a gG(List<c> list) throws IOException {
        v.a aVar;
        v.a aVar2 = new v.a();
        int size = list.size();
        int i = 0;
        com.bytedance.sdk.a.b.a.c.k kVar = null;
        while (i < size) {
            c cVar = list.get(i);
            if (cVar == null) {
                if (kVar != null && kVar.f5885b == 100) {
                    aVar = new v.a();
                    kVar = null;
                }
                aVar = aVar2;
            } else {
                com.bytedance.sdk.a.a.f fVar = cVar.pfk;
                String a2 = cVar.pfl.a();
                if (fVar.equals(c.f5890b)) {
                    kVar = com.bytedance.sdk.a.b.a.c.k.Xz("HTTP/1.1 " + a2);
                    aVar = aVar2;
                } else {
                    if (!k.contains(fVar)) {
                        com.bytedance.sdk.a.b.a.a.pdM.a(aVar2, fVar.a(), a2);
                    }
                    aVar = aVar2;
                }
            }
            i++;
            aVar2 = aVar;
        }
        if (kVar == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        return new b.a().a(w.HTTP_2).Ok(kVar.f5885b).XA(kVar.c).c(aVar2.enC());
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public com.bytedance.sdk.a.b.c c(com.bytedance.sdk.a.b.b bVar) throws IOException {
        this.pfs.pew.f(this.pfs.pev);
        return new com.bytedance.sdk.a.b.a.c.h(bVar.a("Content-Type"), com.bytedance.sdk.a.b.a.c.e.d(bVar), com.bytedance.sdk.a.a.l.c(new a(this.pfu.emZ())));
    }

    /* loaded from: classes4.dex */
    class a extends com.bytedance.sdk.a.a.h {

        /* renamed from: a  reason: collision with root package name */
        boolean f5897a;

        /* renamed from: b  reason: collision with root package name */
        long f5898b;

        a(s sVar) {
            super(sVar);
            this.f5897a = false;
            this.f5898b = 0L;
        }

        @Override // com.bytedance.sdk.a.a.h, com.bytedance.sdk.a.a.s
        public long b(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
            try {
                long b2 = emh().b(cVar, j);
                if (b2 > 0) {
                    this.f5898b += b2;
                }
                return b2;
            } catch (IOException e) {
                a(e);
                throw e;
            }
        }

        @Override // com.bytedance.sdk.a.a.h, com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            a(null);
        }

        private void a(IOException iOException) {
            if (!this.f5897a) {
                this.f5897a = true;
                f.this.pfs.a(false, f.this, this.f5898b, iOException);
            }
        }
    }
}
