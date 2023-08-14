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
public class v05 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948186990, "Lcom/baidu/tieba/v05;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948186990, "Lcom/baidu/tieba/v05;");
                return;
            }
        }
        i = new HashSet();
    }

    public v05() {
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
        v05 v05Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) && advertAppInfo != null && (v05Var = advertAppInfo.i) != null && !v05Var.h && !a(v05Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(advertAppInfo.j).q(String.valueOf(advertAppInfo.position + 1)).r(v05Var.d).s(v05Var.e).t(v05Var.c).w(String.valueOf(v05Var.b)).p(advertAppInfo.g);
            q31.e(clogBuilder);
            yx8.b(yx8.a(advertAppInfo));
            v05Var.h = true;
            i.add(v05Var.g);
        }
    }

    public static void d(AdvertAppInfo advertAppInfo) {
        v05 v05Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, advertAppInfo) == null) && advertAppInfo != null && (v05Var = advertAppInfo.i) != null && !v05Var.h && !a(v05Var.g)) {
            advertAppInfo.j = advertAppInfo.i.a;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(advertAppInfo.j).q(String.valueOf(advertAppInfo.position + 1)).w(String.valueOf(advertAppInfo.i.b)).p(advertAppInfo.i.g);
            q31.e(clogBuilder);
            yx8.b(yx8.a(advertAppInfo));
            v05 v05Var2 = advertAppInfo.i;
            v05Var2.h = true;
            i.add(v05Var2.g);
        }
    }

    public static void g(qba qbaVar) {
        v05 v05Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, null, qbaVar) == null) && qbaVar != null && qbaVar.getAdvertAppInfo() != null && (v05Var = qbaVar.getAdvertAppInfo().i) != null && !v05Var.h && !a(v05Var.g)) {
            qbaVar.i1 = v05Var.d;
            qbaVar.j1 = v05Var.e;
            qbaVar.h1 = v05Var.c;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).q(String.valueOf(qbaVar.n1 + 1)).w(String.valueOf(qbaVar.l1)).v(v05Var.a).r(v05Var.d).s(v05Var.e).t(v05Var.c).p(v05Var.g);
            q31.e(clogBuilder);
            v05Var.h = true;
            i.add(v05Var.g);
        }
    }

    public static void c(v05 v05Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{v05Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && v05Var != null && !v05Var.h && !a(v05Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            clogBuilder.y(logType).v(v05Var.a).q(String.valueOf(i2 + 1)).r(v05Var.d).s(v05Var.e).t(v05Var.c).w(String.valueOf(v05Var.b)).p(v05Var.g);
            q31.e(clogBuilder);
            v05Var.h = true;
            i.add(v05Var.g);
        }
    }

    public static void f(v05 v05Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{v05Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && v05Var != null && !v05Var.h && !a(v05Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            clogBuilder.y(logType).v(v05Var.a).q(String.valueOf(i2 + 1)).w(String.valueOf(v05Var.b)).p(v05Var.g);
            q31.e(clogBuilder);
            v05Var.h = true;
            i.add(v05Var.g);
        }
    }

    public static void h(v05 v05Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{v05Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && v05Var != null && !v05Var.h && !a(v05Var.g)) {
            boolean equals = "PB_BANNER".equals(v05Var.a);
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
                i4 = v05Var.b;
            }
            q.w(String.valueOf(i4)).v(v05Var.a).r(v05Var.d).s(v05Var.e).t(v05Var.c).p(v05Var.g);
            q31.e(clogBuilder);
            v05Var.h = true;
            i.add(v05Var.g);
        }
    }

    public static void e(mn6 mn6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, mn6Var) == null) && mn6Var != null && mn6Var.c() != null && mn6Var.c().i != null && !mn6Var.c().i.h && !a(mn6Var.c().i.g)) {
            mn6Var.c().j = mn6Var.c().i.a;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(mn6Var.c().j).q(String.valueOf(mn6Var.c().position + 1)).w(String.valueOf(mn6Var.c().i.b)).p(mn6Var.c().i.g);
            q31.e(clogBuilder);
            yx8.b(yx8.a(mn6Var.c()));
            mn6Var.c().i.h = true;
            i.add(mn6Var.c().i.g);
        }
    }
}
