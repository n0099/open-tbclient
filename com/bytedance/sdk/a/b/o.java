package com.bytedance.sdk.a.b;

import com.baidu.ar.auth.FeatureCodes;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.http.HttpDate;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.SM;
/* loaded from: classes4.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f5967a = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f5968b = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern c = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern d = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    private final String e;
    private final String f;
    private final long g;
    private final String h;
    private final String i;
    private final boolean j;
    private final boolean k;
    private final boolean l;
    private final boolean m;

    private o(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.e = str;
        this.f = str2;
        this.g = j;
        this.h = str3;
        this.i = str4;
        this.j = z;
        this.k = z2;
        this.m = z3;
        this.l = z4;
    }

    public String a() {
        return this.e;
    }

    public String b() {
        return this.f;
    }

    private static boolean a(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) + (-1)) == '.' && !com.bytedance.sdk.a.b.a.c.c(str);
    }

    public static o a(s sVar, String str) {
        return a(System.currentTimeMillis(), sVar, str);
    }

    static o a(long j, s sVar, String str) {
        long j2;
        String substring;
        String str2;
        int length = str.length();
        int a2 = com.bytedance.sdk.a.b.a.c.a(str, 0, length, ';');
        int a3 = com.bytedance.sdk.a.b.a.c.a(str, 0, a2, '=');
        if (a3 == a2) {
            return null;
        }
        String C = com.bytedance.sdk.a.b.a.c.C(str, 0, a3);
        if (C.isEmpty() || com.bytedance.sdk.a.b.a.c.b(C) != -1) {
            return null;
        }
        String C2 = com.bytedance.sdk.a.b.a.c.C(str, a3 + 1, a2);
        if (com.bytedance.sdk.a.b.a.c.b(C2) != -1) {
            return null;
        }
        long j3 = HttpDate.MAX_DATE;
        long j4 = -1;
        String str3 = null;
        String str4 = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = true;
        boolean z4 = false;
        int i = a2 + 1;
        while (i < length) {
            int a4 = com.bytedance.sdk.a.b.a.c.a(str, i, length, ';');
            int a5 = com.bytedance.sdk.a.b.a.c.a(str, i, a4, '=');
            String C3 = com.bytedance.sdk.a.b.a.c.C(str, i, a5);
            String C4 = a5 < a4 ? com.bytedance.sdk.a.b.a.c.C(str, a5 + 1, a4) : "";
            if (C3.equalsIgnoreCase("expires")) {
                try {
                    j3 = E(C4, 0, C4.length());
                    z4 = true;
                    str2 = str3;
                } catch (IllegalArgumentException e) {
                    str2 = str3;
                }
            } else if (C3.equalsIgnoreCase(ClientCookie.MAX_AGE_ATTR)) {
                try {
                    j4 = a(C4);
                    z4 = true;
                    str2 = str3;
                } catch (NumberFormatException e2) {
                    str2 = str3;
                }
            } else if (C3.equalsIgnoreCase("domain")) {
                try {
                    z3 = false;
                    str2 = b(C4);
                } catch (IllegalArgumentException e3) {
                    str2 = str3;
                }
            } else if (C3.equalsIgnoreCase("path")) {
                str4 = C4;
                str2 = str3;
            } else if (C3.equalsIgnoreCase(ClientCookie.SECURE_ATTR)) {
                z = true;
                str2 = str3;
            } else if (C3.equalsIgnoreCase("httponly")) {
                z2 = true;
                str2 = str3;
            } else {
                str2 = str3;
            }
            i = a4 + 1;
            str3 = str2;
        }
        if (j4 == Long.MIN_VALUE) {
            j2 = Long.MIN_VALUE;
        } else if (j4 != -1) {
            j2 = (j4 <= 9223372036854775L ? 1000 * j4 : Long.MAX_VALUE) + j;
            if (j2 < j || j2 > HttpDate.MAX_DATE) {
                j2 = HttpDate.MAX_DATE;
            }
        } else {
            j2 = j3;
        }
        String f = sVar.f();
        if (str3 == null) {
            str3 = f;
        } else if (!a(f, str3)) {
            return null;
        }
        if (f.length() != str3.length() && com.bytedance.sdk.a.b.a.h.a.enh().a(str3) == null) {
            return null;
        }
        if (str4 == null || !str4.startsWith("/")) {
            String h = sVar.h();
            int lastIndexOf = h.lastIndexOf(47);
            substring = lastIndexOf != 0 ? h.substring(0, lastIndexOf) : "/";
        } else {
            substring = str4;
        }
        return new o(C, C2, j2, str3, substring, z, z2, z3, z4);
    }

    private static long E(String str, int i, int i2) {
        int b2 = b(str, i, i2, false);
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        Matcher matcher = d.matcher(str);
        while (b2 < i2) {
            int b3 = b(str, b2 + 1, i2, true);
            matcher.region(b2, b3);
            if (i3 == -1 && matcher.usePattern(d).matches()) {
                i3 = Integer.parseInt(matcher.group(1));
                i4 = Integer.parseInt(matcher.group(2));
                i5 = Integer.parseInt(matcher.group(3));
            } else if (i6 == -1 && matcher.usePattern(c).matches()) {
                i6 = Integer.parseInt(matcher.group(1));
            } else if (i7 == -1 && matcher.usePattern(f5968b).matches()) {
                i7 = f5968b.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
            } else if (i8 == -1 && matcher.usePattern(f5967a).matches()) {
                i8 = Integer.parseInt(matcher.group(1));
            }
            b2 = b(str, b3 + 1, i2, false);
        }
        if (i8 >= 70 && i8 <= 99) {
            i8 += FeatureCodes.SKY_SEG;
        }
        if (i8 >= 0 && i8 <= 69) {
            i8 += 2000;
        }
        if (i8 < 1601) {
            throw new IllegalArgumentException();
        }
        if (i7 == -1) {
            throw new IllegalArgumentException();
        }
        if (i6 < 1 || i6 > 31) {
            throw new IllegalArgumentException();
        }
        if (i3 < 0 || i3 > 23) {
            throw new IllegalArgumentException();
        }
        if (i4 < 0 || i4 > 59) {
            throw new IllegalArgumentException();
        }
        if (i5 < 0 || i5 > 59) {
            throw new IllegalArgumentException();
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(com.bytedance.sdk.a.b.a.c.peM);
        gregorianCalendar.setLenient(false);
        gregorianCalendar.set(1, i8);
        gregorianCalendar.set(2, i7 - 1);
        gregorianCalendar.set(5, i6);
        gregorianCalendar.set(11, i3);
        gregorianCalendar.set(12, i4);
        gregorianCalendar.set(13, i5);
        gregorianCalendar.set(14, 0);
        return gregorianCalendar.getTimeInMillis();
    }

    private static int b(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char charAt = str.charAt(i3);
            if (((charAt < ' ' && charAt != '\t') || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z)) {
                return i3;
            }
        }
        return i2;
    }

    private static long a(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong <= 0) {
                return Long.MIN_VALUE;
            }
            return parseLong;
        } catch (NumberFormatException e) {
            if (str.matches("-?\\d+")) {
                return !str.startsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER) ? Long.MAX_VALUE : Long.MIN_VALUE;
            }
            throw e;
        }
    }

    private static String b(String str) {
        if (str.endsWith(".")) {
            throw new IllegalArgumentException();
        }
        if (str.startsWith(".")) {
            str = str.substring(1);
        }
        String a2 = com.bytedance.sdk.a.b.a.c.a(str);
        if (a2 == null) {
            throw new IllegalArgumentException();
        }
        return a2;
    }

    public static List<o> a(s sVar, v vVar) {
        List<String> b2 = vVar.b(SM.SET_COOKIE);
        ArrayList arrayList = null;
        int size = b2.size();
        for (int i = 0; i < size; i++) {
            o a2 = a(sVar, b2.get(i));
            if (a2 != null) {
                ArrayList arrayList2 = arrayList == null ? new ArrayList() : arrayList;
                arrayList2.add(a2);
                arrayList = arrayList2;
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public String toString() {
        return a(false);
    }

    String a(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.e);
        sb.append('=');
        sb.append(this.f);
        if (this.l) {
            if (this.g == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=").append(com.bytedance.sdk.a.b.a.c.d.a(new Date(this.g)));
            }
        }
        if (!this.m) {
            sb.append("; domain=");
            if (z) {
                sb.append(".");
            }
            sb.append(this.h);
        }
        sb.append("; path=").append(this.i);
        if (this.j) {
            sb.append("; secure");
        }
        if (this.k) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj instanceof o) {
            o oVar = (o) obj;
            return oVar.e.equals(this.e) && oVar.f.equals(this.f) && oVar.h.equals(this.h) && oVar.i.equals(this.i) && oVar.g == this.g && oVar.j == this.j && oVar.k == this.k && oVar.l == this.l && oVar.m == this.m;
        }
        return false;
    }

    public int hashCode() {
        return (((this.l ? 0 : 1) + (((this.k ? 0 : 1) + (((this.j ? 0 : 1) + ((((((((((this.e.hashCode() + 527) * 31) + this.f.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + ((int) (this.g ^ (this.g >>> 32)))) * 31)) * 31)) * 31)) * 31) + (this.m ? 0 : 1);
    }
}
