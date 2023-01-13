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
/* loaded from: classes5.dex */
public class ks4 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947923645, "Lcom/baidu/tieba/ks4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947923645, "Lcom/baidu/tieba/ks4;");
                return;
            }
        }
        i = new HashSet();
    }

    public ks4() {
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
        ks4 ks4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) && advertAppInfo != null && (ks4Var = advertAppInfo.i) != null && !ks4Var.h && !a(ks4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(advertAppInfo.j).q(String.valueOf(advertAppInfo.position + 1)).r(ks4Var.d).s(ks4Var.e).t(ks4Var.c).w(String.valueOf(ks4Var.b)).p(advertAppInfo.g);
            e11.b(clogBuilder);
            pq7.b(pq7.a(advertAppInfo));
            ks4Var.h = true;
            i.add(ks4Var.g);
        }
    }

    public static void f(hx8 hx8Var) {
        ks4 ks4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, hx8Var) == null) && hx8Var != null && hx8Var.getAdvertAppInfo() != null && (ks4Var = hx8Var.getAdvertAppInfo().i) != null && !ks4Var.h && !a(ks4Var.g)) {
            hx8Var.b1 = ks4Var.d;
            hx8Var.c1 = ks4Var.e;
            hx8Var.a1 = ks4Var.c;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).q(String.valueOf(hx8Var.g1 + 1)).w(String.valueOf(hx8Var.e1)).v(ks4Var.a).r(ks4Var.d).s(ks4Var.e).t(ks4Var.c).p(ks4Var.g);
            e11.b(clogBuilder);
            ks4Var.h = true;
            i.add(ks4Var.g);
        }
    }

    public static void c(ks4 ks4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{ks4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && ks4Var != null && !ks4Var.h && !a(ks4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            clogBuilder.y(logType).v(ks4Var.a).q(String.valueOf(i2 + 1)).r(ks4Var.d).s(ks4Var.e).t(ks4Var.c).w(String.valueOf(ks4Var.b)).p(ks4Var.g);
            e11.b(clogBuilder);
            ks4Var.h = true;
            i.add(ks4Var.g);
        }
    }

    public static void e(ks4 ks4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{ks4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && ks4Var != null && !ks4Var.h && !a(ks4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            clogBuilder.y(logType).v(ks4Var.a).q(String.valueOf(i2 + 1)).w(String.valueOf(ks4Var.b)).p(ks4Var.g);
            e11.b(clogBuilder);
            ks4Var.h = true;
            i.add(ks4Var.g);
        }
    }

    public static void g(ks4 ks4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{ks4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && ks4Var != null && !ks4Var.h && !a(ks4Var.g)) {
            boolean equals = "PB_BANNER".equals(ks4Var.a);
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
                i4 = ks4Var.b;
            }
            q.w(String.valueOf(i4)).v(ks4Var.a).r(ks4Var.d).s(ks4Var.e).t(ks4Var.c).p(ks4Var.g);
            e11.b(clogBuilder);
            ks4Var.h = true;
            i.add(ks4Var.g);
        }
    }

    public static void d(i96 i96Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, i96Var) == null) && i96Var != null && i96Var.c() != null && i96Var.c().i != null && !i96Var.c().i.h && !a(i96Var.c().i.g)) {
            i96Var.c().j = i96Var.c().i.a;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(i96Var.c().j).q(String.valueOf(i96Var.c().position + 1)).w(String.valueOf(i96Var.c().i.b)).p(i96Var.c().i.g);
            e11.b(clogBuilder);
            pq7.b(pq7.a(i96Var.c()));
            i96Var.c().i.h = true;
            i.add(i96Var.c().i.g);
        }
    }
}
