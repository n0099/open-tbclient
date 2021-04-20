package com.bytedance.sdk.a.b;

import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.model.SwanTaskDeadEvent;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import d.c.c.a.a.c;
import d.c.c.a.b.a.e;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.text.Typography;
/* loaded from: classes5.dex */
public final class s {
    public static final char[] i = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a  reason: collision with root package name */
    public final String f26871a;

    /* renamed from: b  reason: collision with root package name */
    public final String f26872b;

    /* renamed from: c  reason: collision with root package name */
    public final String f26873c;

    /* renamed from: d  reason: collision with root package name */
    public final String f26874d;

    /* renamed from: e  reason: collision with root package name */
    public final int f26875e;

    /* renamed from: f  reason: collision with root package name */
    public final List<String> f26876f;

    /* renamed from: g  reason: collision with root package name */
    public final String f26877g;

    /* renamed from: h  reason: collision with root package name */
    public final String f26878h;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public String f26879a;

        /* renamed from: d  reason: collision with root package name */
        public String f26882d;

        /* renamed from: f  reason: collision with root package name */
        public final List<String> f26884f;

        /* renamed from: g  reason: collision with root package name */
        public List<String> f26885g;

        /* renamed from: h  reason: collision with root package name */
        public String f26886h;

        /* renamed from: b  reason: collision with root package name */
        public String f26880b = "";

        /* renamed from: c  reason: collision with root package name */
        public String f26881c = "";

        /* renamed from: e  reason: collision with root package name */
        public int f26883e = -1;

