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
    static final c[] pfm = {new c(c.pfj, ""), new c(c.pfg, "GET"), new c(c.pfg, "POST"), new c(c.pfh, "/"), new c(c.pfh, "/index.html"), new c(c.pfi, HttpHost.DEFAULT_SCHEME_NAME), new c(c.pfi, "https"), new c(c.f5890b, BasicPushStatus.SUCCESS_CODE), new c(c.f5890b, "204"), new c(c.f5890b, "206"), new c(c.f5890b, "304"), new c(c.f5890b, "400"), new c(c.f5890b, "404"), new c(c.f5890b, "500"), new c("accept-charset", ""), new c("accept-encoding", "gzip, deflate"), new c("accept-language", ""), new c(Headers.ACCEPT_RANGES, ""), new c(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET, ""), new c("access-control-allow-origin", ""), new c("age", ""), new c("allow", ""), new c("authorization", ""), new c(Headers.CACHE_CONTROL, ""), new c(Headers.CONTENT_DISPOSITION, ""), new c(Headers.CONTENT_ENCODING, ""), new c("content-language", ""), new c(Headers.CONTENT_LEN, ""), new c("content-location", ""), new c("content-range", ""), new c(Headers.CONTENT_TYPE, ""), new c("cookie", ""), new c("date", ""), new c("etag", ""), new c("expect", ""), new c("expires", ""), new c("from", ""), new c("host", ""), new c("if-match", ""), new c("if-modified-since", ""), new c("if-none-match", ""), new c("if-range", ""), new c("if-unmodified-since", ""), new c(Headers.LAST_MODIFIED, ""), new c("link", ""), new c(Headers.LOCATION, ""), new c("max-forwards", ""), new c(Headers.PROXY_AUTHENTICATE, ""), new c("proxy-authorization", ""), new c("range", ""), new c(Config.LAUNCH_REFERER, ""), new c(Headers.REFRESH, ""), new c("retry-after", ""), new c("server", ""), new c(Headers.SET_COOKIE, ""), new c("strict-transport-security", ""), new c(Headers.TRANSFER_ENCODING, ""), new c("user-agent", ""), new c("vary", ""), new c("via", ""), new c(Headers.WWW_AUTHENTICATE, "")};

    /* renamed from: b  reason: collision with root package name */
    static final Map<com.bytedance.sdk.a.a.f, Integer> f5891b = a();

    /* loaded from: classes4.dex */
    static final class a {

        /* renamed from: b  reason: collision with root package name */
        int f5892b;
        int c;
        int d;
        private final List<c> e;
        private final int g;
        private int h;
        c[] pfm;
        private final com.bytedance.sdk.a.a.e pfn;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i, s sVar) {
            this(i, i, sVar);
        }

        a(int i, int i2, s sVar) {
            this.e = new ArrayList();
            this.pfm = new c[8];
            this.f5892b = this.pfm.length - 1;
            this.c = 0;
            this.d = 0;
            this.g = i;
            this.h = i2;
            this.pfn = com.bytedance.sdk.a.a.l.c(sVar);
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
            Arrays.fill(this.pfm, (Object) null);
            this.f5892b = this.pfm.length - 1;
            this.c = 0;
            this.d = 0;
        }

        private int a(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.pfm.length;
                while (true) {
                    length--;
                    if (length < this.f5892b || i <= 0) {
                        break;
                    }
                    i -= this.pfm[length].i;
                    this.d -= this.pfm[length].i;
                    this.c--;
                    i2++;
                }
                System.arraycopy(this.pfm, this.f5892b + 1, this.pfm, this.f5892b + 1 + i2, this.c);
                this.f5892b += i2;
            }
            return i2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() throws IOException {
            while (!this.pfn.e()) {
                int ema = this.pfn.ema() & 255;
                if (ema == 128) {
                    throw new IOException("index == 0");
                }
                if ((ema & 128) == 128) {
                    b(a(ema, 127) - 1);
                } else if (ema == 64) {
                    g();
                } else if ((ema & 64) == 64) {
                    e(a(ema, 63) - 1);
                } else if ((ema & 32) == 32) {
                    this.h = a(ema, 31);
                    if (this.h < 0 || this.h > this.g) {
                        throw new IOException("Invalid dynamic table size update " + this.h);
                    }
                    d();
                } else if (ema == 16 || ema == 0) {
                    f();
                } else {
                    d(a(ema, 15) - 1);
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
                this.e.add(d.pfm[i]);
                return;
            }
            int c = c(i - d.pfm.length);
            if (c < 0 || c > this.pfm.length - 1) {
                throw new IOException("Header index too large " + (i + 1));
            }
            this.e.add(this.pfm[c]);
        }

        private int c(int i) {
            return this.f5892b + 1 + i;
        }

        private void d(int i) throws IOException {
            this.e.add(new c(Oc(i), c()));
        }

        private void f() throws IOException {
            this.e.add(new c(d.d(c()), c()));
        }

        private void e(int i) throws IOException {
            a(-1, new c(Oc(i), c()));
        }

        private void g() throws IOException {
            a(-1, new c(d.d(c()), c()));
        }

        private com.bytedance.sdk.a.a.f Oc(int i) {
            return g(i) ? d.pfm[i].pfk : this.pfm[c(i - d.pfm.length)].pfk;
        }

        private boolean g(int i) {
            return i >= 0 && i <= d.pfm.length + (-1);
        }

        private void a(int i, c cVar) {
            this.e.add(cVar);
            int i2 = cVar.i;
            if (i != -1) {
                i2 -= this.pfm[c(i)].i;
            }
            if (i2 > this.h) {
                e();
                return;
            }
            int a2 = a((this.d + i2) - this.h);
            if (i == -1) {
                if (this.c + 1 > this.pfm.length) {
                    c[] cVarArr = new c[this.pfm.length * 2];
                    System.arraycopy(this.pfm, 0, cVarArr, this.pfm.length, this.pfm.length);
                    this.f5892b = this.pfm.length - 1;
                    this.pfm = cVarArr;
                }
                int i3 = this.f5892b;
                this.f5892b = i3 - 1;
                this.pfm[i3] = cVar;
                this.c++;
            } else {
                this.pfm[a2 + c(i) + i] = cVar;
            }
            this.d = i2 + this.d;
        }

        private int h() throws IOException {
            return this.pfn.ema() & 255;
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
                return com.bytedance.sdk.a.a.f.a(k.enb().a(this.pfn.ih(a2)));
            }
            return this.pfn.mo54if(a2);
        }
    }

    private static Map<com.bytedance.sdk.a.a.f, Integer> a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(pfm.length);
        for (int i = 0; i < pfm.length; i++) {
            if (!linkedHashMap.containsKey(pfm[i].pfk)) {
                linkedHashMap.put(pfm[i].pfk, Integer.valueOf(i));
            }
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    /* loaded from: classes4.dex */
    static final class b {

        /* renamed from: a  reason: collision with root package name */
        int f5893a;

        /* renamed from: b  reason: collision with root package name */
        int f5894b;
        int d;
        int e;
        int f;
        private final boolean h;
        private int i;
        private boolean j;
        private final com.bytedance.sdk.a.a.c pfo;
        c[] pfp;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(com.bytedance.sdk.a.a.c cVar) {
            this(4096, true, cVar);
        }

        b(int i, boolean z, com.bytedance.sdk.a.a.c cVar) {
            this.i = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            this.pfp = new c[8];
            this.d = this.pfp.length - 1;
            this.e = 0;
            this.f = 0;
            this.f5893a = i;
            this.f5894b = i;
            this.h = z;
            this.pfo = cVar;
        }

        private void a() {
            Arrays.fill(this.pfp, (Object) null);
            this.d = this.pfp.length - 1;
            this.e = 0;
            this.f = 0;
        }

        private int b(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.pfp.length;
                while (true) {
                    length--;
                    if (length < this.d || i <= 0) {
                        break;
                    }
                    i -= this.pfp[length].i;
                    this.f -= this.pfp[length].i;
                    this.e--;
                    i2++;
                }
                System.arraycopy(this.pfp, this.d + 1, this.pfp, this.d + 1 + i2, this.e);
                Arrays.fill(this.pfp, this.d + 1, this.d + 1 + i2, (Object) null);
                this.d += i2;
            }
            return i2;
        }

        private void a(c cVar) {
            int i = cVar.i;
            if (i > this.f5894b) {
                a();
                return;
            }
            b((this.f + i) - this.f5894b);
            if (this.e + 1 > this.pfp.length) {
                c[] cVarArr = new c[this.pfp.length * 2];
                System.arraycopy(this.pfp, 0, cVarArr, this.pfp.length, this.pfp.length);
                this.d = this.pfp.length - 1;
                this.pfp = cVarArr;
            }
            int i2 = this.d;
            this.d = i2 - 1;
            this.pfp[i2] = cVar;
            this.e++;
            this.f = i + this.f;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(List<c> list) throws IOException {
            int i;
            int i2;
            if (this.j) {
                if (this.i < this.f5894b) {
                    a(this.i, 31, 32);
                }
                this.j = false;
                this.i = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                a(this.f5894b, 31, 32);
            }
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                c cVar = list.get(i3);
                com.bytedance.sdk.a.a.f f = cVar.pfk.f();
                com.bytedance.sdk.a.a.f fVar = cVar.pfl;
                Integer num = d.f5891b.get(f);
                if (num != null) {
                    int intValue = num.intValue() + 1;
                    if (intValue > 1 && intValue < 8) {
                        if (com.bytedance.sdk.a.b.a.c.a(d.pfm[intValue - 1].pfl, fVar)) {
                            i = intValue;
                            i2 = intValue;
                        } else if (com.bytedance.sdk.a.b.a.c.a(d.pfm[intValue].pfl, fVar)) {
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
                    int length = this.pfp.length;
                    while (true) {
                        if (i4 >= length) {
                            break;
                        }
                        if (com.bytedance.sdk.a.b.a.c.a(this.pfp[i4].pfk, f)) {
                            if (com.bytedance.sdk.a.b.a.c.a(this.pfp[i4].pfl, fVar)) {
                                i2 = (i4 - this.d) + d.pfm.length;
                                break;
                            } else if (i == -1) {
                                i = (i4 - this.d) + d.pfm.length;
                            }
                        }
                        i4++;
                    }
                }
                if (i2 != -1) {
                    a(i2, 127, 128);
                } else if (i == -1) {
                    this.pfo.Of(64);
                    e(f);
                    e(fVar);
                    a(cVar);
                } else if (f.a(c.pff) && !c.pfj.equals(f)) {
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
                this.pfo.Of(i3 | i);
                return;
            }
            this.pfo.Of(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.pfo.Of((i4 & 127) | 128);
                i4 >>>= 7;
            }
            this.pfo.Of(i4);
        }

        void e(com.bytedance.sdk.a.a.f fVar) throws IOException {
            if (this.h && k.enb().f(fVar) < fVar.g()) {
                com.bytedance.sdk.a.a.c cVar = new com.bytedance.sdk.a.a.c();
                k.enb().a(fVar, cVar);
                com.bytedance.sdk.a.a.f emd = cVar.emd();
                a(emd.g(), 127, 128);
                this.pfo.c(emd);
                return;
            }
            a(fVar.g(), 127, 0);
            this.pfo.c(fVar);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(int i) {
            this.f5893a = i;
            int min = Math.min(i, 16384);
            if (this.f5894b != min) {
                if (min < this.f5894b) {
                    this.i = Math.min(this.i, min);
                }
                this.j = true;
                this.f5894b = min;
                b();
            }
        }

        private void b() {
            if (this.f5894b < this.f) {
                if (this.f5894b == 0) {
                    a();
                } else {
                    b(this.f - this.f5894b);
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
