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
public class yr4 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948339758, "Lcom/baidu/tieba/yr4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948339758, "Lcom/baidu/tieba/yr4;");
                return;
            }
        }
        i = new HashSet();
    }

    public yr4() {
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
        yr4 yr4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) && advertAppInfo != null && (yr4Var = advertAppInfo.i) != null && !yr4Var.h && !a(yr4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(advertAppInfo.j).q(String.valueOf(advertAppInfo.position + 1)).r(yr4Var.d).s(yr4Var.e).t(yr4Var.c).w(String.valueOf(yr4Var.b)).p(advertAppInfo.g);
            a11.b(clogBuilder);
            cj7.b(cj7.a(advertAppInfo));
            yr4Var.h = true;
            i.add(yr4Var.g);
        }
    }

    public static void f(lp8 lp8Var) {
        yr4 yr4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, lp8Var) == null) && lp8Var != null && lp8Var.getAdvertAppInfo() != null && (yr4Var = lp8Var.getAdvertAppInfo().i) != null && !yr4Var.h && !a(yr4Var.g)) {
            lp8Var.Z0 = yr4Var.d;
            lp8Var.a1 = yr4Var.e;
            lp8Var.Y0 = yr4Var.c;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).q(String.valueOf(lp8Var.e1 + 1)).w(String.valueOf(lp8Var.c1)).v(yr4Var.a).r(yr4Var.d).s(yr4Var.e).t(yr4Var.c).p(yr4Var.g);
            a11.b(clogBuilder);
            yr4Var.h = true;
            i.add(yr4Var.g);
        }
    }

    public static void c(yr4 yr4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{yr4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && yr4Var != null && !yr4Var.h && !a(yr4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            clogBuilder.y(logType).v(yr4Var.a).q(String.valueOf(i2 + 1)).r(yr4Var.d).s(yr4Var.e).t(yr4Var.c).w(String.valueOf(yr4Var.b)).p(yr4Var.g);
            a11.b(clogBuilder);
            yr4Var.h = true;
            i.add(yr4Var.g);
        }
    }

    public static void e(yr4 yr4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{yr4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && yr4Var != null && !yr4Var.h && !a(yr4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            clogBuilder.y(logType).v(yr4Var.a).q(String.valueOf(i2 + 1)).w(String.valueOf(yr4Var.b)).p(yr4Var.g);
            a11.b(clogBuilder);
            yr4Var.h = true;
            i.add(yr4Var.g);
        }
    }

    public static void g(yr4 yr4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{yr4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && yr4Var != null && !yr4Var.h && !a(yr4Var.g)) {
            boolean equals = "PB_BANNER".equals(yr4Var.a);
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
                i4 = yr4Var.b;
            }
            q.w(String.valueOf(i4)).v(yr4Var.a).r(yr4Var.d).s(yr4Var.e).t(yr4Var.c).p(yr4Var.g);
            a11.b(clogBuilder);
            yr4Var.h = true;
            i.add(yr4Var.g);
        }
    }

    public static void d(v46 v46Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, v46Var) == null) && v46Var != null && v46Var.c() != null && v46Var.c().i != null && !v46Var.c().i.h && !a(v46Var.c().i.g)) {
            v46Var.c().j = v46Var.c().i.a;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(v46Var.c().j).q(String.valueOf(v46Var.c().position + 1)).w(String.valueOf(v46Var.c().i.b)).p(v46Var.c().i.g);
            a11.b(clogBuilder);
            cj7.b(cj7.a(v46Var.c()));
            v46Var.c().i.h = true;
            i.add(v46Var.c().i.g);
        }
    }
}
