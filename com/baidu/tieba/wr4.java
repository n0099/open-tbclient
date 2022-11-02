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
public class wr4 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948280176, "Lcom/baidu/tieba/wr4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948280176, "Lcom/baidu/tieba/wr4;");
                return;
            }
        }
        i = new HashSet();
    }

    public wr4() {
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
        wr4 wr4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) && advertAppInfo != null && (wr4Var = advertAppInfo.i) != null && !wr4Var.h && !a(wr4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(advertAppInfo.j).q(String.valueOf(advertAppInfo.position + 1)).r(wr4Var.d).s(wr4Var.e).t(wr4Var.c).w(String.valueOf(wr4Var.b)).p(advertAppInfo.g);
            z01.b(clogBuilder);
            qi7.b(qi7.a(advertAppInfo));
            wr4Var.h = true;
            i.add(wr4Var.g);
        }
    }

    public static void f(zo8 zo8Var) {
        wr4 wr4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, zo8Var) == null) && zo8Var != null && zo8Var.getAdvertAppInfo() != null && (wr4Var = zo8Var.getAdvertAppInfo().i) != null && !wr4Var.h && !a(wr4Var.g)) {
            zo8Var.Y0 = wr4Var.d;
            zo8Var.Z0 = wr4Var.e;
            zo8Var.X0 = wr4Var.c;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).q(String.valueOf(zo8Var.d1 + 1)).w(String.valueOf(zo8Var.b1)).v(wr4Var.a).r(wr4Var.d).s(wr4Var.e).t(wr4Var.c).p(wr4Var.g);
            z01.b(clogBuilder);
            wr4Var.h = true;
            i.add(wr4Var.g);
        }
    }

    public static void c(wr4 wr4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{wr4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && wr4Var != null && !wr4Var.h && !a(wr4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            clogBuilder.y(logType).v(wr4Var.a).q(String.valueOf(i2 + 1)).r(wr4Var.d).s(wr4Var.e).t(wr4Var.c).w(String.valueOf(wr4Var.b)).p(wr4Var.g);
            z01.b(clogBuilder);
            wr4Var.h = true;
            i.add(wr4Var.g);
        }
    }

    public static void e(wr4 wr4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{wr4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && wr4Var != null && !wr4Var.h && !a(wr4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            clogBuilder.y(logType).v(wr4Var.a).q(String.valueOf(i2 + 1)).w(String.valueOf(wr4Var.b)).p(wr4Var.g);
            z01.b(clogBuilder);
            wr4Var.h = true;
            i.add(wr4Var.g);
        }
    }

    public static void g(wr4 wr4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{wr4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && wr4Var != null && !wr4Var.h && !a(wr4Var.g)) {
            boolean equals = "PB_BANNER".equals(wr4Var.a);
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
                i4 = wr4Var.b;
            }
            q.w(String.valueOf(i4)).v(wr4Var.a).r(wr4Var.d).s(wr4Var.e).t(wr4Var.c).p(wr4Var.g);
            z01.b(clogBuilder);
            wr4Var.h = true;
            i.add(wr4Var.g);
        }
    }

    public static void d(i46 i46Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, i46Var) == null) && i46Var != null && i46Var.c() != null && i46Var.c().i != null && !i46Var.c().i.h && !a(i46Var.c().i.g)) {
            i46Var.c().j = i46Var.c().i.a;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(i46Var.c().j).q(String.valueOf(i46Var.c().position + 1)).w(String.valueOf(i46Var.c().i.b)).p(i46Var.c().i.g);
            z01.b(clogBuilder);
            qi7.b(qi7.a(i46Var.c()));
            i46Var.c().i.h = true;
            i.add(i46Var.c().i.g);
        }
    }
}
