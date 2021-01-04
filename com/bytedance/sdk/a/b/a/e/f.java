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
    private final z pjV;
    private final x.a pjW;
    final com.bytedance.sdk.a.b.a.b.g pjX;
    private final g pjY;
    private i pjZ;

    /* renamed from: b  reason: collision with root package name */
    private static final com.bytedance.sdk.a.a.f f6195b = com.bytedance.sdk.a.a.f.a(Headers.CONN_DIRECTIVE);
    private static final com.bytedance.sdk.a.a.f pjL = com.bytedance.sdk.a.a.f.a("host");
    private static final com.bytedance.sdk.a.a.f pjM = com.bytedance.sdk.a.a.f.a("keep-alive");
    private static final com.bytedance.sdk.a.a.f pjN = com.bytedance.sdk.a.a.f.a(Headers.PROXY_CONNECTION);
    private static final com.bytedance.sdk.a.a.f pjO = com.bytedance.sdk.a.a.f.a(Headers.TRANSFER_ENCODING);
    private static final com.bytedance.sdk.a.a.f pjP = com.bytedance.sdk.a.a.f.a("te");
    private static final com.bytedance.sdk.a.a.f pjQ = com.bytedance.sdk.a.a.f.a("encoding");
    private static final com.bytedance.sdk.a.a.f pjh = com.bytedance.sdk.a.a.f.a(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE);
    private static final List<com.bytedance.sdk.a.a.f> j = com.bytedance.sdk.a.b.a.c.P(f6195b, pjL, pjM, pjN, pjP, pjO, pjQ, pjh, c.pjL, c.pjM, c.pjN, c.pjO);
    private static final List<com.bytedance.sdk.a.a.f> k = com.bytedance.sdk.a.b.a.c.P(f6195b, pjL, pjM, pjN, pjP, pjO, pjQ, pjh);

    public f(z zVar, x.a aVar, com.bytedance.sdk.a.b.a.b.g gVar, g gVar2) {
        this.pjV = zVar;
        this.pjW = aVar;
        this.pjX = gVar;
        this.pjY = gVar2;
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public r a(ab abVar, long j2) {
        return this.pjZ.eqV();
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public void d(ab abVar) throws IOException {
        if (this.pjZ == null) {
            this.pjZ = this.pjY.A(e(abVar), abVar.erW() != null);
            this.pjZ.eqf().c(this.pjW.c(), TimeUnit.MILLISECONDS);
            this.pjZ.eqg().c(this.pjW.d(), TimeUnit.MILLISECONDS);
        }
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public void a() throws IOException {
        this.pjY.b();
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public void b() throws IOException {
        this.pjZ.eqV().close();
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public b.a AL(boolean z) throws IOException {
        b.a gG = gG(this.pjZ.d());
        if (z && com.bytedance.sdk.a.b.a.a.pir.a(gG) == 100) {
            return null;
        }
        return gG;
    }

    public static List<c> e(ab abVar) {
        v eqQ = abVar.eqQ();
        ArrayList arrayList = new ArrayList(eqQ.a() + 4);
        arrayList.add(new c(c.pjL, abVar.b()));
        arrayList.add(new c(c.pjM, com.bytedance.sdk.a.b.a.c.i.b(abVar.eqk())));
        String a2 = abVar.a("Host");
        if (a2 != null) {
            arrayList.add(new c(c.pjO, a2));
        }
        arrayList.add(new c(c.pjN, abVar.eqk().b()));
        int a3 = eqQ.a();
        for (int i = 0; i < a3; i++) {
            com.bytedance.sdk.a.a.f a4 = com.bytedance.sdk.a.a.f.a(eqQ.a(i).toLowerCase(Locale.US));
            if (!j.contains(a4)) {
                arrayList.add(new c(a4, eqQ.b(i)));
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
                if (kVar != null && kVar.f6184b == 100) {
                    aVar = new v.a();
                    kVar = null;
                }
                aVar = aVar2;
            } else {
                com.bytedance.sdk.a.a.f fVar = cVar.pjP;
                String a2 = cVar.pjQ.a();
                if (fVar.equals(c.f6189b)) {
                    kVar = com.bytedance.sdk.a.b.a.c.k.YI("HTTP/1.1 " + a2);
                    aVar = aVar2;
                } else {
                    if (!k.contains(fVar)) {
                        com.bytedance.sdk.a.b.a.a.pir.a(aVar2, fVar.a(), a2);
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
        return new b.a().a(w.HTTP_2).PR(kVar.f6184b).YJ(kVar.c).c(aVar2.erx());
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public com.bytedance.sdk.a.b.c c(com.bytedance.sdk.a.b.b bVar) throws IOException {
        this.pjX.pjb.f(this.pjX.pja);
        return new com.bytedance.sdk.a.b.a.c.h(bVar.a("Content-Type"), com.bytedance.sdk.a.b.a.c.e.d(bVar), com.bytedance.sdk.a.a.l.c(new a(this.pjZ.eqU())));
    }

    /* loaded from: classes4.dex */
    class a extends com.bytedance.sdk.a.a.h {

        /* renamed from: a  reason: collision with root package name */
        boolean f6196a;

        /* renamed from: b  reason: collision with root package name */
        long f6197b;

        a(s sVar) {
            super(sVar);
            this.f6196a = false;
            this.f6197b = 0L;
        }

        @Override // com.bytedance.sdk.a.a.h, com.bytedance.sdk.a.a.s
        public long b(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
            try {
                long b2 = eqc().b(cVar, j);
                if (b2 > 0) {
                    this.f6197b += b2;
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
            if (!this.f6196a) {
                this.f6196a = true;
                f.this.pjX.a(false, f.this, this.f6197b, iOException);
            }
        }
    }
}
