package com.bytedance.sdk.a.b;

import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.http.HttpHost;
/* loaded from: classes6.dex */
public final class s {
    private static final char[] d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a  reason: collision with root package name */
    final String f5973a;

    /* renamed from: b  reason: collision with root package name */
    final String f5974b;
    final int c;
    private final String e;
    private final String f;
    private final List<String> g;
    private final List<String> h;
    private final String i;
    private final String j;

    s(a aVar) {
        this.f5973a = aVar.f5975a;
        this.e = a(aVar.f5976b, false);
        this.f = a(aVar.c, false);
        this.f5974b = aVar.d;
        this.c = aVar.a();
        this.g = a(aVar.f, false);
        this.h = aVar.g != null ? a(aVar.g, true) : null;
        this.i = aVar.h != null ? a(aVar.h, false) : null;
        this.j = aVar.toString();
    }

    public URI eqe() {
        String aVar = eqg().eqh().toString();
        try {
            return new URI(aVar);
        } catch (URISyntaxException e) {
            try {
                return URI.create(aVar.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception e2) {
                throw new RuntimeException(e);
            }
        }
    }

    public String b() {
        return this.f5973a;
    }

    public boolean c() {
        return this.f5973a.equals("https");
    }

    public String d() {
        if (this.e.isEmpty()) {
            return "";
        }
        int length = this.f5973a.length() + 3;
        return this.j.substring(length, com.bytedance.sdk.a.b.a.c.a(this.j, length, this.j.length(), ":@"));
    }

    public String e() {
        if (this.f.isEmpty()) {
            return "";
        }
        int indexOf = this.j.indexOf(64);
        return this.j.substring(this.j.indexOf(58, this.f5973a.length() + 3) + 1, indexOf);
    }

    public String f() {
        return this.f5974b;
    }

    public int g() {
        return this.c;
    }

    public static int a(String str) {
        if (str.equals(HttpHost.DEFAULT_SCHEME_NAME)) {
            return 80;
        }
        if (str.equals("https")) {
            return Constants.SOCKET_PORT_SSL;
        }
        return -1;
    }

    public String h() {
        int indexOf = this.j.indexOf(47, this.f5973a.length() + 3);
        return this.j.substring(indexOf, com.bytedance.sdk.a.b.a.c.a(this.j, indexOf, this.j.length(), "?#"));
    }

    static void a(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append('/');
            sb.append(list.get(i));
        }
    }

    public List<String> eqf() {
        int indexOf = this.j.indexOf(47, this.f5973a.length() + 3);
        int a2 = com.bytedance.sdk.a.b.a.c.a(this.j, indexOf, this.j.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < a2) {
            int i = indexOf + 1;
            indexOf = com.bytedance.sdk.a.b.a.c.a(this.j, i, a2, '/');
            arrayList.add(this.j.substring(i, indexOf));
        }
        return arrayList;
    }

    public String j() {
        if (this.h == null) {
            return null;
        }
        int indexOf = this.j.indexOf(63) + 1;
        return this.j.substring(indexOf, com.bytedance.sdk.a.b.a.c.a(this.j, indexOf, this.j.length(), '#'));
    }

    static void b(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = list.get(i);
            String str2 = list.get(i + 1);
            if (i > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    static List<String> b(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int indexOf = str.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i, indexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            }
            i = indexOf + 1;
        }
        return arrayList;
    }

