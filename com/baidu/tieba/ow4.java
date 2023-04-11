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
public class ow4 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948046653, "Lcom/baidu/tieba/ow4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948046653, "Lcom/baidu/tieba/ow4;");
                return;
            }
        }
        i = new HashSet();
    }

    public ow4() {
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
        ow4 ow4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) && advertAppInfo != null && (ow4Var = advertAppInfo.i) != null && !ow4Var.h && !a(ow4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(advertAppInfo.j).q(String.valueOf(advertAppInfo.position + 1)).r(ow4Var.d).s(ow4Var.e).t(ow4Var.c).w(String.valueOf(ow4Var.b)).p(advertAppInfo.g);
            l11.b(clogBuilder);
            he8.b(he8.a(advertAppInfo));
            ow4Var.h = true;
            i.add(ow4Var.g);
        }
    }

    public static void f(rl9 rl9Var) {
        ow4 ow4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, rl9Var) == null) && rl9Var != null && rl9Var.getAdvertAppInfo() != null && (ow4Var = rl9Var.getAdvertAppInfo().i) != null && !ow4Var.h && !a(ow4Var.g)) {
            rl9Var.d1 = ow4Var.d;
            rl9Var.e1 = ow4Var.e;
            rl9Var.c1 = ow4Var.c;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).q(String.valueOf(rl9Var.i1 + 1)).w(String.valueOf(rl9Var.g1)).v(ow4Var.a).r(ow4Var.d).s(ow4Var.e).t(ow4Var.c).p(ow4Var.g);
            l11.b(clogBuilder);
            ow4Var.h = true;
            i.add(ow4Var.g);
        }
    }

    public static void c(ow4 ow4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{ow4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && ow4Var != null && !ow4Var.h && !a(ow4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            clogBuilder.y(logType).v(ow4Var.a).q(String.valueOf(i2 + 1)).r(ow4Var.d).s(ow4Var.e).t(ow4Var.c).w(String.valueOf(ow4Var.b)).p(ow4Var.g);
            l11.b(clogBuilder);
            ow4Var.h = true;
            i.add(ow4Var.g);
        }
    }

    public static void e(ow4 ow4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{ow4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && ow4Var != null && !ow4Var.h && !a(ow4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            clogBuilder.y(logType).v(ow4Var.a).q(String.valueOf(i2 + 1)).w(String.valueOf(ow4Var.b)).p(ow4Var.g);
            l11.b(clogBuilder);
            ow4Var.h = true;
            i.add(ow4Var.g);
        }
    }

    public static void g(ow4 ow4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{ow4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && ow4Var != null && !ow4Var.h && !a(ow4Var.g)) {
            boolean equals = "PB_BANNER".equals(ow4Var.a);
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
                i4 = ow4Var.b;
            }
            q.w(String.valueOf(i4)).v(ow4Var.a).r(ow4Var.d).s(ow4Var.e).t(ow4Var.c).p(ow4Var.g);
            l11.b(clogBuilder);
            ow4Var.h = true;
            i.add(ow4Var.g);
        }
    }

    public static void d(gh6 gh6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, gh6Var) == null) && gh6Var != null && gh6Var.c() != null && gh6Var.c().i != null && !gh6Var.c().i.h && !a(gh6Var.c().i.g)) {
            gh6Var.c().j = gh6Var.c().i.a;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(gh6Var.c().j).q(String.valueOf(gh6Var.c().position + 1)).w(String.valueOf(gh6Var.c().i.b)).p(gh6Var.c().i.g);
            l11.b(clogBuilder);
            he8.b(he8.a(gh6Var.c()));
            gh6Var.c().i.h = true;
            i.add(gh6Var.c().i.g);
        }
    }
}