        /* renamed from: com.bytedance.sdk.a.b.s$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public enum EnumC0298a {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public a() {
            ArrayList arrayList = new ArrayList();
            this.f26884f = arrayList;
            arrayList.add("");
        }

        public static int g(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char charAt = str.charAt(i);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                while (true) {
                    i++;
                    if (i >= i2) {
                        break;
                    }
                    char charAt2 = str.charAt(i);
                    if (charAt2 < 'a' || charAt2 > 'z') {
                        if (charAt2 < 'A' || charAt2 > 'Z') {
                            if (charAt2 < '0' || charAt2 > '9') {
                                if (charAt2 != '+' && charAt2 != '-' && charAt2 != '.') {
                                    if (charAt2 == ':') {
                                        return i;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        public static int j(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        public static int m(String str, int i, int i2) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt == ':') {
                    return i;
                }
                if (charAt == '[') {
                    do {
                        i++;
                        if (i < i2) {
                        }
                    } while (str.charAt(i) != ']');
                }
                i++;
            }
            return i2;
        }

        public static String q(String str, int i, int i2) {
            return e.i(s.d(str, i, i2, false));
        }

        public static int r(String str, int i, int i2) {
            int parseInt;
            try {
                parseInt = Integer.parseInt(s.c(str, i, i2, "", false, false, false, true, null));
            } catch (NumberFormatException unused) {
            }
            if (parseInt <= 0 || parseInt > 65535) {
                return -1;
            }
            return parseInt;
        }

        public int a() {
            int i = this.f26883e;
            return i != -1 ? i : s.a(this.f26879a);
        }

        public EnumC0298a b(s sVar, String str) {
            int d2;
            int i;
            int b2 = e.b(str, 0, str.length());
            int z = e.z(str, b2, str.length());
            if (g(str, b2, z) != -1) {
                if (str.regionMatches(true, b2, UrlSchemaHelper.SCHEMA_TYPE_HTTPS, 0, 6)) {
                    this.f26879a = "https";
                    b2 += 6;
                } else if (str.regionMatches(true, b2, UrlSchemaHelper.SCHEMA_TYPE_HTTP, 0, 5)) {
                    this.f26879a = "http";
                    b2 += 5;
                } else {
                    return EnumC0298a.UNSUPPORTED_SCHEME;
                }
            } else if (sVar != null) {
                this.f26879a = sVar.f26871a;
            } else {
                return EnumC0298a.MISSING_SCHEME;
            }
            int j = j(str, b2, z);
            char c2 = '?';
            char c3 = SwanTaskDeadEvent.SEPARATOR;
            if (j < 2 && sVar != null && sVar.f26871a.equals(this.f26879a)) {
                this.f26880b = sVar.s();
                this.f26881c = sVar.u();
                this.f26882d = sVar.f26874d;
                this.f26883e = sVar.f26875e;
                this.f26884f.clear();
                this.f26884f.addAll(sVar.y());
                if (b2 == z || str.charAt(b2) == '#') {
                    p(sVar.z());
                }
            } else {
                int i2 = b2 + j;
                boolean z2 = false;
                boolean z3 = false;
                while (true) {
                    d2 = e.d(str, i2, z, "@/\\?#");
                    char charAt = d2 != z ? str.charAt(d2) : (char) 65535;
                    if (charAt == 65535 || charAt == c3 || charAt == '/' || charAt == '\\' || charAt == c2) {
                        break;
                    }
                    if (charAt == '@') {
                        if (!z2) {
                            int c4 = e.c(str, i2, d2, ':');
                            i = d2;
                            String c5 = s.c(str, i2, c4, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z3) {
                                c5 = this.f26880b + "%40" + c5;
                            }
                            this.f26880b = c5;
                            if (c4 != i) {
                                this.f26881c = s.c(str, c4 + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z2 = true;
                            }
                            z3 = true;
                        } else {
                            i = d2;
                            this.f26881c += "%40" + s.c(str, i2, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        }
                        i2 = i + 1;
                    }
                    c2 = '?';
                    c3 = SwanTaskDeadEvent.SEPARATOR;
                }
                int m = m(str, i2, d2);
                int i3 = m + 1;
                if (i3 < d2) {
                    this.f26882d = q(str, i2, m);
                    int r = r(str, i3, d2);
                    this.f26883e = r;
                    if (r == -1) {
                        return EnumC0298a.INVALID_PORT;
                    }
                } else {
                    this.f26882d = q(str, i2, m);
                    this.f26883e = s.a(this.f26879a);
                }
                if (this.f26882d == null) {
                    return EnumC0298a.INVALID_HOST;
                }
                b2 = d2;
            }
            int d3 = e.d(str, b2, z, "?#");
            e(str, b2, d3);
            if (d3 < z && str.charAt(d3) == '?') {
                int c6 = e.c(str, d3, z, SwanTaskDeadEvent.SEPARATOR);
                this.f26885g = s.n(s.c(str, d3 + 1, c6, " \"'<>#", true, false, true, true, null));
                d3 = c6;
            }
            if (d3 < z && str.charAt(d3) == '#') {
                this.f26886h = s.c(str, 1 + d3, z, "", true, false, false, false, null);
            }
            return EnumC0298a.SUCCESS;
        }

        public a c(int i) {
            if (i > 0 && i <= 65535) {
                this.f26883e = i;
                return this;
            }
            throw new IllegalArgumentException("unexpected port: " + i);
        }

        public a d(String str) {
            if (str != null) {
                if (str.equalsIgnoreCase("http")) {
                    this.f26879a = "http";
                } else if (str.equalsIgnoreCase("https")) {
                    this.f26879a = "https";
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
                java.util.List<java.lang.String> r0 = r10.f26884f
                int r1 = r0.size()
                int r1 = r1 - r3
                r0.set(r1, r2)
                goto L29
            L1e:
                java.util.List<java.lang.String> r0 = r10.f26884f
                r0.clear()
                java.util.List<java.lang.String> r0 = r10.f26884f
                r0.add(r2)
                goto L41
            L29:
                r6 = r12
                if (r6 >= r13) goto L44
                java.lang.String r12 = "/\\"
                int r12 = d.c.c.a.b.a.e.d(r11, r6, r13, r12)
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

        public final void f(String str, int i, int i2, boolean z, boolean z2) {
            String c2 = s.c(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true, null);
            if (s(c2)) {
                return;
            }
            if (t(c2)) {
                o();
                return;
            }
            List<String> list = this.f26884f;
            if (list.get(list.size() - 1).isEmpty()) {
                List<String> list2 = this.f26884f;
                list2.set(list2.size() - 1, c2);
            } else {
                this.f26884f.add(c2);
            }
            if (z) {
                this.f26884f.add("");
            }
        }

        public a h() {
            int size = this.f26884f.size();
            for (int i = 0; i < size; i++) {
                this.f26884f.set(i, s.e(this.f26884f.get(i), "[]", true, true, false, true));
            }
            List<String> list = this.f26885g;
            if (list != null) {
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = this.f26885g.get(i2);
                    if (str != null) {
                        this.f26885g.set(i2, s.e(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            String str2 = this.f26886h;
            if (str2 != null) {
                this.f26886h = s.e(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        public a i(String str) {
            if (str != null) {
                this.f26880b = s.e(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("username == null");
        }

        public a k(String str) {
            if (str != null) {
                this.f26881c = s.e(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("password == null");
        }

        public s l() {
            if (this.f26879a != null) {
                if (this.f26882d != null) {
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
                    this.f26882d = q;
                    return this;
                }
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            throw new NullPointerException("host == null");
        }

        public final void o() {
            List<String> list = this.f26884f;
            if (list.remove(list.size() - 1).isEmpty() && !this.f26884f.isEmpty()) {
                List<String> list2 = this.f26884f;
                list2.set(list2.size() - 1, "");
                return;
            }
            this.f26884f.add("");
        }

        public a p(String str) {
            this.f26885g = str != null ? s.n(s.e(str, " \"'<>#", true, false, true, true)) : null;
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
            sb.append(this.f26879a);
            sb.append("://");
            if (!this.f26880b.isEmpty() || !this.f26881c.isEmpty()) {
                sb.append(this.f26880b);
                if (!this.f26881c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f26881c);
                }
                sb.append('@');
            }
            if (this.f26882d.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.f26882d);
                sb.append(']');
            } else {
                sb.append(this.f26882d);
            }
            int a2 = a();
            if (a2 != s.a(this.f26879a)) {
                sb.append(':');
                sb.append(a2);
            }
            s.k(sb, this.f26884f);
            if (this.f26885g != null) {
                sb.append('?');
                s.o(sb, this.f26885g);
            }
            if (this.f26886h != null) {
                sb.append(SwanTaskDeadEvent.SEPARATOR);
                sb.append(this.f26886h);
            }
            return sb.toString();
        }
    }

    public s(a aVar) {
        this.f26871a = aVar.f26879a;
        this.f26872b = f(aVar.f26880b, false);
        this.f26873c = f(aVar.f26881c, false);
        this.f26874d = aVar.f26882d;
        this.f26875e = aVar.a();
        h(aVar.f26884f, false);
        List<String> list = aVar.f26885g;
        this.f26876f = list != null ? h(list, true) : null;
        String str = aVar.f26886h;
        this.f26877g = str != null ? f(str, false) : null;
        this.f26878h = aVar.toString();
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
                    cVar.p(z ? "+" : "%2B");
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
                        cVar.w(i[(h2 >> 4) & 15]);
                        cVar.w(i[h2 & 15]);
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
                sb.append(com.alipay.sdk.encrypt.a.f1922h);
                sb.append(str2);
            }
        }
    }

    public static s t(String str) {
        a aVar = new a();
        if (aVar.b(null, str) == a.EnumC0298a.SUCCESS) {
            return aVar.l();
        }
        return null;
    }

    public String A() {
        if (this.f26876f == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        o(sb, this.f26876f);
        return sb.toString();
    }

    public String B() {
        if (this.f26877g == null) {
            return null;
        }
        return this.f26878h.substring(this.f26878h.indexOf(35) + 1);
    }

    public String C() {
        a r = r("/...");
        r.i("");
        r.k("");
        return r.l().toString();
    }

    public a D() {
        a aVar = new a();
        aVar.f26879a = this.f26871a;
        aVar.f26880b = s();
        aVar.f26881c = u();
        aVar.f26882d = this.f26874d;
        aVar.f26883e = this.f26875e != a(this.f26871a) ? this.f26875e : -1;
        aVar.f26884f.clear();
        aVar.f26884f.addAll(y());
        aVar.p(z());
        aVar.f26886h = B();
        return aVar;
    }

    public boolean equals(Object obj) {
        return (obj instanceof s) && ((s) obj).f26878h.equals(this.f26878h);
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
        return this.f26878h.hashCode();
    }

    public String m() {
        return this.f26871a;
    }

    public s p(String str) {
        a r = r(str);
        if (r != null) {
            return r.l();
        }
        return null;
    }

    public boolean q() {
        return this.f26871a.equals("https");
    }

    public a r(String str) {
        a aVar = new a();
        if (aVar.b(this, str) == a.EnumC0298a.SUCCESS) {
            return aVar;
        }
        return null;
    }

    public String s() {
        if (this.f26872b.isEmpty()) {
            return "";
        }
        int length = this.f26871a.length() + 3;
        String str = this.f26878h;
        return this.f26878h.substring(length, e.d(str, length, str.length(), ":@"));
    }

    public String toString() {
        return this.f26878h;
    }

    public String u() {
        if (this.f26873c.isEmpty()) {
            return "";
        }
        int indexOf = this.f26878h.indexOf(64);
        return this.f26878h.substring(this.f26878h.indexOf(58, this.f26871a.length() + 3) + 1, indexOf);
    }

    public String v() {
        return this.f26874d;
    }

    public int w() {
        return this.f26875e;
    }

    public String x() {
        int indexOf = this.f26878h.indexOf(47, this.f26871a.length() + 3);
        String str = this.f26878h;
        return this.f26878h.substring(indexOf, e.d(str, indexOf, str.length(), "?#"));
    }

    public List<String> y() {
        int indexOf = this.f26878h.indexOf(47, this.f26871a.length() + 3);
        String str = this.f26878h;
        int d2 = e.d(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < d2) {
            int i2 = indexOf + 1;
            int c2 = e.c(this.f26878h, i2, d2, '/');
            arrayList.add(this.f26878h.substring(i2, c2));
            indexOf = c2;
        }
        return arrayList;
    }

    public String z() {
        if (this.f26876f == null) {
            return null;
        }
        int indexOf = this.f26878h.indexOf(63) + 1;
        String str = this.f26878h;
        return this.f26878h.substring(indexOf, e.c(str, indexOf, str.length(), SwanTaskDeadEvent.SEPARATOR));
    }
}