    public String k() {
        if (this.h == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        b(sb, this.h);
        return sb.toString();
    }

    public String l() {
        if (this.i == null) {
            return null;
        }
        return this.j.substring(this.j.indexOf(35) + 1);
    }

    public String m() {
        return YT("/...").YW("").YX("").eqi().toString();
    }

    public s YS(String str) {
        a YT = YT(str);
        if (YT != null) {
            return YT.eqi();
        }
        return null;
    }

    public a eqg() {
        a aVar = new a();
        aVar.f5975a = this.f5973a;
        aVar.f5976b = d();
        aVar.c = e();
        aVar.d = this.f5974b;
        aVar.e = this.c != a(this.f5973a) ? this.c : -1;
        aVar.f.clear();
        aVar.f.addAll(eqf());
        aVar.YY(j());
        aVar.h = l();
        return aVar;
    }

    public a YT(String str) {
        a aVar = new a();
        if (aVar.b(this, str) == a.EnumC0997a.SUCCESS) {
            return aVar;
        }
        return null;
    }

    public static s YU(String str) {
        a aVar = new a();
        if (aVar.b(null, str) == a.EnumC0997a.SUCCESS) {
            return aVar.eqi();
        }
        return null;
    }

    public static s d(URL url) {
        return YU(url.toString());
    }

    public boolean equals(Object obj) {
        return (obj instanceof s) && ((s) obj).j.equals(this.j);
    }

    public int hashCode() {
        return this.j.hashCode();
    }

    public String toString() {
        return this.j;
    }

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        String f5975a;
        String d;
        List<String> g;
        String h;

        /* renamed from: b  reason: collision with root package name */
        String f5976b = "";
        String c = "";
        int e = -1;
        final List<String> f = new ArrayList();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bytedance.sdk.a.b.s$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public enum EnumC0997a {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public a() {
            this.f.add("");
        }

        public a YV(String str) {
            if (str == null) {
                throw new NullPointerException("scheme == null");
            }
            if (str.equalsIgnoreCase(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.f5975a = HttpHost.DEFAULT_SCHEME_NAME;
            } else if (str.equalsIgnoreCase("https")) {
                this.f5975a = "https";
            } else {
                throw new IllegalArgumentException("unexpected scheme: " + str);
            }
            return this;
        }

        public a YW(String str) {
            if (str == null) {
                throw new NullPointerException("username == null");
            }
            this.f5976b = s.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public a YX(String str) {
            if (str == null) {
                throw new NullPointerException("password == null");
            }
            this.c = s.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public a YT(String str) {
            if (str == null) {
                throw new NullPointerException("host == null");
            }
            String e = e(str, 0, str.length());
            if (e == null) {
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            this.d = e;
            return this;
        }

        public a OH(int i) {
            if (i <= 0 || i > 65535) {
                throw new IllegalArgumentException("unexpected port: " + i);
            }
            this.e = i;
            return this;
        }

        int a() {
            return this.e != -1 ? this.e : s.a(this.f5975a);
        }

        public a YY(String str) {
            this.g = str != null ? s.b(s.a(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        a eqh() {
            int size = this.f.size();
            for (int i = 0; i < size; i++) {
                this.f.set(i, s.a(this.f.get(i), "[]", true, true, false, true));
            }
            if (this.g != null) {
                int size2 = this.g.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = this.g.get(i2);
                    if (str != null) {
                        this.g.set(i2, s.a(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            if (this.h != null) {
                this.h = s.a(this.h, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        public s eqi() {
            if (this.f5975a == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.d == null) {
                throw new IllegalStateException("host == null");
            }
            return new s(this);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f5975a);
            sb.append("://");
            if (!this.f5976b.isEmpty() || !this.c.isEmpty()) {
                sb.append(this.f5976b);
                if (!this.c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.c);
                }
                sb.append('@');
            }
            if (this.d.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.d);
                sb.append(']');
            } else {
                sb.append(this.d);
            }
            int a2 = a();
            if (a2 != s.a(this.f5975a)) {
                sb.append(':');
                sb.append(a2);
            }
            s.a(sb, this.f);
            if (this.g != null) {
                sb.append('?');
                s.b(sb, this.g);
            }
            if (this.h != null) {
                sb.append('#');
                sb.append(this.h);
            }
            return sb.toString();
        }

        EnumC0997a b(s sVar, String str) {
            int i;
            int a2 = com.bytedance.sdk.a.b.a.c.a(str, 0, str.length());
            int b2 = com.bytedance.sdk.a.b.a.c.b(str, a2, str.length());
            if (b(str, a2, b2) != -1) {
                if (str.regionMatches(true, a2, UrlSchemaHelper.SCHEMA_TYPE_HTTPS, 0, 6)) {
                    this.f5975a = "https";
                    a2 += UrlSchemaHelper.SCHEMA_TYPE_HTTPS.length();
                } else if (str.regionMatches(true, a2, UrlSchemaHelper.SCHEMA_TYPE_HTTP, 0, 5)) {
                    this.f5975a = HttpHost.DEFAULT_SCHEME_NAME;
                    a2 += UrlSchemaHelper.SCHEMA_TYPE_HTTP.length();
                } else {
                    return EnumC0997a.UNSUPPORTED_SCHEME;
                }
            } else if (sVar != null) {
                this.f5975a = sVar.f5973a;
            } else {
                return EnumC0997a.MISSING_SCHEME;
            }
            int c = c(str, a2, b2);
            if (c >= 2 || sVar == null || !sVar.f5973a.equals(this.f5975a)) {
                int i2 = c + a2;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    int a3 = com.bytedance.sdk.a.b.a.c.a(str, i2, b2, "@/\\?#");
                    switch (a3 != b2 ? str.charAt(a3) : (char) 65535) {
                        case 65535:
                        case '#':
                        case '/':
                        case '?':
                        case '\\':
                            int d = d(str, i2, a3);
                            if (d + 1 < a3) {
                                this.d = e(str, i2, d);
                                this.e = F(str, d + 1, a3);
                                if (this.e == -1) {
                                    return EnumC0997a.INVALID_PORT;
                                }
                            } else {
                                this.d = e(str, i2, d);
                                this.e = s.a(this.f5975a);
                            }
                            if (this.d != null) {
                                a2 = a3;
                                break;
                            } else {
                                return EnumC0997a.INVALID_HOST;
                            }
                        case '@':
                            if (!z) {
                                int a4 = com.bytedance.sdk.a.b.a.c.a(str, i2, a3, ':');
                                String a5 = s.a(str, i2, a4, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                if (z2) {
                                    a5 = this.f5976b + "%40" + a5;
                                }
                                this.f5976b = a5;
                                if (a4 != a3) {
                                    z = true;
                                    this.c = s.a(str, a4 + 1, a3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                }
                                z2 = true;
                            } else {
                                this.c += "%40" + s.a(str, i2, a3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            }
                            i2 = a3 + 1;
                            break;
                    }
                    z = z;
                    z2 = z2;
                }
            } else {
                this.f5976b = sVar.d();
                this.c = sVar.e();
                this.d = sVar.f5974b;
                this.e = sVar.c;
                this.f.clear();
                this.f.addAll(sVar.eqf());
                if (a2 == b2 || str.charAt(a2) == '#') {
                    YY(sVar.j());
                }
            }
            int a6 = com.bytedance.sdk.a.b.a.c.a(str, a2, b2, "?#");
            a(str, a2, a6);
            if (a6 >= b2 || str.charAt(a6) != '?') {
                i = a6;
            } else {
                i = com.bytedance.sdk.a.b.a.c.a(str, a6, b2, '#');
                this.g = s.b(s.a(str, a6 + 1, i, " \"'<>#", true, false, true, true, null));
            }
            if (i < b2 && str.charAt(i) == '#') {
                this.h = s.a(str, i + 1, b2, "", true, false, false, false, null);
            }
            return EnumC0997a.SUCCESS;
        }

        private void a(String str, int i, int i2) {
            if (i != i2) {
                char charAt = str.charAt(i);
                if (charAt == '/' || charAt == '\\') {
                    this.f.clear();
                    this.f.add("");
                    i++;
                } else {
                    this.f.set(this.f.size() - 1, "");
                }
                int i3 = i;
                while (i3 < i2) {
                    int a2 = com.bytedance.sdk.a.b.a.c.a(str, i3, i2, "/\\");
                    boolean z = a2 < i2;
                    a(str, i3, a2, z, true);
                    if (z) {
                        a2++;
                    }
                    i3 = a2;
                }
            }
        }

        private void a(String str, int i, int i2, boolean z, boolean z2) {
            String a2 = s.a(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true, null);
            if (!f(a2)) {
                if (g(a2)) {
                    d();
                    return;
                }
                if (this.f.get(this.f.size() - 1).isEmpty()) {
                    this.f.set(this.f.size() - 1, a2);
                } else {
                    this.f.add(a2);
                }
                if (z) {
                    this.f.add("");
                }
            }
        }

        private boolean f(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private boolean g(String str) {
            return str.equals(IStringUtil.TOP_PATH) || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        private void d() {
            if (this.f.remove(this.f.size() - 1).isEmpty() && !this.f.isEmpty()) {
                this.f.set(this.f.size() - 1, "");
            } else {
                this.f.add("");
            }
        }

        private static int b(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char charAt = str.charAt(i);
            if ((charAt < 'a' || charAt > 'z') && (charAt < 'A' || charAt > 'Z')) {
                return -1;
            }
            for (int i3 = i + 1; i3 < i2; i3++) {
                char charAt2 = str.charAt(i3);
                if ((charAt2 < 'a' || charAt2 > 'z') && ((charAt2 < 'A' || charAt2 > 'Z') && ((charAt2 < '0' || charAt2 > '9') && charAt2 != '+' && charAt2 != '-' && charAt2 != '.'))) {
                    if (charAt2 == ':') {
                        return i3;
                    } else {
                        return -1;
                    }
                }
            }
            return -1;
        }

        private static int c(String str, int i, int i2) {
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

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        private static int d(String str, int i, int i2) {
            int i3 = i;
            while (i3 < i2) {
                switch (str.charAt(i3)) {
                    case ':':
                        return i3;
                    case '[':
                        break;
                    default:
                        i3++;
                }
                do {
                    i3++;
                    if (i3 < i2) {
                    }
                    i3++;
                } while (str.charAt(i3) != ']');
                i3++;
            }
            return i2;
        }

        private static String e(String str, int i, int i2) {
            return com.bytedance.sdk.a.b.a.c.a(s.a(str, i, i2, false));
        }

        private static int F(String str, int i, int i2) {
            try {
                int parseInt = Integer.parseInt(s.a(str, i, i2, "", false, false, false, true, null));
                if (parseInt <= 0 || parseInt > 65535) {
                    return -1;
                }
                return parseInt;
            } catch (NumberFormatException e) {
                return -1;
            }
        }
    }

    static String a(String str, boolean z) {
        return a(str, 0, str.length(), z);
    }

    private List<String> a(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str = list.get(i);
            arrayList.add(str != null ? a(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static String a(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char charAt = str.charAt(i3);
            if (charAt == '%' || (charAt == '+' && z)) {
                com.bytedance.sdk.a.a.c cVar = new com.bytedance.sdk.a.a.c();
                cVar.B(str, i, i3);
                a(cVar, str, i3, i2, z);
                return cVar.o();
            }
        }
        return str.substring(i, i2);
    }

    static void a(com.bytedance.sdk.a.a.c cVar, String str, int i, int i2, boolean z) {
        int i3 = i;
        while (i3 < i2) {
            int codePointAt = str.codePointAt(i3);
            if (codePointAt == 37 && i3 + 2 < i2) {
                int a2 = com.bytedance.sdk.a.b.a.c.a(str.charAt(i3 + 1));
                int a3 = com.bytedance.sdk.a.b.a.c.a(str.charAt(i3 + 2));
                if (a2 != -1 && a3 != -1) {
                    cVar.OB((a2 << 4) + a3);
                    i3 += 2;
                }
                cVar.Ot(codePointAt);
            } else {
                if (codePointAt == 43 && z) {
                    cVar.OB(32);
                }
                cVar.Ot(codePointAt);
            }
            i3 += Character.charCount(codePointAt);
        }
    }

    static boolean a(String str, int i, int i2) {
        return i + 2 < i2 && str.charAt(i) == '%' && com.bytedance.sdk.a.b.a.c.a(str.charAt(i + 1)) != -1 && com.bytedance.sdk.a.b.a.c.a(str.charAt(i + 2)) != -1;
    }

    static String a(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        int i3 = i;
        while (i3 < i2) {
            int codePointAt = str.codePointAt(i3);
            if (codePointAt >= 32 && codePointAt != 127 && ((codePointAt < 128 || !z4) && str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z && (!z2 || a(str, i3, i2)))) && (codePointAt != 43 || !z3)))) {
                i3 += Character.charCount(codePointAt);
            } else {
                com.bytedance.sdk.a.a.c cVar = new com.bytedance.sdk.a.a.c();
                cVar.B(str, i, i3);
                a(cVar, str, i3, i2, str2, z, z2, z3, z4, charset);
                return cVar.o();
            }
        }
        return str.substring(i, i2);
    }

    static void a(com.bytedance.sdk.a.a.c cVar, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        com.bytedance.sdk.a.a.c cVar2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (!z || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt == 43 && z3) {
                    cVar.YM(z ? "+" : "%2B");
                } else if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z4) || str2.indexOf(codePointAt) != -1 || (codePointAt == 37 && (!z || (z2 && !a(str, i, i2)))))) {
                    if (cVar2 == null) {
                        cVar2 = new com.bytedance.sdk.a.a.c();
                    }
                    if (charset == null || charset.equals(com.bytedance.sdk.a.b.a.c.ppA)) {
                        cVar2.Ot(codePointAt);
                    } else {
                        cVar2.a(str, i, Character.charCount(codePointAt) + i, charset);
                    }
                    while (!cVar2.e()) {
                        int eoC = cVar2.eoC() & 255;
                        cVar.OB(37);
                        cVar.OB(d[(eoC >> 4) & 15]);
                        cVar.OB(d[eoC & 15]);
                    }
                } else {
                    cVar.Ot(codePointAt);
                }
            }
            i += Character.charCount(codePointAt);
        }
    }

    static String a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return a(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }
}
