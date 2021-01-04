package com.bytedance.sdk.a.b.a.e;

import android.net.http.Headers;
import androidx.appcompat.widget.ActivityChooserView;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.mobstat.Config;
import com.bytedance.sdk.a.a.s;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpHost;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class d {
    static final c[] pjR = {new c(c.pjO, ""), new c(c.pjL, "GET"), new c(c.pjL, "POST"), new c(c.pjM, "/"), new c(c.pjM, "/index.html"), new c(c.pjN, HttpHost.DEFAULT_SCHEME_NAME), new c(c.pjN, "https"), new c(c.f6189b, BasicPushStatus.SUCCESS_CODE), new c(c.f6189b, "204"), new c(c.f6189b, "206"), new c(c.f6189b, "304"), new c(c.f6189b, "400"), new c(c.f6189b, "404"), new c(c.f6189b, "500"), new c("accept-charset", ""), new c("accept-encoding", "gzip, deflate"), new c("accept-language", ""), new c(Headers.ACCEPT_RANGES, ""), new c(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET, ""), new c("access-control-allow-origin", ""), new c("age", ""), new c("allow", ""), new c("authorization", ""), new c(Headers.CACHE_CONTROL, ""), new c(Headers.CONTENT_DISPOSITION, ""), new c(Headers.CONTENT_ENCODING, ""), new c("content-language", ""), new c(Headers.CONTENT_LEN, ""), new c("content-location", ""), new c("content-range", ""), new c(Headers.CONTENT_TYPE, ""), new c("cookie", ""), new c("date", ""), new c("etag", ""), new c("expect", ""), new c("expires", ""), new c("from", ""), new c("host", ""), new c("if-match", ""), new c("if-modified-since", ""), new c("if-none-match", ""), new c("if-range", ""), new c("if-unmodified-since", ""), new c(Headers.LAST_MODIFIED, ""), new c("link", ""), new c("location", ""), new c("max-forwards", ""), new c(Headers.PROXY_AUTHENTICATE, ""), new c("proxy-authorization", ""), new c("range", ""), new c(Config.LAUNCH_REFERER, ""), new c(Headers.REFRESH, ""), new c("retry-after", ""), new c("server", ""), new c(Headers.SET_COOKIE, ""), new c("strict-transport-security", ""), new c(Headers.TRANSFER_ENCODING, ""), new c("user-agent", ""), new c("vary", ""), new c("via", ""), new c(Headers.WWW_AUTHENTICATE, "")};

    /* renamed from: b  reason: collision with root package name */
    static final Map<com.bytedance.sdk.a.a.f, Integer> f6190b = a();

    /* loaded from: classes4.dex */
    static final class a {

        /* renamed from: b  reason: collision with root package name */
        int f6191b;
        int c;
        int d;
        private final List<c> e;
        private final int g;
        private int h;
        c[] pjR;
        private final com.bytedance.sdk.a.a.e pjS;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i, s sVar) {
            this(i, i, sVar);
        }

        a(int i, int i2, s sVar) {
            this.e = new ArrayList();
            this.pjR = new c[8];
            this.f6191b = this.pjR.length - 1;
            this.c = 0;
            this.d = 0;
            this.g = i;
            this.h = i2;
            this.pjS = com.bytedance.sdk.a.a.l.c(sVar);
        }

        private void d() {
            if (this.h < this.d) {
                if (this.h == 0) {
                    e();
                } else {
                    a(this.d - this.h);
                }
            }
        }

        private void e() {
            Arrays.fill(this.pjR, (Object) null);
            this.f6191b = this.pjR.length - 1;
            this.c = 0;
            this.d = 0;
        }

        private int a(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.pjR.length;
                while (true) {
                    length--;
                    if (length < this.f6191b || i <= 0) {
                        break;
                    }
                    i -= this.pjR[length].i;
                    this.d -= this.pjR[length].i;
                    this.c--;
                    i2++;
                }
                System.arraycopy(this.pjR, this.f6191b + 1, this.pjR, this.f6191b + 1 + i2, this.c);
                this.f6191b += i2;
            }
            return i2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() throws IOException {
            while (!this.pjS.e()) {
                int epV = this.pjS.epV() & 255;
                if (epV == 128) {
                    throw new IOException("index == 0");
                }
                if ((epV & 128) == 128) {
                    b(a(epV, 127) - 1);
                } else if (epV == 64) {
                    g();
                } else if ((epV & 64) == 64) {
                    e(a(epV, 63) - 1);
                } else if ((epV & 32) == 32) {
                    this.h = a(epV, 31);
                    if (this.h < 0 || this.h > this.g) {
                        throw new IOException("Invalid dynamic table size update " + this.h);
                    }
                    d();
                } else if (epV == 16 || epV == 0) {
                    f();
                } else {
                    d(a(epV, 15) - 1);
                }
            }
        }

        public List<c> b() {
            ArrayList arrayList = new ArrayList(this.e);
            this.e.clear();
            return arrayList;
        }

        private void b(int i) throws IOException {
            if (g(i)) {
                this.e.add(d.pjR[i]);
                return;
            }
            int c = c(i - d.pjR.length);
            if (c < 0 || c > this.pjR.length - 1) {
                throw new IOException("Header index too large " + (i + 1));
            }
            this.e.add(this.pjR[c]);
        }

        private int c(int i) {
            return this.f6191b + 1 + i;
        }

        private void d(int i) throws IOException {
            this.e.add(new c(PJ(i), c()));
        }

        private void f() throws IOException {
            this.e.add(new c(d.d(c()), c()));
        }

        private void e(int i) throws IOException {
            a(-1, new c(PJ(i), c()));
        }

        private void g() throws IOException {
            a(-1, new c(d.d(c()), c()));
        }

        private com.bytedance.sdk.a.a.f PJ(int i) {
            return g(i) ? d.pjR[i].pjP : this.pjR[c(i - d.pjR.length)].pjP;
        }

        private boolean g(int i) {
            return i >= 0 && i <= d.pjR.length + (-1);
        }

        private void a(int i, c cVar) {
            this.e.add(cVar);
            int i2 = cVar.i;
            if (i != -1) {
                i2 -= this.pjR[c(i)].i;
            }
            if (i2 > this.h) {
                e();
                return;
            }
            int a2 = a((this.d + i2) - this.h);
            if (i == -1) {
                if (this.c + 1 > this.pjR.length) {
                    c[] cVarArr = new c[this.pjR.length * 2];
                    System.arraycopy(this.pjR, 0, cVarArr, this.pjR.length, this.pjR.length);
                    this.f6191b = this.pjR.length - 1;
                    this.pjR = cVarArr;
                }
                int i3 = this.f6191b;
                this.f6191b = i3 - 1;
                this.pjR[i3] = cVar;
                this.c++;
            } else {
                this.pjR[a2 + c(i) + i] = cVar;
            }
            this.d = i2 + this.d;
        }

        private int h() throws IOException {
            return this.pjS.epV() & 255;
        }

        int a(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 >= i2) {
                int i4 = 0;
                while (true) {
                    int h = h();
                    if ((h & 128) != 0) {
                        i2 += (h & 127) << i4;
                        i4 += 7;
                    } else {
                        return (h << i4) + i2;
                    }
                }
            } else {
                return i3;
            }
        }

        com.bytedance.sdk.a.a.f c() throws IOException {
            int h = h();
            boolean z = (h & 128) == 128;
            int a2 = a(h, 127);
            if (z) {
                return com.bytedance.sdk.a.a.f.a(k.eqW().a(this.pjS.ih(a2)));
            }
            return this.pjS.mo47if(a2);
        }
    }

    private static Map<com.bytedance.sdk.a.a.f, Integer> a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(pjR.length);
        for (int i = 0; i < pjR.length; i++) {
            if (!linkedHashMap.containsKey(pjR[i].pjP)) {
                linkedHashMap.put(pjR[i].pjP, Integer.valueOf(i));
            }
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    /* loaded from: classes4.dex */
    static final class b {

        /* renamed from: a  reason: collision with root package name */
        int f6192a;

        /* renamed from: b  reason: collision with root package name */
        int f6193b;
        int d;
        int e;
        int f;
        private final boolean h;
        private int i;
        private boolean j;
        private final com.bytedance.sdk.a.a.c pjT;
        c[] pjU;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(com.bytedance.sdk.a.a.c cVar) {
            this(4096, true, cVar);
        }

        b(int i, boolean z, com.bytedance.sdk.a.a.c cVar) {
            this.i = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            this.pjU = new c[8];
            this.d = this.pjU.length - 1;
            this.e = 0;
            this.f = 0;
            this.f6192a = i;
            this.f6193b = i;
            this.h = z;
            this.pjT = cVar;
        }

        private void a() {
            Arrays.fill(this.pjU, (Object) null);
            this.d = this.pjU.length - 1;
            this.e = 0;
            this.f = 0;
        }

        private int b(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.pjU.length;
                while (true) {
                    length--;
                    if (length < this.d || i <= 0) {
                        break;
                    }
                    i -= this.pjU[length].i;
                    this.f -= this.pjU[length].i;
                    this.e--;
                    i2++;
                }
                System.arraycopy(this.pjU, this.d + 1, this.pjU, this.d + 1 + i2, this.e);
                Arrays.fill(this.pjU, this.d + 1, this.d + 1 + i2, (Object) null);
                this.d += i2;
            }
            return i2;
        }

        private void a(c cVar) {
            int i = cVar.i;
            if (i > this.f6193b) {
                a();
                return;
            }
            b((this.f + i) - this.f6193b);
            if (this.e + 1 > this.pjU.length) {
                c[] cVarArr = new c[this.pjU.length * 2];
                System.arraycopy(this.pjU, 0, cVarArr, this.pjU.length, this.pjU.length);
                this.d = this.pjU.length - 1;
                this.pjU = cVarArr;
            }
            int i2 = this.d;
            this.d = i2 - 1;
            this.pjU[i2] = cVar;
            this.e++;
            this.f = i + this.f;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(List<c> list) throws IOException {
            int i;
            int i2;
            if (this.j) {
                if (this.i < this.f6193b) {
                    a(this.i, 31, 32);
                }
                this.j = false;
                this.i = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                a(this.f6193b, 31, 32);
            }
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                c cVar = list.get(i3);
                com.bytedance.sdk.a.a.f f = cVar.pjP.f();
                com.bytedance.sdk.a.a.f fVar = cVar.pjQ;
                Integer num = d.f6190b.get(f);
                if (num != null) {
                    int intValue = num.intValue() + 1;
                    if (intValue > 1 && intValue < 8) {
                        if (com.bytedance.sdk.a.b.a.c.a(d.pjR[intValue - 1].pjQ, fVar)) {
                            i = intValue;
                            i2 = intValue;
                        } else if (com.bytedance.sdk.a.b.a.c.a(d.pjR[intValue].pjQ, fVar)) {
                            i2 = intValue + 1;
                            i = intValue;
                        }
                    }
                    i = intValue;
                    i2 = -1;
                } else {
                    i = -1;
                    i2 = -1;
                }
                if (i2 == -1) {
                    int i4 = this.d + 1;
                    int length = this.pjU.length;
                    while (true) {
                        if (i4 >= length) {
                            break;
                        }
                        if (com.bytedance.sdk.a.b.a.c.a(this.pjU[i4].pjP, f)) {
                            if (com.bytedance.sdk.a.b.a.c.a(this.pjU[i4].pjQ, fVar)) {
                                i2 = (i4 - this.d) + d.pjR.length;
                                break;
                            } else if (i == -1) {
                                i = (i4 - this.d) + d.pjR.length;
                            }
                        }
                        i4++;
                    }
                }
                if (i2 != -1) {
                    a(i2, 127, 128);
                } else if (i == -1) {
                    this.pjT.PM(64);
                    e(f);
                    e(fVar);
                    a(cVar);
                } else if (f.a(c.pjK) && !c.pjO.equals(f)) {
                    a(i, 15, 0);
                    e(fVar);
                } else {
                    a(i, 63, 64);
                    e(fVar);
                    a(cVar);
                }
            }
        }

        void a(int i, int i2, int i3) {
            if (i < i2) {
                this.pjT.PM(i3 | i);
                return;
            }
            this.pjT.PM(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.pjT.PM((i4 & 127) | 128);
                i4 >>>= 7;
            }
            this.pjT.PM(i4);
        }

        void e(com.bytedance.sdk.a.a.f fVar) throws IOException {
            if (this.h && k.eqW().f(fVar) < fVar.g()) {
                com.bytedance.sdk.a.a.c cVar = new com.bytedance.sdk.a.a.c();
                k.eqW().a(fVar, cVar);
                com.bytedance.sdk.a.a.f epY = cVar.epY();
                a(epY.g(), 127, 128);
                this.pjT.c(epY);
                return;
            }
            a(fVar.g(), 127, 0);
            this.pjT.c(fVar);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(int i) {
            this.f6192a = i;
            int min = Math.min(i, 16384);
            if (this.f6193b != min) {
                if (min < this.f6193b) {
                    this.i = Math.min(this.i, min);
                }
                this.j = true;
                this.f6193b = min;
                b();
            }
        }

        private void b() {
            if (this.f6193b < this.f) {
                if (this.f6193b == 0) {
                    a();
                } else {
                    b(this.f - this.f6193b);
                }
            }
        }
    }

    static com.bytedance.sdk.a.a.f d(com.bytedance.sdk.a.a.f fVar) throws IOException {
        int g = fVar.g();
        for (int i = 0; i < g; i++) {
            byte a2 = fVar.a(i);
            if (a2 >= 65 && a2 <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + fVar.a());
            }
        }
        return fVar;
    }
}
