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
    public final ab poI;
    public final com.bytedance.sdk.a.b.b poJ;

    c(ab abVar, com.bytedance.sdk.a.b.b bVar) {
        this.poI = abVar;
        this.poJ = bVar;
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
                if (bVar.a(Headers.EXPIRES) == null && bVar.epQ().c() == -1 && !bVar.epQ().e() && !bVar.epQ().d()) {
                    return false;
                }
                break;
        }
        return (bVar.epQ().b() || abVar.eqF().b()) ? false : true;
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
        final ab poK;
        final com.bytedance.sdk.a.b.b poL;
        private Date poM;
        private Date poN;

        public a(long j, ab abVar, com.bytedance.sdk.a.b.b bVar) {
            this.l = -1;
            this.f5857a = j;
            this.poK = abVar;
            this.poL = bVar;
            if (bVar != null) {
                this.i = bVar.k();
                this.j = bVar.l();
                v epM = bVar.epM();
                int a2 = epM.a();
                for (int i = 0; i < a2; i++) {
                    String a3 = epM.a(i);
                    String b2 = epM.b(i);
                    if ("Date".equalsIgnoreCase(a3)) {
                        this.d = com.bytedance.sdk.a.b.a.c.d.a(b2);
                        this.e = b2;
                    } else if (Headers.EXPIRES.equalsIgnoreCase(a3)) {
                        this.poN = com.bytedance.sdk.a.b.a.c.d.a(b2);
                    } else if (Headers.LAST_MODIFIED.equalsIgnoreCase(a3)) {
                        this.poM = com.bytedance.sdk.a.b.a.c.d.a(b2);
                        this.g = b2;
                    } else if (Headers.ETAG.equalsIgnoreCase(a3)) {
                        this.k = b2;
                    } else if ("Age".equalsIgnoreCase(a3)) {
                        this.l = com.bytedance.sdk.a.b.a.c.e.b(b2, -1);
                    }
                }
            }
        }

        public c epb() {
            c epc = epc();
            if (epc.poI != null && this.poK.eqF().i()) {
                return new c(null, null);
            }
            return epc;
        }

        private c epc() {
            String str;
            String str2;
            long j = 0;
            if (this.poL == null) {
                return new c(this.poK, null);
            }
            if (this.poK.g() && this.poL.epL() == null) {
                return new c(this.poK, null);
            }
            if (!c.a(this.poL, this.poK)) {
                return new c(this.poK, null);
            }
            g eqF = this.poK.eqF();
            if (eqF.a() || a(this.poK)) {
                return new c(this.poK, null);
            }
            g epQ = this.poL.epQ();
            if (epQ.j()) {
                return new c(null, this.poL);
            }
            long d = d();
            long c = c();
            if (eqF.c() != -1) {
                c = Math.min(c, TimeUnit.SECONDS.toMillis(eqF.c()));
            }
            long millis = eqF.h() != -1 ? TimeUnit.SECONDS.toMillis(eqF.h()) : 0L;
            if (!epQ.f() && eqF.g() != -1) {
                j = TimeUnit.SECONDS.toMillis(eqF.g());
            }
            if (!epQ.a() && d + millis < j + c) {
                b.a epO = this.poL.epO();
                if (millis + d >= c) {
                    epO.hk("Warning", "110 HttpURLConnection \"Response is stale\"");
                }
                if (d > 86400000 && e()) {
                    epO.hk("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                }
                return new c(null, epO.epR());
            }
            if (this.k != null) {
                str = "If-None-Match";
                str2 = this.k;
            } else if (this.poM != null) {
                str = "If-Modified-Since";
                str2 = this.g;
            } else if (this.d != null) {
                str = "If-Modified-Since";
                str2 = this.e;
            } else {
                return new c(this.poK, null);
            }
            v.a eqc = this.poK.epx().eqc();
            com.bytedance.sdk.a.b.a.a.poD.a(eqc, str, str2);
            return new c(this.poK.eqE().e(eqc.eqd()).eqJ(), this.poL);
        }

        private long c() {
            g epQ;
            if (this.poL.epQ().c() != -1) {
                return TimeUnit.SECONDS.toMillis(epQ.c());
            }
            if (this.poN != null) {
                long time = this.poN.getTime() - (this.d != null ? this.d.getTime() : this.j);
                if (time <= 0) {
                    time = 0;
                }
                return time;
            } else if (this.poM == null || this.poL.epu().eoR().k() != null) {
                return 0L;
            } else {
                long time2 = (this.d != null ? this.d.getTime() : this.i) - this.poM.getTime();
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
            return this.poL.epQ().c() == -1 && this.poN == null;
        }

        private static boolean a(ab abVar) {
            return (abVar.a("If-Modified-Since") == null && abVar.a("If-None-Match") == null) ? false : true;
        }
    }
}
