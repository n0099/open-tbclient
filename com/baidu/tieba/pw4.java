package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public class pw4 {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<String> i;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public boolean h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948076444, "Lcom/baidu/tieba/pw4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948076444, "Lcom/baidu/tieba/pw4;");
                return;
            }
        }
        i = new HashSet();
    }

    public pw4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return i.contains(str);
        }
        return invokeL.booleanValue;
    }

    public static void b(AdvertAppInfo advertAppInfo) {
        pw4 pw4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) && advertAppInfo != null && (pw4Var = advertAppInfo.i) != null && !pw4Var.h && !a(pw4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(advertAppInfo.j).q(String.valueOf(advertAppInfo.position + 1)).r(pw4Var.d).s(pw4Var.e).t(pw4Var.c).w(String.valueOf(pw4Var.b)).p(advertAppInfo.g);
            m11.b(clogBuilder);
            pe8.b(pe8.a(advertAppInfo));
            pw4Var.h = true;
            i.add(pw4Var.g);
        }
    }

    public static void f(zl9 zl9Var) {
        pw4 pw4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, zl9Var) == null) && zl9Var != null && zl9Var.getAdvertAppInfo() != null && (pw4Var = zl9Var.getAdvertAppInfo().i) != null && !pw4Var.h && !a(pw4Var.g)) {
            zl9Var.d1 = pw4Var.d;
            zl9Var.e1 = pw4Var.e;
            zl9Var.c1 = pw4Var.c;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).q(String.valueOf(zl9Var.i1 + 1)).w(String.valueOf(zl9Var.g1)).v(pw4Var.a).r(pw4Var.d).s(pw4Var.e).t(pw4Var.c).p(pw4Var.g);
            m11.b(clogBuilder);
            pw4Var.h = true;
            i.add(pw4Var.g);
        }
    }

    public static void c(pw4 pw4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{pw4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && pw4Var != null && !pw4Var.h && !a(pw4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            clogBuilder.y(logType).v(pw4Var.a).q(String.valueOf(i2 + 1)).r(pw4Var.d).s(pw4Var.e).t(pw4Var.c).w(String.valueOf(pw4Var.b)).p(pw4Var.g);
            m11.b(clogBuilder);
            pw4Var.h = true;
            i.add(pw4Var.g);
        }
    }

    public static void e(pw4 pw4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{pw4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && pw4Var != null && !pw4Var.h && !a(pw4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            clogBuilder.y(logType).v(pw4Var.a).q(String.valueOf(i2 + 1)).w(String.valueOf(pw4Var.b)).p(pw4Var.g);
            m11.b(clogBuilder);
            pw4Var.h = true;
            i.add(pw4Var.g);
        }
    }

    public static void g(pw4 pw4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{pw4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && pw4Var != null && !pw4Var.h && !a(pw4Var.g)) {
            boolean equals = "PB_BANNER".equals(pw4Var.a);
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            ClogBuilder y = clogBuilder.y(logType);
            int i4 = -1;
            if (equals) {
                i3 = -1;
            } else {
                i3 = i2 + 1;
            }
            ClogBuilder q = y.q(String.valueOf(i3));
            if (!equals) {
                i4 = pw4Var.b;
            }
            q.w(String.valueOf(i4)).v(pw4Var.a).r(pw4Var.d).s(pw4Var.e).t(pw4Var.c).p(pw4Var.g);
            m11.b(clogBuilder);
            pw4Var.h = true;
            i.add(pw4Var.g);
        }
    }

    public static void d(hh6 hh6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, hh6Var) == null) && hh6Var != null && hh6Var.c() != null && hh6Var.c().i != null && !hh6Var.c().i.h && !a(hh6Var.c().i.g)) {
            hh6Var.c().j = hh6Var.c().i.a;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(hh6Var.c().j).q(String.valueOf(hh6Var.c().position + 1)).w(String.valueOf(hh6Var.c().i.b)).p(hh6Var.c().i.g);
            m11.b(clogBuilder);
            pe8.b(pe8.a(hh6Var.c()));
            hh6Var.c().i.h = true;
            i.add(hh6Var.c().i.g);
        }
    }
}
