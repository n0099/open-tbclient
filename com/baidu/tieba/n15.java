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
public class n15 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947949623, "Lcom/baidu/tieba/n15;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947949623, "Lcom/baidu/tieba/n15;");
                return;
            }
        }
        i = new HashSet();
    }

    public n15() {
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
        n15 n15Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) && advertAppInfo != null && (n15Var = advertAppInfo.i) != null && !n15Var.h && !a(n15Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(advertAppInfo.j).q(String.valueOf(advertAppInfo.position + 1)).r(n15Var.d).s(n15Var.e).t(n15Var.c).w(String.valueOf(n15Var.b)).p(advertAppInfo.g);
            o31.b(clogBuilder);
            np8.b(np8.a(advertAppInfo));
            n15Var.h = true;
            i.add(n15Var.g);
        }
    }

    public static void f(a0a a0aVar) {
        n15 n15Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, a0aVar) == null) && a0aVar != null && a0aVar.getAdvertAppInfo() != null && (n15Var = a0aVar.getAdvertAppInfo().i) != null && !n15Var.h && !a(n15Var.g)) {
            a0aVar.j1 = n15Var.d;
            a0aVar.k1 = n15Var.e;
            a0aVar.i1 = n15Var.c;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).q(String.valueOf(a0aVar.o1 + 1)).w(String.valueOf(a0aVar.m1)).v(n15Var.a).r(n15Var.d).s(n15Var.e).t(n15Var.c).p(n15Var.g);
            o31.b(clogBuilder);
            n15Var.h = true;
            i.add(n15Var.g);
        }
    }

    public static void c(n15 n15Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{n15Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && n15Var != null && !n15Var.h && !a(n15Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            clogBuilder.y(logType).v(n15Var.a).q(String.valueOf(i2 + 1)).r(n15Var.d).s(n15Var.e).t(n15Var.c).w(String.valueOf(n15Var.b)).p(n15Var.g);
            o31.b(clogBuilder);
            n15Var.h = true;
            i.add(n15Var.g);
        }
    }

    public static void e(n15 n15Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{n15Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && n15Var != null && !n15Var.h && !a(n15Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            clogBuilder.y(logType).v(n15Var.a).q(String.valueOf(i2 + 1)).w(String.valueOf(n15Var.b)).p(n15Var.g);
            o31.b(clogBuilder);
            n15Var.h = true;
            i.add(n15Var.g);
        }
    }

    public static void g(n15 n15Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{n15Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && n15Var != null && !n15Var.h && !a(n15Var.g)) {
            boolean equals = "PB_BANNER".equals(n15Var.a);
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
                i4 = n15Var.b;
            }
            q.w(String.valueOf(i4)).v(n15Var.a).r(n15Var.d).s(n15Var.e).t(n15Var.c).p(n15Var.g);
            o31.b(clogBuilder);
            n15Var.h = true;
            i.add(n15Var.g);
        }
    }

    public static void d(vo6 vo6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, vo6Var) == null) && vo6Var != null && vo6Var.c() != null && vo6Var.c().i != null && !vo6Var.c().i.h && !a(vo6Var.c().i.g)) {
            vo6Var.c().j = vo6Var.c().i.a;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(vo6Var.c().j).q(String.valueOf(vo6Var.c().position + 1)).w(String.valueOf(vo6Var.c().i.b)).p(vo6Var.c().i.g);
            o31.b(clogBuilder);
            np8.b(np8.a(vo6Var.c()));
            vo6Var.c().i.h = true;
            i.add(vo6Var.c().i.g);
        }
    }
}
