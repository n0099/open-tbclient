package com.bytedance.sdk.a.b.a.a;

import com.baidubce.http.Headers;
import com.bytedance.sdk.a.b.ab;
import com.bytedance.sdk.a.b.b;
import com.bytedance.sdk.a.b.g;
import com.bytedance.sdk.a.b.v;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.http.StatusLine;
/* loaded from: classes6.dex */
public final class c {
    public final ab pof;
    public final com.bytedance.sdk.a.b.b pog;

    c(ab abVar, com.bytedance.sdk.a.b.b bVar) {
        this.pof = abVar;
        this.pog = bVar;
    }

    public static boolean a(com.bytedance.sdk.a.b.b bVar, ab abVar) {
        switch (bVar.c()) {
            case 200:
            case 203:
            case 204:
            case 300:
            case 301:
            case StatusLine.HTTP_PERM_REDIRECT /* 308 */:
            case 404:
            case 405:
            case 410:
            case 414:
            case 501:
                break;
            default:
                return false;
            case 302:
            case 307:
                if (bVar.a(Headers.EXPIRES) == null && bVar.epI().c() == -1 && !bVar.epI().e() && !bVar.epI().d()) {
                    return false;
                }
                break;
        }
        return (bVar.epI().b() || abVar.eqx().b()) ? false : true;
    }

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final long f5857a;
        private Date d;
        private String e;
        private String g;
        private long i;
        private long j;
        private String k;
        private int l;
        final ab poh;
        final com.bytedance.sdk.a.b.b poj;
        private Date pok;
        private Date pol;

        public a(long j, ab abVar, com.bytedance.sdk.a.b.b bVar) {
            this.l = -1;
            this.f5857a = j;
            this.poh = abVar;
            this.poj = bVar;
            if (bVar != null) {
                this.i = bVar.k();
                this.j = bVar.l();
                v epE = bVar.epE();
                int a2 = epE.a();
                for (int i = 0; i < a2; i++) {
                    String a3 = epE.a(i);
                    String b2 = epE.b(i);
                    if ("Date".equalsIgnoreCase(a3)) {
                        this.d = com.bytedance.sdk.a.b.a.c.d.a(b2);
                        this.e = b2;
                    } else if (Headers.EXPIRES.equalsIgnoreCase(a3)) {
                        this.pol = com.bytedance.sdk.a.b.a.c.d.a(b2);
                    } else if (Headers.LAST_MODIFIED.equalsIgnoreCase(a3)) {
                        this.pok = com.bytedance.sdk.a.b.a.c.d.a(b2);
                        this.g = b2;
                    } else if (Headers.ETAG.equalsIgnoreCase(a3)) {
                        this.k = b2;
                    } else if ("Age".equalsIgnoreCase(a3)) {
                        this.l = com.bytedance.sdk.a.b.a.c.e.b(b2, -1);
                    }
                }
            }
        }

        public c eoT() {
            c eoU = eoU();
            if (eoU.pof != null && this.poh.eqx().i()) {
                return new c(null, null);
            }
            return eoU;
        }

        private c eoU() {
            String str;
            String str2;
            long j = 0;
            if (this.poj == null) {
                return new c(this.poh, null);
            }
            if (this.poh.g() && this.poj.epD() == null) {
                return new c(this.poh, null);
            }
            if (!c.a(this.poj, this.poh)) {
                return new c(this.poh, null);
            }
            g eqx = this.poh.eqx();
            if (eqx.a() || a(this.poh)) {
                return new c(this.poh, null);
            }
            g epI = this.poj.epI();
            if (epI.j()) {
                return new c(null, this.poj);
            }
            long d = d();
            long c = c();
            if (eqx.c() != -1) {
                c = Math.min(c, TimeUnit.SECONDS.toMillis(eqx.c()));
            }
            long millis = eqx.h() != -1 ? TimeUnit.SECONDS.toMillis(eqx.h()) : 0L;
            if (!epI.f() && eqx.g() != -1) {
                j = TimeUnit.SECONDS.toMillis(eqx.g());
            }
            if (!epI.a() && d + millis < j + c) {
                b.a epG = this.poj.epG();
                if (millis + d >= c) {
                    epG.hi("Warning", "110 HttpURLConnection \"Response is stale\"");
                }
                if (d > 86400000 && e()) {
                    epG.hi("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                }
                return new c(null, epG.epJ());
            }
            if (this.k != null) {
                str = "If-None-Match";
                str2 = this.k;
            } else if (this.pok != null) {
                str = "If-Modified-Since";
                str2 = this.g;
            } else if (this.d != null) {
                str = "If-Modified-Since";
                str2 = this.e;
            } else {
                return new c(this.poh, null);
            }
            v.a epU = this.poh.epp().epU();
            com.bytedance.sdk.a.b.a.a.poa.a(epU, str, str2);
            return new c(this.poh.eqw().e(epU.epV()).eqB(), this.poj);
        }

        private long c() {
            g epI;
            if (this.poj.epI().c() != -1) {
                return TimeUnit.SECONDS.toMillis(epI.c());
            }
            if (this.pol != null) {
                long time = this.pol.getTime() - (this.d != null ? this.d.getTime() : this.j);
                if (time <= 0) {
                    time = 0;
                }
                return time;
            } else if (this.pok == null || this.poj.epm().eoJ().k() != null) {
                return 0L;
            } else {
                long time2 = (this.d != null ? this.d.getTime() : this.i) - this.pok.getTime();
                if (time2 > 0) {
                    return time2 / 10;
                }
                return 0L;
            }
        }

        private long d() {
            long max = this.d != null ? Math.max(0L, this.j - this.d.getTime()) : 0L;
            if (this.l != -1) {
                max = Math.max(max, TimeUnit.SECONDS.toMillis(this.l));
            }
            return max + (this.j - this.i) + (this.f5857a - this.j);
        }

        private boolean e() {
            return this.poj.epI().c() == -1 && this.pol == null;
        }

        private static boolean a(ab abVar) {
            return (abVar.a("If-Modified-Since") == null && abVar.a("If-None-Match") == null) ? false : true;
        }
    }
}
