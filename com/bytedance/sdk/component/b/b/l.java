package com.bytedance.sdk.component.b.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes5.dex */
public final class l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f28674a;

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f28675b;

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f28676c;

    /* renamed from: d  reason: collision with root package name */
    public static final Pattern f28677d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final String f28678e;

    /* renamed from: f  reason: collision with root package name */
    public final String f28679f;

    /* renamed from: g  reason: collision with root package name */
    public final long f28680g;

    /* renamed from: h  reason: collision with root package name */
    public final String f28681h;

    /* renamed from: i  reason: collision with root package name */
    public final String f28682i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public final boolean m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(731368878, "Lcom/bytedance/sdk/component/b/b/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(731368878, "Lcom/bytedance/sdk/component/b/b/l;");
                return;
            }
        }
        f28674a = Pattern.compile("(\\d{2,4})[^\\d]*");
        f28675b = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
        f28676c = Pattern.compile("(\\d{1,2})[^\\d]*");
        f28677d = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    }

    public l(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Long.valueOf(j), str3, str4, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f28678e = str;
        this.f28679f = str2;
        this.f28680g = j;
        this.f28681h = str3;
        this.f28682i = str4;
        this.j = z;
        this.k = z2;
        this.m = z3;
        this.l = z4;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f28678e : (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f28679f : (String) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (obj instanceof l) {
                l lVar = (l) obj;
                return lVar.f28678e.equals(this.f28678e) && lVar.f28679f.equals(this.f28679f) && lVar.f28681h.equals(this.f28681h) && lVar.f28682i.equals(this.f28682i) && lVar.f28680g == this.f28680g && lVar.j == this.j && lVar.k == this.k && lVar.l == this.l && lVar.m == this.m;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            long j = this.f28680g;
            return ((((((((((((((((527 + this.f28678e.hashCode()) * 31) + this.f28679f.hashCode()) * 31) + this.f28681h.hashCode()) * 31) + this.f28682i.hashCode()) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + (!this.j ? 1 : 0)) * 31) + (!this.k ? 1 : 0)) * 31) + (!this.l ? 1 : 0)) * 31) + (!this.m ? 1 : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? a(false) : (String) invokeV.objValue;
    }

    public static boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, str2)) == null) {
            if (str.equals(str2)) {
                return true;
            }
            return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !com.bytedance.sdk.component.b.b.a.c.c(str);
        }
        return invokeLL.booleanValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (!str.endsWith(".")) {
                if (str.startsWith(".")) {
                    str = str.substring(1);
                }
                String a2 = com.bytedance.sdk.component.b.b.a.c.a(str);
                if (a2 != null) {
                    return a2;
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException();
        }
        return (String) invokeL.objValue;
    }

    public static l a(t tVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, tVar, str)) == null) ? a(System.currentTimeMillis(), tVar, str) : (l) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x012c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static l a(long j, t tVar, String str) {
        InterceptResult invokeCommon;
        long j2;
        String g2;
        l lVar;
        String str2;
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{Long.valueOf(j), tVar, str})) == null) {
            int length = str.length();
            char c2 = ';';
            int a2 = com.bytedance.sdk.component.b.b.a.c.a(str, 0, length, ';');
            char c3 = com.alipay.sdk.encrypt.a.f1923h;
            int a3 = com.bytedance.sdk.component.b.b.a.c.a(str, 0, a2, (char) com.alipay.sdk.encrypt.a.f1923h);
            if (a3 == a2) {
                return null;
            }
            String c4 = com.bytedance.sdk.component.b.b.a.c.c(str, 0, a3);
            if (c4.isEmpty() || com.bytedance.sdk.component.b.b.a.c.b(c4) != -1) {
                return null;
            }
            String c5 = com.bytedance.sdk.component.b.b.a.c.c(str, a3 + 1, a2);
            if (com.bytedance.sdk.component.b.b.a.c.b(c5) != -1) {
                return null;
            }
            int i2 = a2 + 1;
            String str3 = null;
            String str4 = null;
            long j3 = -1;
            long j4 = 253402300799999L;
            boolean z = false;
            boolean z2 = false;
            boolean z3 = true;
            boolean z4 = false;
            while (i2 < length) {
                int a4 = com.bytedance.sdk.component.b.b.a.c.a(str, i2, length, c2);
                int a5 = com.bytedance.sdk.component.b.b.a.c.a(str, i2, a4, c3);
                String c6 = com.bytedance.sdk.component.b.b.a.c.c(str, i2, a5);
                String c7 = a5 < a4 ? com.bytedance.sdk.component.b.b.a.c.c(str, a5 + 1, a4) : "";
                if (c6.equalsIgnoreCase("expires")) {
                    try {
                        j4 = a(c7, 0, c7.length());
                    } catch (NumberFormatException | IllegalArgumentException unused) {
                    }
                } else if (c6.equalsIgnoreCase(ClientCookie.MAX_AGE_ATTR)) {
                    j3 = a(c7);
                } else {
                    if (c6.equalsIgnoreCase("domain")) {
                        str4 = b(c7);
                        z3 = false;
                    } else if (c6.equalsIgnoreCase("path")) {
                        str3 = c7;
                    } else if (c6.equalsIgnoreCase(ClientCookie.SECURE_ATTR)) {
                        z = true;
                    } else if (c6.equalsIgnoreCase("httponly")) {
                        z2 = true;
                    }
                    i2 = a4 + 1;
                    c2 = ';';
                    c3 = com.alipay.sdk.encrypt.a.f1923h;
                }
                z4 = true;
                i2 = a4 + 1;
                c2 = ';';
                c3 = com.alipay.sdk.encrypt.a.f1923h;
            }
            long j5 = Long.MIN_VALUE;
            if (j3 != Long.MIN_VALUE) {
                if (j3 != -1) {
                    j5 = j + (j3 <= 9223372036854775L ? j3 * 1000 : Long.MAX_VALUE);
                    if (j5 < j || j5 > HttpDate.MAX_DATE) {
                        j2 = 253402300799999L;
                    }
                } else {
                    j2 = j4;
                }
                g2 = tVar.g();
                if (str4 != null) {
                    str2 = g2;
                    lVar = null;
                } else if (!a(g2, str4)) {
                    return null;
                } else {
                    lVar = null;
                    str2 = str4;
                }
                if (g2.length() == str2.length() && com.bytedance.sdk.component.b.b.a.h.a.a().a(str2) == null) {
                    return lVar;
                }
                if (str3 == null && str3.startsWith("/")) {
                    substring = str3;
                } else {
                    String i3 = tVar.i();
                    int lastIndexOf = i3.lastIndexOf(47);
                    substring = lastIndexOf != 0 ? i3.substring(0, lastIndexOf) : "/";
                }
                return new l(c4, c5, j2, str2, substring, z, z2, z3, z4);
            }
            j2 = j5;
            g2 = tVar.g();
            if (str4 != null) {
            }
            if (g2.length() == str2.length()) {
            }
            if (str3 == null) {
            }
            String i32 = tVar.i();
            int lastIndexOf2 = i32.lastIndexOf(47);
            substring = lastIndexOf2 != 0 ? i32.substring(0, lastIndexOf2) : "/";
            return new l(c4, c5, j2, str2, substring, z, z2, z3, z4);
        }
        return (l) invokeCommon.objValue;
    }

    public static long a(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i2, i3)) == null) {
            int a2 = a(str, i2, i3, false);
            Matcher matcher = f28677d.matcher(str);
            int i4 = -1;
            int i5 = -1;
            int i6 = -1;
            int i7 = -1;
            int i8 = -1;
            int i9 = -1;
            while (a2 < i3) {
                int a3 = a(str, a2 + 1, i3, true);
                matcher.region(a2, a3);
                if (i5 == -1 && matcher.usePattern(f28677d).matches()) {
                    i5 = Integer.parseInt(matcher.group(1));
                    i8 = Integer.parseInt(matcher.group(2));
                    i9 = Integer.parseInt(matcher.group(3));
                } else if (i6 == -1 && matcher.usePattern(f28676c).matches()) {
                    i6 = Integer.parseInt(matcher.group(1));
                } else if (i7 == -1 && matcher.usePattern(f28675b).matches()) {
                    i7 = f28675b.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                } else if (i4 == -1 && matcher.usePattern(f28674a).matches()) {
                    i4 = Integer.parseInt(matcher.group(1));
                }
                a2 = a(str, a3 + 1, i3, false);
            }
            if (i4 >= 70 && i4 <= 99) {
                i4 += FeatureCodes.SKY_SEG;
            }
            if (i4 >= 0 && i4 <= 69) {
                i4 += 2000;
            }
            if (i4 >= 1601) {
                if (i7 != -1) {
                    if (i6 < 1 || i6 > 31) {
                        throw new IllegalArgumentException();
                    }
                    if (i5 < 0 || i5 > 23) {
                        throw new IllegalArgumentException();
                    }
                    if (i8 < 0 || i8 > 59) {
                        throw new IllegalArgumentException();
                    }
                    if (i9 >= 0 && i9 <= 59) {
                        GregorianCalendar gregorianCalendar = new GregorianCalendar(com.bytedance.sdk.component.b.b.a.c.f28321g);
                        gregorianCalendar.setLenient(false);
                        gregorianCalendar.set(1, i4);
                        gregorianCalendar.set(2, i7 - 1);
                        gregorianCalendar.set(5, i6);
                        gregorianCalendar.set(11, i5);
                        gregorianCalendar.set(12, i8);
                        gregorianCalendar.set(13, i9);
                        gregorianCalendar.set(14, 0);
                        return gregorianCalendar.getTimeInMillis();
                    }
                    throw new IllegalArgumentException();
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException();
        }
        return invokeLII.longValue;
    }

    public static int a(String str, int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            while (i2 < i3) {
                char charAt = str.charAt(i2);
                if (((charAt < ' ' && charAt != '\t') || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z)) {
                    return i2;
                }
                i2++;
            }
            return i3;
        }
        return invokeCommon.intValue;
    }

    public static long a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong <= 0) {
                    return Long.MIN_VALUE;
                }
                return parseLong;
            } catch (NumberFormatException e2) {
                if (str.matches("-?\\d+")) {
                    return str.startsWith("-") ? Long.MIN_VALUE : Long.MAX_VALUE;
                }
                throw e2;
            }
        }
        return invokeL.longValue;
    }

    public static List<l> a(t tVar, s sVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, tVar, sVar)) == null) {
            List<String> b2 = sVar.b("Set-Cookie");
            int size = b2.size();
            ArrayList arrayList = null;
            for (int i2 = 0; i2 < size; i2++) {
                l a2 = a(tVar, b2.get(i2));
                if (a2 != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(a2);
                }
            }
            if (arrayList != null) {
                return Collections.unmodifiableList(arrayList);
            }
            return Collections.emptyList();
        }
        return (List) invokeLL.objValue;
    }

    public String a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f28678e);
            sb.append(com.alipay.sdk.encrypt.a.f1923h);
            sb.append(this.f28679f);
            if (this.l) {
                if (this.f28680g == Long.MIN_VALUE) {
                    sb.append("; max-age=0");
                } else {
                    sb.append("; expires=");
                    sb.append(com.bytedance.sdk.component.b.b.a.c.d.a(new Date(this.f28680g)));
                }
            }
            if (!this.m) {
                sb.append("; domain=");
                if (z) {
                    sb.append(".");
                }
                sb.append(this.f28681h);
            }
            sb.append("; path=");
            sb.append(this.f28682i);
            if (this.j) {
                sb.append("; secure");
            }
            if (this.k) {
                sb.append("; httponly");
            }
            return sb.toString();
        }
        return (String) invokeZ.objValue;
    }
}
