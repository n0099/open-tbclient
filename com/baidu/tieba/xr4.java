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
public class xr4 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948309967, "Lcom/baidu/tieba/xr4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948309967, "Lcom/baidu/tieba/xr4;");
                return;
            }
        }
        i = new HashSet();
    }

    public xr4() {
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
        xr4 xr4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) && advertAppInfo != null && (xr4Var = advertAppInfo.i) != null && !xr4Var.h && !a(xr4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(advertAppInfo.j).q(String.valueOf(advertAppInfo.position + 1)).r(xr4Var.d).s(xr4Var.e).t(xr4Var.c).w(String.valueOf(xr4Var.b)).p(advertAppInfo.g);
            a11.b(clogBuilder);
            bj7.b(bj7.a(advertAppInfo));
            xr4Var.h = true;
            i.add(xr4Var.g);
        }
    }

    public static void f(kp8 kp8Var) {
        xr4 xr4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, kp8Var) == null) && kp8Var != null && kp8Var.getAdvertAppInfo() != null && (xr4Var = kp8Var.getAdvertAppInfo().i) != null && !xr4Var.h && !a(xr4Var.g)) {
            kp8Var.Z0 = xr4Var.d;
            kp8Var.a1 = xr4Var.e;
            kp8Var.Y0 = xr4Var.c;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).q(String.valueOf(kp8Var.e1 + 1)).w(String.valueOf(kp8Var.c1)).v(xr4Var.a).r(xr4Var.d).s(xr4Var.e).t(xr4Var.c).p(xr4Var.g);
            a11.b(clogBuilder);
            xr4Var.h = true;
            i.add(xr4Var.g);
        }
    }

    public static void c(xr4 xr4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{xr4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && xr4Var != null && !xr4Var.h && !a(xr4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            clogBuilder.y(logType).v(xr4Var.a).q(String.valueOf(i2 + 1)).r(xr4Var.d).s(xr4Var.e).t(xr4Var.c).w(String.valueOf(xr4Var.b)).p(xr4Var.g);
            a11.b(clogBuilder);
            xr4Var.h = true;
            i.add(xr4Var.g);
        }
    }

    public static void e(xr4 xr4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{xr4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && xr4Var != null && !xr4Var.h && !a(xr4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            clogBuilder.y(logType).v(xr4Var.a).q(String.valueOf(i2 + 1)).w(String.valueOf(xr4Var.b)).p(xr4Var.g);
            a11.b(clogBuilder);
            xr4Var.h = true;
            i.add(xr4Var.g);
        }
    }

    public static void g(xr4 xr4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{xr4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && xr4Var != null && !xr4Var.h && !a(xr4Var.g)) {
            boolean equals = "PB_BANNER".equals(xr4Var.a);
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
                i4 = xr4Var.b;
            }
            q.w(String.valueOf(i4)).v(xr4Var.a).r(xr4Var.d).s(xr4Var.e).t(xr4Var.c).p(xr4Var.g);
            a11.b(clogBuilder);
            xr4Var.h = true;
            i.add(xr4Var.g);
        }
    }

    public static void d(u46 u46Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, u46Var) == null) && u46Var != null && u46Var.c() != null && u46Var.c().i != null && !u46Var.c().i.h && !a(u46Var.c().i.g)) {
            u46Var.c().j = u46Var.c().i.a;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(u46Var.c().j).q(String.valueOf(u46Var.c().position + 1)).w(String.valueOf(u46Var.c().i.b)).p(u46Var.c().i.g);
            a11.b(clogBuilder);
            bj7.b(bj7.a(u46Var.c()));
            u46Var.c().i.h = true;
            i.add(u46Var.c().i.g);
        }
    }
}
