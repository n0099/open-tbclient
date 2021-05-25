package com.bytedance.sdk.a.b;

import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.google.android.material.badge.BadgeDrawable;
import d.b.c.a.a.c;
import d.b.c.a.b.a.e;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.text.Typography;
/* loaded from: classes6.dex */
public final class s {

    /* renamed from: i  reason: collision with root package name */
    public static final char[] f26867i = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a  reason: collision with root package name */
    public final String f26868a;

    /* renamed from: b  reason: collision with root package name */
    public final String f26869b;

    /* renamed from: c  reason: collision with root package name */
    public final String f26870c;

    /* renamed from: d  reason: collision with root package name */
    public final String f26871d;

    /* renamed from: e  reason: collision with root package name */
    public final int f26872e;

    /* renamed from: f  reason: collision with root package name */
    public final List<String> f26873f;

    /* renamed from: g  reason: collision with root package name */
    public final String f26874g;

    /* renamed from: h  reason: collision with root package name */
    public final String f26875h;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public String f26876a;

        /* renamed from: d  reason: collision with root package name */
        public String f26879d;

        /* renamed from: f  reason: collision with root package name */
        public final List<String> f26881f;

        /* renamed from: g  reason: collision with root package name */
        public List<String> f26882g;

        /* renamed from: h  reason: collision with root package name */
        public String f26883h;

        /* renamed from: b  reason: collision with root package name */
        public String f26877b = "";

        /* renamed from: c  reason: collision with root package name */
        public String f26878c = "";

        /* renamed from: e  reason: collision with root package name */
        public int f26880e = -1;

