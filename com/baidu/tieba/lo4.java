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
/* loaded from: classes4.dex */
public class lo4 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947949592, "Lcom/baidu/tieba/lo4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947949592, "Lcom/baidu/tieba/lo4;");
                return;
            }
        }
        i = new HashSet();
    }

    public lo4() {
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? i.contains(str) : invokeL.booleanValue;
    }

    public static void b(AdvertAppInfo advertAppInfo) {
        lo4 lo4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) || advertAppInfo == null || (lo4Var = advertAppInfo.i) == null || lo4Var.h || a(lo4Var.g)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(ClogBuilder.LogType.SHOW).v(advertAppInfo.j).q(String.valueOf(advertAppInfo.position + 1)).r(lo4Var.d).s(lo4Var.e).t(lo4Var.c).w(String.valueOf(lo4Var.b)).p(advertAppInfo.g);
        iy0.b(clogBuilder);
        bf7.b(bf7.a(advertAppInfo));
        lo4Var.h = true;
        i.add(lo4Var.g);
    }

    public static void c(lo4 lo4Var, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{lo4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || lo4Var == null || lo4Var.h || a(lo4Var.g)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(z ? ClogBuilder.LogType.STOCK : ClogBuilder.LogType.SHOW).v(lo4Var.a).q(String.valueOf(i2 + 1)).r(lo4Var.d).s(lo4Var.e).t(lo4Var.c).w(String.valueOf(lo4Var.b)).p(lo4Var.g);
        iy0.b(clogBuilder);
        lo4Var.h = true;
        i.add(lo4Var.g);
    }

    public static void d(n06 n06Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, n06Var) == null) || n06Var == null || n06Var.c() == null || n06Var.c().i == null || n06Var.c().i.h || a(n06Var.c().i.g)) {
            return;
        }
        n06Var.c().j = n06Var.c().i.a;
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(ClogBuilder.LogType.SHOW).v(n06Var.c().j).q(String.valueOf(n06Var.c().position + 1)).w(String.valueOf(n06Var.c().i.b)).p(n06Var.c().i.g);
        iy0.b(clogBuilder);
        bf7.b(bf7.a(n06Var.c()));
        n06Var.c().i.h = true;
        i.add(n06Var.c().i.g);
    }

    public static void e(lo4 lo4Var, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{lo4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || lo4Var == null || lo4Var.h || a(lo4Var.g)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(z ? ClogBuilder.LogType.STOCK : ClogBuilder.LogType.SHOW).v(lo4Var.a).q(String.valueOf(i2 + 1)).w(String.valueOf(lo4Var.b)).p(lo4Var.g);
        iy0.b(clogBuilder);
        lo4Var.h = true;
        i.add(lo4Var.g);
    }

    public static void f(gl8 gl8Var) {
        lo4 lo4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, gl8Var) == null) || gl8Var == null || gl8Var.getAdvertAppInfo() == null || (lo4Var = gl8Var.getAdvertAppInfo().i) == null || lo4Var.h || a(lo4Var.g)) {
            return;
        }
        gl8Var.W0 = lo4Var.d;
        gl8Var.X0 = lo4Var.e;
        gl8Var.V0 = lo4Var.c;
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(ClogBuilder.LogType.SHOW).q(String.valueOf(gl8Var.b1 + 1)).w(String.valueOf(gl8Var.Z0)).v(lo4Var.a).r(lo4Var.d).s(lo4Var.e).t(lo4Var.c).p(lo4Var.g);
        iy0.b(clogBuilder);
        lo4Var.h = true;
        i.add(lo4Var.g);
    }

    public static void g(lo4 lo4Var, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{lo4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || lo4Var == null || lo4Var.h || a(lo4Var.g)) {
            return;
        }
        boolean equals = "PB_BANNER".equals(lo4Var.a);
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(z ? ClogBuilder.LogType.STOCK : ClogBuilder.LogType.SHOW).q(String.valueOf(equals ? -1 : i2 + 1)).w(String.valueOf(equals ? -1 : lo4Var.b)).v(lo4Var.a).r(lo4Var.d).s(lo4Var.e).t(lo4Var.c).p(lo4Var.g);
        iy0.b(clogBuilder);
        lo4Var.h = true;
        i.add(lo4Var.g);
    }
}
