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
public class xw4 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948314772, "Lcom/baidu/tieba/xw4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948314772, "Lcom/baidu/tieba/xw4;");
                return;
            }
        }
        i = new HashSet();
    }

    public xw4() {
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
        xw4 xw4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) && advertAppInfo != null && (xw4Var = advertAppInfo.i) != null && !xw4Var.h && !a(xw4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(advertAppInfo.j).q(String.valueOf(advertAppInfo.position + 1)).r(xw4Var.d).s(xw4Var.e).t(xw4Var.c).w(String.valueOf(xw4Var.b)).p(advertAppInfo.g);
            n21.b(clogBuilder);
            hv7.b(hv7.a(advertAppInfo));
            xw4Var.h = true;
            i.add(xw4Var.g);
        }
    }

    public static void f(j29 j29Var) {
        xw4 xw4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, j29Var) == null) && j29Var != null && j29Var.getAdvertAppInfo() != null && (xw4Var = j29Var.getAdvertAppInfo().i) != null && !xw4Var.h && !a(xw4Var.g)) {
            j29Var.c1 = xw4Var.d;
            j29Var.d1 = xw4Var.e;
            j29Var.b1 = xw4Var.c;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).q(String.valueOf(j29Var.h1 + 1)).w(String.valueOf(j29Var.f1)).v(xw4Var.a).r(xw4Var.d).s(xw4Var.e).t(xw4Var.c).p(xw4Var.g);
            n21.b(clogBuilder);
            xw4Var.h = true;
            i.add(xw4Var.g);
        }
    }

    public static void c(xw4 xw4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{xw4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && xw4Var != null && !xw4Var.h && !a(xw4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            clogBuilder.y(logType).v(xw4Var.a).q(String.valueOf(i2 + 1)).r(xw4Var.d).s(xw4Var.e).t(xw4Var.c).w(String.valueOf(xw4Var.b)).p(xw4Var.g);
            n21.b(clogBuilder);
            xw4Var.h = true;
            i.add(xw4Var.g);
        }
    }

    public static void e(xw4 xw4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{xw4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && xw4Var != null && !xw4Var.h && !a(xw4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            clogBuilder.y(logType).v(xw4Var.a).q(String.valueOf(i2 + 1)).w(String.valueOf(xw4Var.b)).p(xw4Var.g);
            n21.b(clogBuilder);
            xw4Var.h = true;
            i.add(xw4Var.g);
        }
    }

    public static void g(xw4 xw4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{xw4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && xw4Var != null && !xw4Var.h && !a(xw4Var.g)) {
            boolean equals = "PB_BANNER".equals(xw4Var.a);
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
                i4 = xw4Var.b;
            }
            q.w(String.valueOf(i4)).v(xw4Var.a).r(xw4Var.d).s(xw4Var.e).t(xw4Var.c).p(xw4Var.g);
            n21.b(clogBuilder);
            xw4Var.h = true;
            i.add(xw4Var.g);
        }
    }

    public static void d(ud6 ud6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, ud6Var) == null) && ud6Var != null && ud6Var.c() != null && ud6Var.c().i != null && !ud6Var.c().i.h && !a(ud6Var.c().i.g)) {
            ud6Var.c().j = ud6Var.c().i.a;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(ud6Var.c().j).q(String.valueOf(ud6Var.c().position + 1)).w(String.valueOf(ud6Var.c().i.b)).p(ud6Var.c().i.g);
            n21.b(clogBuilder);
            hv7.b(hv7.a(ud6Var.c()));
            ud6Var.c().i.h = true;
            i.add(ud6Var.c().i.g);
        }
    }
}
