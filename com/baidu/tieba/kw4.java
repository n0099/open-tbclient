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
/* loaded from: classes7.dex */
public class kw4 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947927489, "Lcom/baidu/tieba/kw4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947927489, "Lcom/baidu/tieba/kw4;");
                return;
            }
        }
        i = new HashSet();
    }

    public kw4() {
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
        kw4 kw4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) && advertAppInfo != null && (kw4Var = advertAppInfo.i) != null && !kw4Var.h && !a(kw4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(advertAppInfo.j).q(String.valueOf(advertAppInfo.position + 1)).r(kw4Var.d).s(kw4Var.e).t(kw4Var.c).w(String.valueOf(kw4Var.b)).p(advertAppInfo.g);
            dz0.e(clogBuilder);
            yf9.b(yf9.a(advertAppInfo));
            kw4Var.h = true;
            i.add(kw4Var.g);
        }
    }

    public static void d(AdvertAppInfo advertAppInfo) {
        kw4 kw4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, advertAppInfo) == null) && advertAppInfo != null && (kw4Var = advertAppInfo.i) != null && !kw4Var.h && !a(kw4Var.g)) {
            advertAppInfo.j = advertAppInfo.i.a;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(advertAppInfo.j).q(String.valueOf(advertAppInfo.position + 1)).w(String.valueOf(advertAppInfo.i.b)).p(advertAppInfo.i.g);
            dz0.e(clogBuilder);
            yf9.b(yf9.a(advertAppInfo));
            kw4 kw4Var2 = advertAppInfo.i;
            kw4Var2.h = true;
            i.add(kw4Var2.g);
        }
    }

    public static void g(lwa lwaVar) {
        kw4 kw4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, null, lwaVar) == null) && lwaVar != null && lwaVar.getAdvertAppInfo() != null && (kw4Var = lwaVar.getAdvertAppInfo().i) != null && !kw4Var.h && !a(kw4Var.g)) {
            lwaVar.l1 = kw4Var.d;
            lwaVar.m1 = kw4Var.e;
            lwaVar.k1 = kw4Var.c;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).q(String.valueOf(lwaVar.q1 + 1)).w(String.valueOf(lwaVar.o1)).v(kw4Var.a).r(kw4Var.d).s(kw4Var.e).t(kw4Var.c).p(kw4Var.g);
            dz0.e(clogBuilder);
            kw4Var.h = true;
            i.add(kw4Var.g);
        }
    }

    public static void c(kw4 kw4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{kw4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && kw4Var != null && !kw4Var.h && !a(kw4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            clogBuilder.y(logType).v(kw4Var.a).q(String.valueOf(i2 + 1)).r(kw4Var.d).s(kw4Var.e).t(kw4Var.c).w(String.valueOf(kw4Var.b)).p(kw4Var.g);
            dz0.e(clogBuilder);
            kw4Var.h = true;
            i.add(kw4Var.g);
        }
    }

    public static void f(kw4 kw4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{kw4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && kw4Var != null && !kw4Var.h && !a(kw4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            clogBuilder.y(logType).v(kw4Var.a).q(String.valueOf(i2 + 1)).w(String.valueOf(kw4Var.b)).p(kw4Var.g);
            dz0.e(clogBuilder);
            kw4Var.h = true;
            i.add(kw4Var.g);
        }
    }

    public static void h(kw4 kw4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{kw4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && kw4Var != null && !kw4Var.h && !a(kw4Var.g)) {
            boolean equals = "PB_BANNER".equals(kw4Var.a);
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
                i4 = kw4Var.b;
            }
            q.w(String.valueOf(i4)).v(kw4Var.a).r(kw4Var.d).s(kw4Var.e).t(kw4Var.c).p(kw4Var.g);
            dz0.e(clogBuilder);
            kw4Var.h = true;
            i.add(kw4Var.g);
        }
    }

    public static void e(wm6 wm6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, wm6Var) == null) && wm6Var != null && wm6Var.c() != null && wm6Var.c().i != null && !wm6Var.c().i.h && !a(wm6Var.c().i.g)) {
            wm6Var.c().j = wm6Var.c().i.a;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(wm6Var.c().j).q(String.valueOf(wm6Var.c().position + 1)).w(String.valueOf(wm6Var.c().i.b)).p(wm6Var.c().i.g);
            dz0.e(clogBuilder);
            yf9.b(yf9.a(wm6Var.c()));
            wm6Var.c().i.h = true;
            i.add(wm6Var.c().i.g);
        }
    }
}
