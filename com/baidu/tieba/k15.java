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
public class k15 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947860250, "Lcom/baidu/tieba/k15;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947860250, "Lcom/baidu/tieba/k15;");
                return;
            }
        }
        i = new HashSet();
    }

    public k15() {
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
        k15 k15Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) && advertAppInfo != null && (k15Var = advertAppInfo.i) != null && !k15Var.h && !a(k15Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(advertAppInfo.j).q(String.valueOf(advertAppInfo.position + 1)).r(k15Var.d).s(k15Var.e).t(k15Var.c).w(String.valueOf(k15Var.b)).p(advertAppInfo.g);
            n31.b(clogBuilder);
            qo8.b(qo8.a(advertAppInfo));
            k15Var.h = true;
            i.add(k15Var.g);
        }
    }

    public static void f(dy9 dy9Var) {
        k15 k15Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, dy9Var) == null) && dy9Var != null && dy9Var.getAdvertAppInfo() != null && (k15Var = dy9Var.getAdvertAppInfo().i) != null && !k15Var.h && !a(k15Var.g)) {
            dy9Var.e1 = k15Var.d;
            dy9Var.f1 = k15Var.e;
            dy9Var.d1 = k15Var.c;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).q(String.valueOf(dy9Var.j1 + 1)).w(String.valueOf(dy9Var.h1)).v(k15Var.a).r(k15Var.d).s(k15Var.e).t(k15Var.c).p(k15Var.g);
            n31.b(clogBuilder);
            k15Var.h = true;
            i.add(k15Var.g);
        }
    }

    public static void c(k15 k15Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{k15Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && k15Var != null && !k15Var.h && !a(k15Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            clogBuilder.y(logType).v(k15Var.a).q(String.valueOf(i2 + 1)).r(k15Var.d).s(k15Var.e).t(k15Var.c).w(String.valueOf(k15Var.b)).p(k15Var.g);
            n31.b(clogBuilder);
            k15Var.h = true;
            i.add(k15Var.g);
        }
    }

    public static void e(k15 k15Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{k15Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && k15Var != null && !k15Var.h && !a(k15Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            clogBuilder.y(logType).v(k15Var.a).q(String.valueOf(i2 + 1)).w(String.valueOf(k15Var.b)).p(k15Var.g);
            n31.b(clogBuilder);
            k15Var.h = true;
            i.add(k15Var.g);
        }
    }

    public static void g(k15 k15Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{k15Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && k15Var != null && !k15Var.h && !a(k15Var.g)) {
            boolean equals = "PB_BANNER".equals(k15Var.a);
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
                i4 = k15Var.b;
            }
            q.w(String.valueOf(i4)).v(k15Var.a).r(k15Var.d).s(k15Var.e).t(k15Var.c).p(k15Var.g);
            n31.b(clogBuilder);
            k15Var.h = true;
            i.add(k15Var.g);
        }
    }

    public static void d(oo6 oo6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, oo6Var) == null) && oo6Var != null && oo6Var.c() != null && oo6Var.c().i != null && !oo6Var.c().i.h && !a(oo6Var.c().i.g)) {
            oo6Var.c().j = oo6Var.c().i.a;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(oo6Var.c().j).q(String.valueOf(oo6Var.c().position + 1)).w(String.valueOf(oo6Var.c().i.b)).p(oo6Var.c().i.g);
            n31.b(clogBuilder);
            qo8.b(qo8.a(oo6Var.c()));
            oo6Var.c().i.h = true;
            i.add(oo6Var.c().i.g);
        }
    }
}
