package com.bytedance.sdk.component.b.b.a.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.component.b.b.ab;
import com.bytedance.sdk.component.b.b.m;
import com.bytedance.sdk.component.b.b.s;
import com.bytedance.sdk.component.b.b.t;
import java.util.List;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f28332a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-952329361, "Lcom/bytedance/sdk/component/b/b/a/c/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-952329361, "Lcom/bytedance/sdk/component/b/b/a/c/e;");
                return;
            }
        }
        f28332a = Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");
    }

    public static long a(ab abVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, abVar)) == null) ? a(abVar.g()) : invokeL.longValue;
    }

    public static boolean b(ab abVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, abVar)) == null) {
            if (abVar.a().b().equals("HEAD")) {
                return false;
            }
            int c2 = abVar.c();
            return (((c2 >= 100 && c2 < 200) || c2 == 204 || c2 == 304) && a(abVar) == -1 && !"chunked".equalsIgnoreCase(abVar.a("Transfer-Encoding"))) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public static long a(s sVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, sVar)) == null) ? a(sVar.a("Content-Length")) : invokeL.longValue;
    }

    public static long a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            if (str == null) {
                return -1L;
            }
            try {
                return Long.parseLong(str);
            } catch (NumberFormatException unused) {
                return -1L;
            }
        }
        return invokeL.longValue;
    }

    public static void a(m mVar, t tVar, s sVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, mVar, tVar, sVar) == null) || mVar == m.f28683a) {
            return;
        }
        List<com.bytedance.sdk.component.b.b.l> a2 = com.bytedance.sdk.component.b.b.l.a(tVar, sVar);
        if (a2.isEmpty()) {
            return;
        }
        mVar.a(tVar, a2);
    }

    public static int b(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, str, i2)) == null) {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong > 2147483647L) {
                    return Integer.MAX_VALUE;
                }
                if (parseLong < 0) {
                    return 0;
                }
                return (int) parseLong;
            } catch (NumberFormatException unused) {
                return i2;
            }
        }
        return invokeLI.intValue;
    }

    public static int a(String str, int i2, String str2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65538, null, str, i2, str2)) == null) {
            while (i2 < str.length() && str2.indexOf(str.charAt(i2)) == -1) {
                i2++;
            }
            return i2;
        }
        return invokeLIL.intValue;
    }

    public static int a(String str, int i2) {
        char charAt;
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, str, i2)) == null) {
            while (i2 < str.length() && ((charAt = str.charAt(i2)) == ' ' || charAt == '\t')) {
                i2++;
            }
            return i2;
        }
        return invokeLI.intValue;
    }
}
