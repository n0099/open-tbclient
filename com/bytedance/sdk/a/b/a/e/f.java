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
    private final z pso;
    private final x.a psp;
    final com.bytedance.sdk.a.b.a.b.g psq;
    private final g psr;
    private i pss;
    private static final com.bytedance.sdk.a.a.f b = com.bytedance.sdk.a.a.f.a(Headers.CONN_DIRECTIVE);
    private static final com.bytedance.sdk.a.a.f pse = com.bytedance.sdk.a.a.f.a("host");
    private static final com.bytedance.sdk.a.a.f psf = com.bytedance.sdk.a.a.f.a("keep-alive");
    private static final com.bytedance.sdk.a.a.f psg = com.bytedance.sdk.a.a.f.a(Headers.PROXY_CONNECTION);
    private static final com.bytedance.sdk.a.a.f psh = com.bytedance.sdk.a.a.f.a(Headers.TRANSFER_ENCODING);
    private static final com.bytedance.sdk.a.a.f psi = com.bytedance.sdk.a.a.f.a("te");
    private static final com.bytedance.sdk.a.a.f psj = com.bytedance.sdk.a.a.f.a("encoding");
    private static final com.bytedance.sdk.a.a.f prA = com.bytedance.sdk.a.a.f.a(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE);
    private static final List<com.bytedance.sdk.a.a.f> j = com.bytedance.sdk.a.b.a.c.O(b, pse, psf, psg, psi, psh, psj, prA, c.pse, c.psf, c.psg, c.psh);
    private static final List<com.bytedance.sdk.a.a.f> k = com.bytedance.sdk.a.b.a.c.O(b, pse, psf, psg, psi, psh, psj, prA);

    public f(z zVar, x.a aVar, com.bytedance.sdk.a.b.a.b.g gVar, g gVar2) {
        this.pso = zVar;
        this.psp = aVar;
        this.psq = gVar;
        this.psr = gVar2;
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public r a(ab abVar, long j2) {
        return this.pss.epJ();
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public void d(ab abVar) throws IOException {
        if (this.pss == null) {
            this.pss = this.psr.C(e(abVar), abVar.eqK() != null);
            this.pss.eoT().b(this.psp.c(), TimeUnit.MILLISECONDS);
            this.pss.eoU().b(this.psp.d(), TimeUnit.MILLISECONDS);
        }
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public void a() throws IOException {
        this.psr.b();
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public void b() throws IOException {
        this.pss.epJ().close();
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public b.a AZ(boolean z) throws IOException {
        b.a gE = gE(this.pss.d());
        if (z && com.bytedance.sdk.a.b.a.a.pqK.a(gE) == 100) {
            return null;
        }
        return gE;
    }

    public static List<c> e(ab abVar) {
        v epE = abVar.epE();
        ArrayList arrayList = new ArrayList(epE.a() + 4);
        arrayList.add(new c(c.pse, abVar.b()));
        arrayList.add(new c(c.psf, com.bytedance.sdk.a.b.a.c.i.b(abVar.eoY())));
        String a2 = abVar.a("Host");
        if (a2 != null) {
            arrayList.add(new c(c.psh, a2));
        }
        arrayList.add(new c(c.psg, abVar.eoY().b()));
        int a3 = epE.a();
        for (int i = 0; i < a3; i++) {
            com.bytedance.sdk.a.a.f a4 = com.bytedance.sdk.a.a.f.a(epE.a(i).toLowerCase(Locale.US));
            if (!j.contains(a4)) {
                arrayList.add(new c(a4, epE.b(i)));
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
                if (kVar != null && kVar.b == 100) {
                    aVar = new v.a();
                    kVar = null;
                }
                aVar = aVar2;
            } else {
                com.bytedance.sdk.a.a.f fVar = cVar.psi;
                String a2 = cVar.psj.a();
                if (fVar.equals(c.b)) {
                    kVar = com.bytedance.sdk.a.b.a.c.k.YU("HTTP/1.1 " + a2);
                    aVar = aVar2;
                } else {
                    if (!k.contains(fVar)) {
                        com.bytedance.sdk.a.b.a.a.pqK.a(aVar2, fVar.a(), a2);
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
        return new b.a().a(w.HTTP_2).OK(kVar.b).YV(kVar.c).c(aVar2.eqk());
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public com.bytedance.sdk.a.b.c c(com.bytedance.sdk.a.b.b bVar) throws IOException {
        this.psq.pru.f(this.psq.prt);
        return new com.bytedance.sdk.a.b.a.c.h(bVar.a("Content-Type"), com.bytedance.sdk.a.b.a.c.e.d(bVar), com.bytedance.sdk.a.a.l.c(new a(this.pss.epI())));
    }

    /* loaded from: classes6.dex */
    class a extends com.bytedance.sdk.a.a.h {

        /* renamed from: a  reason: collision with root package name */
        boolean f3969a;
        long b;

        a(s sVar) {
            super(sVar);
            this.f3969a = false;
            this.b = 0L;
        }

        @Override // com.bytedance.sdk.a.a.h, com.bytedance.sdk.a.a.s
        public long b(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
            try {
                long b = eoQ().b(cVar, j);
                if (b > 0) {
                    this.b += b;
                }
                return b;
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
            if (!this.f3969a) {
                this.f3969a = true;
                f.this.psq.a(false, f.this, this.b, iOException);
            }
        }
    }
}
