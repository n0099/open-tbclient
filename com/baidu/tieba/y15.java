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
/* loaded from: classes8.dex */
public class y15 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948277324, "Lcom/baidu/tieba/y15;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948277324, "Lcom/baidu/tieba/y15;");
                return;
            }
        }
        i = new HashSet();
    }

    public y15() {
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
        y15 y15Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) && advertAppInfo != null && (y15Var = advertAppInfo.i) != null && !y15Var.h && !a(y15Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(advertAppInfo.j).q(String.valueOf(advertAppInfo.position + 1)).r(y15Var.d).s(y15Var.e).t(y15Var.c).w(String.valueOf(y15Var.b)).p(advertAppInfo.g);
            n41.e(clogBuilder);
            b09.b(b09.a(advertAppInfo));
            y15Var.h = true;
            i.add(y15Var.g);
        }
    }

    public static void d(AdvertAppInfo advertAppInfo) {
        y15 y15Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, advertAppInfo) == null) && advertAppInfo != null && (y15Var = advertAppInfo.i) != null && !y15Var.h && !a(y15Var.g)) {
            advertAppInfo.j = advertAppInfo.i.a;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(advertAppInfo.j).q(String.valueOf(advertAppInfo.position + 1)).w(String.valueOf(advertAppInfo.i.b)).p(advertAppInfo.i.g);
            n41.e(clogBuilder);
            b09.b(b09.a(advertAppInfo));
            y15 y15Var2 = advertAppInfo.i;
            y15Var2.h = true;
            i.add(y15Var2.g);
        }
    }

    public static void g(xca xcaVar) {
        y15 y15Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, null, xcaVar) == null) && xcaVar != null && xcaVar.getAdvertAppInfo() != null && (y15Var = xcaVar.getAdvertAppInfo().i) != null && !y15Var.h && !a(y15Var.g)) {
            xcaVar.j1 = y15Var.d;
            xcaVar.k1 = y15Var.e;
            xcaVar.i1 = y15Var.c;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).q(String.valueOf(xcaVar.o1 + 1)).w(String.valueOf(xcaVar.m1)).v(y15Var.a).r(y15Var.d).s(y15Var.e).t(y15Var.c).p(y15Var.g);
            n41.e(clogBuilder);
            y15Var.h = true;
            i.add(y15Var.g);
        }
    }

    public static void c(y15 y15Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{y15Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && y15Var != null && !y15Var.h && !a(y15Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            clogBuilder.y(logType).v(y15Var.a).q(String.valueOf(i2 + 1)).r(y15Var.d).s(y15Var.e).t(y15Var.c).w(String.valueOf(y15Var.b)).p(y15Var.g);
            n41.e(clogBuilder);
            y15Var.h = true;
            i.add(y15Var.g);
        }
    }

    public static void f(y15 y15Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{y15Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && y15Var != null && !y15Var.h && !a(y15Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            clogBuilder.y(logType).v(y15Var.a).q(String.valueOf(i2 + 1)).w(String.valueOf(y15Var.b)).p(y15Var.g);
            n41.e(clogBuilder);
            y15Var.h = true;
            i.add(y15Var.g);
        }
    }

    public static void h(y15 y15Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{y15Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && y15Var != null && !y15Var.h && !a(y15Var.g)) {
            boolean equals = "PB_BANNER".equals(y15Var.a);
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
                i4 = y15Var.b;
            }
            q.w(String.valueOf(i4)).v(y15Var.a).r(y15Var.d).s(y15Var.e).t(y15Var.c).p(y15Var.g);
            n41.e(clogBuilder);
            y15Var.h = true;
            i.add(y15Var.g);
        }
    }

    public static void e(eq6 eq6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, eq6Var) == null) && eq6Var != null && eq6Var.c() != null && eq6Var.c().i != null && !eq6Var.c().i.h && !a(eq6Var.c().i.g)) {
            eq6Var.c().j = eq6Var.c().i.a;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(eq6Var.c().j).q(String.valueOf(eq6Var.c().position + 1)).w(String.valueOf(eq6Var.c().i.b)).p(eq6Var.c().i.g);
            n41.e(clogBuilder);
            b09.b(b09.a(eq6Var.c()));
            eq6Var.c().i.h = true;
            i.add(eq6Var.c().i.g);
        }
    }
}
