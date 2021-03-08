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
    public final ab pqP;
    public final com.bytedance.sdk.a.b.b pqQ;

    c(ab abVar, com.bytedance.sdk.a.b.b bVar) {
        this.pqP = abVar;
        this.pqQ = bVar;
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
                if (bVar.a(Headers.EXPIRES) == null && bVar.epX().c() == -1 && !bVar.epX().e() && !bVar.epX().d()) {
                    return false;
                }
                break;
        }
        return (bVar.epX().b() || abVar.eqM().b()) ? false : true;
    }

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final long f3946a;
        private Date d;
        private String e;
        private String g;
        private long i;
        private long j;
        private String k;
        private int l;
        final ab pqR;
        final com.bytedance.sdk.a.b.b pqS;
        private Date pqT;
        private Date pqU;

        public a(long j, ab abVar, com.bytedance.sdk.a.b.b bVar) {
            this.l = -1;
            this.f3946a = j;
            this.pqR = abVar;
            this.pqS = bVar;
            if (bVar != null) {
                this.i = bVar.l();
                this.j = bVar.m();
                v epT = bVar.epT();
                int a2 = epT.a();
                for (int i = 0; i < a2; i++) {
                    String a3 = epT.a(i);
                    String b = epT.b(i);
                    if ("Date".equalsIgnoreCase(a3)) {
                        this.d = com.bytedance.sdk.a.b.a.c.d.a(b);
                        this.e = b;
                    } else if (Headers.EXPIRES.equalsIgnoreCase(a3)) {
                        this.pqU = com.bytedance.sdk.a.b.a.c.d.a(b);
                    } else if (Headers.LAST_MODIFIED.equalsIgnoreCase(a3)) {
                        this.pqT = com.bytedance.sdk.a.b.a.c.d.a(b);
                        this.g = b;
                    } else if (Headers.ETAG.equalsIgnoreCase(a3)) {
                        this.k = b;
                    } else if ("Age".equalsIgnoreCase(a3)) {
                        this.l = com.bytedance.sdk.a.b.a.c.e.b(b, -1);
                    }
                }
            }
        }

        public c epi() {
            c epj = epj();
            if (epj.pqP != null && this.pqR.eqM().i()) {
                return new c(null, null);
            }
            return epj;
        }

        private c epj() {
            String str;
            String str2;
            long j = 0;
            if (this.pqS == null) {
                return new c(this.pqR, null);
            }
            if (this.pqR.g() && this.pqS.epS() == null) {
                return new c(this.pqR, null);
            }
            if (!c.a(this.pqS, this.pqR)) {
                return new c(this.pqR, null);
            }
            g eqM = this.pqR.eqM();
            if (eqM.a() || a(this.pqR)) {
                return new c(this.pqR, null);
            }
            g epX = this.pqS.epX();
            if (epX.j()) {
                return new c(null, this.pqS);
            }
            long d = d();
            long c = c();
            if (eqM.c() != -1) {
                c = Math.min(c, TimeUnit.SECONDS.toMillis(eqM.c()));
            }
            long millis = eqM.h() != -1 ? TimeUnit.SECONDS.toMillis(eqM.h()) : 0L;
            if (!epX.f() && eqM.g() != -1) {
                j = TimeUnit.SECONDS.toMillis(eqM.g());
            }
            if (!epX.a() && d + millis < j + c) {
                b.a epV = this.pqS.epV();
                if (millis + d >= c) {
                    epV.hk("Warning", "110 HttpURLConnection \"Response is stale\"");
                }
                if (d > 86400000 && e()) {
                    epV.hk("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                }
                return new c(null, epV.epY());
            }
            if (this.k != null) {
                str = "If-None-Match";
                str2 = this.k;
            } else if (this.pqT != null) {
                str = "If-Modified-Since";
                str2 = this.g;
            } else if (this.d != null) {
                str = "If-Modified-Since";
                str2 = this.e;
            } else {
                return new c(this.pqR, null);
            }
            v.a eqj = this.pqR.epE().eqj();
            com.bytedance.sdk.a.b.a.a.pqK.a(eqj, str, str2);
            return new c(this.pqR.eqL().e(eqj.eqk()).eqQ(), this.pqS);
        }

        private long c() {
            g epX;
            if (this.pqS.epX().c() != -1) {
                return TimeUnit.SECONDS.toMillis(epX.c());
            }
            if (this.pqU != null) {
                long time = this.pqU.getTime() - (this.d != null ? this.d.getTime() : this.j);
                if (time <= 0) {
                    time = 0;
                }
                return time;
            } else if (this.pqT == null || this.pqS.epB().eoY().k() != null) {
                return 0L;
            } else {
                long time2 = (this.d != null ? this.d.getTime() : this.i) - this.pqT.getTime();
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
            return max + (this.j - this.i) + (this.f3946a - this.j);
        }

        private boolean e() {
            return this.pqS.epX().c() == -1 && this.pqU == null;
        }

        private static boolean a(ab abVar) {
            return (abVar.a("If-Modified-Since") == null && abVar.a("If-None-Match") == null) ? false : true;
        }
    }
}
