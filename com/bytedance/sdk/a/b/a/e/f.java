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
/* loaded from: classes6.dex */
public final class f implements com.bytedance.sdk.a.b.a.c.c {
    private final z pqj;
    private final x.a pqk;
    final com.bytedance.sdk.a.b.a.b.g pql;
    private final g pqm;
    private i pqn;

    /* renamed from: b  reason: collision with root package name */
    private static final com.bytedance.sdk.a.a.f f5898b = com.bytedance.sdk.a.a.f.a(Headers.CONN_DIRECTIVE);
    private static final com.bytedance.sdk.a.a.f ppZ = com.bytedance.sdk.a.a.f.a("host");
    private static final com.bytedance.sdk.a.a.f pqa = com.bytedance.sdk.a.a.f.a("keep-alive");
    private static final com.bytedance.sdk.a.a.f pqb = com.bytedance.sdk.a.a.f.a(Headers.PROXY_CONNECTION);
    private static final com.bytedance.sdk.a.a.f pqc = com.bytedance.sdk.a.a.f.a(Headers.TRANSFER_ENCODING);
    private static final com.bytedance.sdk.a.a.f pqd = com.bytedance.sdk.a.a.f.a("te");
    private static final com.bytedance.sdk.a.a.f pqe = com.bytedance.sdk.a.a.f.a("encoding");
    private static final com.bytedance.sdk.a.a.f ppv = com.bytedance.sdk.a.a.f.a(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE);
    private static final List<com.bytedance.sdk.a.a.f> j = com.bytedance.sdk.a.b.a.c.P(f5898b, ppZ, pqa, pqb, pqd, pqc, pqe, ppv, c.ppZ, c.pqa, c.pqb, c.pqc);
    private static final List<com.bytedance.sdk.a.a.f> k = com.bytedance.sdk.a.b.a.c.P(f5898b, ppZ, pqa, pqb, pqd, pqc, pqe, ppv);

    public f(z zVar, x.a aVar, com.bytedance.sdk.a.b.a.b.g gVar, g gVar2) {
        this.pqj = zVar;
        this.pqk = aVar;
        this.pql = gVar;
        this.pqm = gVar2;
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public r a(ab abVar, long j2) {
        return this.pqn.epC();
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public void d(ab abVar) throws IOException {
        if (this.pqn == null) {
            this.pqn = this.pqm.C(e(abVar), abVar.eqD() != null);
            this.pqn.eoM().c(this.pqk.c(), TimeUnit.MILLISECONDS);
            this.pqn.eoN().c(this.pqk.d(), TimeUnit.MILLISECONDS);
        }
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public void a() throws IOException {
        this.pqm.b();
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public void b() throws IOException {
        this.pqn.epC().close();
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public b.a Ba(boolean z) throws IOException {
        b.a gE = gE(this.pqn.d());
        if (z && com.bytedance.sdk.a.b.a.a.poD.a(gE) == 100) {
            return null;
        }
        return gE;
    }

    public static List<c> e(ab abVar) {
        v epx = abVar.epx();
        ArrayList arrayList = new ArrayList(epx.a() + 4);
        arrayList.add(new c(c.ppZ, abVar.b()));
        arrayList.add(new c(c.pqa, com.bytedance.sdk.a.b.a.c.i.b(abVar.eoR())));
        String a2 = abVar.a("Host");
        if (a2 != null) {
            arrayList.add(new c(c.pqc, a2));
        }
        arrayList.add(new c(c.pqb, abVar.eoR().b()));
        int a3 = epx.a();
        for (int i = 0; i < a3; i++) {
            com.bytedance.sdk.a.a.f a4 = com.bytedance.sdk.a.a.f.a(epx.a(i).toLowerCase(Locale.US));
            if (!j.contains(a4)) {
                arrayList.add(new c(a4, epx.b(i)));
            }
        }
        return arrayList;
    }

    public static b.a gE(List<c> list) throws IOException {
        v.a aVar;
        v.a aVar2 = new v.a();
        int size = list.size();
        int i = 0;
        com.bytedance.sdk.a.b.a.c.k kVar = null;
        while (i < size) {
            c cVar = list.get(i);
            if (cVar == null) {
                if (kVar != null && kVar.f5887b == 100) {
                    aVar = new v.a();
                    kVar = null;
                }
                aVar = aVar2;
            } else {
                com.bytedance.sdk.a.a.f fVar = cVar.pqd;
                String a2 = cVar.pqe.a();
                if (fVar.equals(c.f5892b)) {
                    kVar = com.bytedance.sdk.a.b.a.c.k.YN("HTTP/1.1 " + a2);
                    aVar = aVar2;
                } else {
                    if (!k.contains(fVar)) {
                        com.bytedance.sdk.a.b.a.a.poD.a(aVar2, fVar.a(), a2);
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
        return new b.a().a(w.HTTP_2).OG(kVar.f5887b).YO(kVar.c).c(aVar2.eqd());
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public com.bytedance.sdk.a.b.c c(com.bytedance.sdk.a.b.b bVar) throws IOException {
        this.pql.ppo.f(this.pql.ppn);
        return new com.bytedance.sdk.a.b.a.c.h(bVar.a("Content-Type"), com.bytedance.sdk.a.b.a.c.e.d(bVar), com.bytedance.sdk.a.a.l.c(new a(this.pqn.epB())));
    }

    /* loaded from: classes6.dex */
    class a extends com.bytedance.sdk.a.a.h {

        /* renamed from: a  reason: collision with root package name */
        boolean f5899a;

        /* renamed from: b  reason: collision with root package name */
        long f5900b;

        a(s sVar) {
            super(sVar);
            this.f5899a = false;
            this.f5900b = 0L;
        }

        @Override // com.bytedance.sdk.a.a.h, com.bytedance.sdk.a.a.s
        public long b(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
            try {
                long b2 = eoJ().b(cVar, j);
                if (b2 > 0) {
                    this.f5900b += b2;
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
            if (!this.f5899a) {
                this.f5899a = true;
                f.this.pql.a(false, f.this, this.f5900b, iOException);
            }
        }
    }
}