        /* renamed from: com.bytedance.sdk.a.b.s$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public enum EnumC0281a {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public a() {
            ArrayList arrayList = new ArrayList();
            this.f26881f = arrayList;
            arrayList.add("");
        }

        public static int g(String str, int i2, int i3) {
            if (i3 - i2 < 2) {
                return -1;
            }
            char charAt = str.charAt(i2);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                while (true) {
                    i2++;
                    if (i2 >= i3) {
                        break;
                    }
                    char charAt2 = str.charAt(i2);
                    if (charAt2 < 'a' || charAt2 > 'z') {
                        if (charAt2 < 'A' || charAt2 > 'Z') {
                            if (charAt2 < '0' || charAt2 > '9') {
                                if (charAt2 != '+' && charAt2 != '-' && charAt2 != '.') {
                                    if (charAt2 == ':') {
                                        return i2;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        public static int j(String str, int i2, int i3) {
            int i4 = 0;
            while (i2 < i3) {
                char charAt = str.charAt(i2);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i4++;
                i2++;
            }
            return i4;
        }

        public static int m(String str, int i2, int i3) {
            while (i2 < i3) {
                char charAt = str.charAt(i2);
                if (charAt == ':') {
                    return i2;
                }
                if (charAt == '[') {
                    do {
                        i2++;
                        if (i2 < i3) {
                        }
                    } while (str.charAt(i2) != ']');
                }
                i2++;
            }
            return i3;
        }

        public static String q(String str, int i2, int i3) {
            return e.i(s.d(str, i2, i3, false));
        }

        public static int r(String str, int i2, int i3) {
            int parseInt;
            try {
                parseInt = Integer.parseInt(s.c(str, i2, i3, "", false, false, false, true, null));
            } catch (NumberFormatException unused) {
            }
            if (parseInt <= 0 || parseInt > 65535) {
                return -1;
            }
            return parseInt;
        }

        public int a() {
            int i2 = this.f26880e;
            return i2 != -1 ? i2 : s.a(this.f26876a);
        }

        public EnumC0281a b(s sVar, String str) {
            int d2;
            int i2;
            int b2 = e.b(str, 0, str.length());
            int z = e.z(str, b2, str.length());
            if (g(str, b2, z) != -1) {
                if (str.regionMatches(true, b2, UrlSchemaHelper.SCHEMA_TYPE_HTTPS, 0, 6)) {
                    this.f26876a = "https";
                    b2 += 6;
                } else if (str.regionMatches(true, b2, UrlSchemaHelper.SCHEMA_TYPE_HTTP, 0, 5)) {
                    this.f26876a = "http";
                    b2 += 5;
                } else {
                    return EnumC0281a.UNSUPPORTED_SCHEME;
                }
            } else if (sVar != null) {
                this.f26876a = sVar.f26868a;
            } else {
                return EnumC0281a.MISSING_SCHEME;
            }
            int j = j(str, b2, z);
            char c2 = '?';
            char c3 = '#';
            if (j < 2 && sVar != null && sVar.f26868a.equals(this.f26876a)) {
                this.f26877b = sVar.s();
                this.f26878c = sVar.u();
                this.f26879d = sVar.f26871d;
                this.f26880e = sVar.f26872e;
                this.f26881f.clear();
                this.f26881f.addAll(sVar.y());
                if (b2 == z || str.charAt(b2) == '#') {
                    p(sVar.z());
                }
            } else {
                int i3 = b2 + j;
                boolean z2 = false;
                boolean z3 = false;
                while (true) {
                    d2 = e.d(str, i3, z, "@/\\?#");
                    char charAt = d2 != z ? str.charAt(d2) : (char) 65535;
                    if (charAt == 65535 || charAt == c3 || charAt == '/' || charAt == '\\' || charAt == c2) {
                        break;
                    }
                    if (charAt == '@') {
                        if (!z2) {
                            int c4 = e.c(str, i3, d2, ':');
                            i2 = d2;
                            String c5 = s.c(str, i3, c4, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z3) {
                                c5 = this.f26877b + "%40" + c5;
                            }
                            this.f26877b = c5;
                            if (c4 != i2) {
                                this.f26878c = s.c(str, c4 + 1, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z2 = true;
                            }
                            z3 = true;
                        } else {
                            i2 = d2;
                            this.f26878c += "%40" + s.c(str, i3, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        }
                        i3 = i2 + 1;
                    }
                    c2 = '?';
                    c3 = '#';
                }
                int m = m(str, i3, d2);
                int i4 = m + 1;
                if (i4 < d2) {
                    this.f26879d = q(str, i3, m);
                    int r = r(str, i4, d2);
                    this.f26880e = r;
                    if (r == -1) {
                        return EnumC0281a.INVALID_PORT;
                    }
                } else {
                    this.f26879d = q(str, i3, m);
                    this.f26880e = s.a(this.f26876a);
                }
                if (this.f26879d == null) {
                    return EnumC0281a.INVALID_HOST;
                }
                b2 = d2;
            }
            int d3 = e.d(str, b2, z, "?#");
            e(str, b2, d3);
            if (d3 < z && str.charAt(d3) == '?') {
                int c6 = e.c(str, d3, z, '#');
                this.f26882g = s.n(s.c(str, d3 + 1, c6, " \"'<>#", true, false, true, true, null));
                d3 = c6;
            }
            if (d3 < z && str.charAt(d3) == '#') {
                this.f26883h = s.c(str, 1 + d3, z, "", true, false, false, false, null);
            }
            return EnumC0281a.SUCCESS;
        }

        public a c(int i2) {
            if (i2 > 0 && i2 <= 65535) {
                this.f26880e = i2;
                return this;
            }
            throw new IllegalArgumentException("unexpected port: " + i2);
        }

        public a d(String str) {
            if (str != null) {
                if (str.equalsIgnoreCase("http")) {
                    this.f26876a = "http";
                } else if (str.equalsIgnoreCase("https")) {
                    this.f26876a = "https";
                } else {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
                return this;
            }
            throw new NullPointerException("scheme == null");
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
            */
        /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0044 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0041 -> B:11:0x0029). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void e(java.lang.String r11, int r12, int r13) {
            /*
                r10 = this;
                if (r12 != r13) goto L3
                return
            L3:
                char r0 = r11.charAt(r12)
                r1 = 47
                java.lang.String r2 = ""
                r3 = 1
                if (r0 == r1) goto L1e
                r1 = 92
                if (r0 != r1) goto L13
                goto L1e
            L13:
                java.util.List<java.lang.String> r0 = r10.f26881f
                int r1 = r0.size()
                int r1 = r1 - r3
                r0.set(r1, r2)
                goto L29
            L1e:
                java.util.List<java.lang.String> r0 = r10.f26881f
                r0.clear()
                java.util.List<java.lang.String> r0 = r10.f26881f
                r0.add(r2)
                goto L41
            L29:
                r6 = r12
                if (r6 >= r13) goto L44
                java.lang.String r12 = "/\\"
                int r12 = d.b.c.a.b.a.e.d(r11, r6, r13, r12)
                if (r12 >= r13) goto L36
                r0 = 1
                goto L37
            L36:
                r0 = 0
            L37:
                r9 = 1
                r4 = r10
                r5 = r11
                r7 = r12
                r8 = r0
                r4.f(r5, r6, r7, r8, r9)
                if (r0 == 0) goto L29
            L41:
                int r12 = r12 + 1
                goto L29
            L44:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.a.b.s.a.e(java.lang.String, int, int):void");
        }

        public final void f(String str, int i2, int i3, boolean z, boolean z2) {
            String c2 = s.c(str, i2, i3, " \"<>^`{}|/\\?#", z2, false, false, true, null);
            if (s(c2)) {
                return;
            }
            if (t(c2)) {
                o();
                return;
            }
            List<String> list = this.f26881f;
            if (list.get(list.size() - 1).isEmpty()) {
                List<String> list2 = this.f26881f;
                list2.set(list2.size() - 1, c2);
            } else {
                this.f26881f.add(c2);
            }
            if (z) {
                this.f26881f.add("");
            }
        }

        public a h() {
            int size = this.f26881f.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f26881f.set(i2, s.e(this.f26881f.get(i2), "[]", true, true, false, true));
            }
            List<String> list = this.f26882g;
            if (list != null) {
                int size2 = list.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    String str = this.f26882g.get(i3);
                    if (str != null) {
                        this.f26882g.set(i3, s.e(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            String str2 = this.f26883h;
            if (str2 != null) {
                this.f26883h = s.e(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        public a i(String str) {
            if (str != null) {
                this.f26877b = s.e(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("username == null");
        }

        public a k(String str) {
            if (str != null) {
                this.f26878c = s.e(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("password == null");
        }

        public s l() {
            if (this.f26876a != null) {
                if (this.f26879d != null) {
                    return new s(this);
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        public a n(String str) {
            if (str != null) {
                String q = q(str, 0, str.length());
                if (q != null) {
                    this.f26879d = q;
                    return this;
                }
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            throw new NullPointerException("host == null");
        }

        public final void o() {
            List<String> list = this.f26881f;
            if (list.remove(list.size() - 1).isEmpty() && !this.f26881f.isEmpty()) {
                List<String> list2 = this.f26881f;
                list2.set(list2.size() - 1, "");
                return;
            }
            this.f26881f.add("");
        }

        public a p(String str) {
            this.f26882g = str != null ? s.n(s.e(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        public final boolean s(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        public final boolean t(String str) {
            return str.equals(IStringUtil.TOP_PATH) || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f26876a);
            sb.append("://");
            if (!this.f26877b.isEmpty() || !this.f26878c.isEmpty()) {
                sb.append(this.f26877b);
                if (!this.f26878c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f26878c);
                }
                sb.append('@');
            }
            if (this.f26879d.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.f26879d);
                sb.append(']');
            } else {
                sb.append(this.f26879d);
            }
            int a2 = a();
            if (a2 != s.a(this.f26876a)) {
                sb.append(':');
                sb.append(a2);
            }
            s.k(sb, this.f26881f);
            if (this.f26882g != null) {
                sb.append('?');
                s.o(sb, this.f26882g);
            }
            if (this.f26883h != null) {
                sb.append('#');
                sb.append(this.f26883h);
            }
            return sb.toString();
        }
    }

    public s(a aVar) {
        this.f26868a = aVar.f26876a;
        this.f26869b = f(aVar.f26877b, false);
        this.f26870c = f(aVar.f26878c, false);
        this.f26871d = aVar.f26879d;
        this.f26872e = aVar.a();
        h(aVar.f26881f, false);
        List<String> list = aVar.f26882g;
        this.f26873f = list != null ? h(list, true) : null;
        String str = aVar.f26883h;
        this.f26874g = str != null ? f(str, false) : null;
        this.f26875h = aVar.toString();
    }

    public static int a(String str) {
        if (str.equals("http")) {
            return 80;
        }
        if (str.equals("https")) {
            return Constants.SOCKET_PORT_SSL;
        }
        return -1;
    }

    public static s b(URL url) {
        return t(url.toString());
    }

    public static String c(String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        int i4 = i2;
        while (i4 < i3) {
            int codePointAt = str.codePointAt(i4);
            if (codePointAt >= 32 && codePointAt != 127 && (codePointAt < 128 || !z4)) {
                if (str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z && (!z2 || l(str, i4, i3)))) && (codePointAt != 43 || !z3))) {
                    i4 += Character.charCount(codePointAt);
                }
            }
            c cVar = new c();
            cVar.q(str, i2, i4);
            i(cVar, str, i4, i3, str2, z, z2, z3, z4, charset);
            return cVar.J();
        }
        return str.substring(i2, i3);
    }

    public static String d(String str, int i2, int i3, boolean z) {
        for (int i4 = i2; i4 < i3; i4++) {
            char charAt = str.charAt(i4);
            if (charAt == '%' || (charAt == '+' && z)) {
                c cVar = new c();
                cVar.q(str, i2, i4);
                j(cVar, str, i4, i3, z);
                return cVar.J();
            }
        }
        return str.substring(i2, i3);
    }

    public static String e(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return c(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }

    public static String f(String str, boolean z) {
        return d(str, 0, str.length(), z);
    }

    public static void i(c cVar, String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        c cVar2 = null;
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (!z || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt == 43 && z3) {
                    cVar.p(z ? BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX : "%2B");
                } else if (codePointAt >= 32 && codePointAt != 127 && ((codePointAt < 128 || !z4) && str2.indexOf(codePointAt) == -1 && (codePointAt != 37 || (z && (!z2 || l(str, i2, i3)))))) {
                    cVar.m(codePointAt);
                } else {
                    if (cVar2 == null) {
                        cVar2 = new c();
                    }
                    if (charset != null && !charset.equals(e.j)) {
                        cVar2.r(str, i2, Character.charCount(codePointAt) + i2, charset);
                    } else {
                        cVar2.m(codePointAt);
                    }
                    while (!cVar2.e()) {
                        int h2 = cVar2.h() & 255;
                        cVar.w(37);
                        cVar.w(f26867i[(h2 >> 4) & 15]);
                        cVar.w(f26867i[h2 & 15]);
                    }
                }
            }
            i2 += Character.charCount(codePointAt);
        }
    }

    public static void j(c cVar, String str, int i2, int i3, boolean z) {
        int i4;
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (codePointAt == 37 && (i4 = i2 + 2) < i3) {
                int a2 = e.a(str.charAt(i2 + 1));
                int a3 = e.a(str.charAt(i4));
                if (a2 != -1 && a3 != -1) {
                    cVar.w((a2 << 4) + a3);
                    i2 = i4;
                }
                cVar.m(codePointAt);
            } else {
                if (codePointAt == 43 && z) {
                    cVar.w(32);
                }
                cVar.m(codePointAt);
            }
            i2 += Character.charCount(codePointAt);
        }
    }

    public static void k(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append('/');
            sb.append(list.get(i2));
        }
    }

    public static boolean l(String str, int i2, int i3) {
        int i4 = i2 + 2;
        return i4 < i3 && str.charAt(i2) == '%' && e.a(str.charAt(i2 + 1)) != -1 && e.a(str.charAt(i4)) != -1;
    }

    public static List<String> n(String str) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 <= str.length()) {
            int indexOf = str.indexOf(38, i2);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i2);
            if (indexOf2 != -1 && indexOf2 <= indexOf) {
                arrayList.add(str.substring(i2, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            } else {
                arrayList.add(str.substring(i2, indexOf));
                arrayList.add(null);
            }
            i2 = indexOf + 1;
        }
        return arrayList;
    }

    public static void o(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            String str = list.get(i2);
            String str2 = list.get(i2 + 1);
            if (i2 > 0) {
                sb.append(Typography.amp);
            }
            sb.append(str);
            if (str2 != null) {
                sb.append(com.alipay.sdk.encrypt.a.f1873h);
                sb.append(str2);
            }
        }
    }

    public static s t(String str) {
        a aVar = new a();
        if (aVar.b(null, str) == a.EnumC0281a.SUCCESS) {
            return aVar.l();
        }
        return null;
    }

    public String A() {
        if (this.f26873f == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        o(sb, this.f26873f);
        return sb.toString();
    }

    public String B() {
        if (this.f26874g == null) {
            return null;
        }
        return this.f26875h.substring(this.f26875h.indexOf(35) + 1);
    }

    public String C() {
        a r = r("/...");
        r.i("");
        r.k("");
        return r.l().toString();
    }

    public a D() {
        a aVar = new a();
        aVar.f26876a = this.f26868a;
        aVar.f26877b = s();
        aVar.f26878c = u();
        aVar.f26879d = this.f26871d;
        aVar.f26880e = this.f26872e != a(this.f26868a) ? this.f26872e : -1;
        aVar.f26881f.clear();
        aVar.f26881f.addAll(y());
        aVar.p(z());
        aVar.f26883h = B();
        return aVar;
    }

    public boolean equals(Object obj) {
        return (obj instanceof s) && ((s) obj).f26875h.equals(this.f26875h);
    }

    public URI g() {
        a D = D();
        D.h();
        String aVar = D.toString();
        try {
            return new URI(aVar);
        } catch (URISyntaxException e2) {
            try {
                return URI.create(aVar.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e2);
            }
        }
    }

    public final List<String> h(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            String str = list.get(i2);
            arrayList.add(str != null ? f(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public int hashCode() {
        return this.f26875h.hashCode();
    }

    public String m() {
        return this.f26868a;
    }

    public s p(String str) {
        a r = r(str);
        if (r != null) {
            return r.l();
        }
        return null;
    }

    public boolean q() {
        return this.f26868a.equals("https");
    }

    public a r(String str) {
        a aVar = new a();
        if (aVar.b(this, str) == a.EnumC0281a.SUCCESS) {
            return aVar;
        }
        return null;
    }

    public String s() {
        if (this.f26869b.isEmpty()) {
            return "";
        }
        int length = this.f26868a.length() + 3;
        String str = this.f26875h;
        return this.f26875h.substring(length, e.d(str, length, str.length(), ":@"));
    }

    public String toString() {
        return this.f26875h;
    }

    public String u() {
        if (this.f26870c.isEmpty()) {
            return "";
        }
        int indexOf = this.f26875h.indexOf(64);
        return this.f26875h.substring(this.f26875h.indexOf(58, this.f26868a.length() + 3) + 1, indexOf);
    }

    public String v() {
        return this.f26871d;
    }

    public int w() {
        return this.f26872e;
    }

    public String x() {
        int indexOf = this.f26875h.indexOf(47, this.f26868a.length() + 3);
        String str = this.f26875h;
        return this.f26875h.substring(indexOf, e.d(str, indexOf, str.length(), "?#"));
    }

    public List<String> y() {
        int indexOf = this.f26875h.indexOf(47, this.f26868a.length() + 3);
        String str = this.f26875h;
        int d2 = e.d(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < d2) {
            int i2 = indexOf + 1;
            int c2 = e.c(this.f26875h, i2, d2, '/');
            arrayList.add(this.f26875h.substring(i2, c2));
            indexOf = c2;
        }
        return arrayList;
    }

    public String z() {
        if (this.f26873f == null) {
            return null;
        }
        int indexOf = this.f26875h.indexOf(63) + 1;
        String str = this.f26875h;
        return this.f26875h.substring(indexOf, e.c(str, indexOf, str.length(), '#'));
    }
}
