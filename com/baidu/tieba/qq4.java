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
public class qq4 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948100469, "Lcom/baidu/tieba/qq4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948100469, "Lcom/baidu/tieba/qq4;");
                return;
            }
        }
        i = new HashSet();
    }

    public qq4() {
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
        qq4 qq4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) || advertAppInfo == null || (qq4Var = advertAppInfo.i) == null || qq4Var.h || a(qq4Var.g)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(ClogBuilder.LogType.SHOW).v(advertAppInfo.j).q(String.valueOf(advertAppInfo.position + 1)).r(qq4Var.d).s(qq4Var.e).t(qq4Var.c).w(String.valueOf(qq4Var.b)).p(advertAppInfo.g);
        uz0.b(clogBuilder);
        hg7.b(hg7.a(advertAppInfo));
        qq4Var.h = true;
        i.add(qq4Var.g);
    }

    public static void c(qq4 qq4Var, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{qq4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || qq4Var == null || qq4Var.h || a(qq4Var.g)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(z ? ClogBuilder.LogType.STOCK : ClogBuilder.LogType.SHOW).v(qq4Var.a).q(String.valueOf(i2 + 1)).r(qq4Var.d).s(qq4Var.e).t(qq4Var.c).w(String.valueOf(qq4Var.b)).p(qq4Var.g);
        uz0.b(clogBuilder);
        qq4Var.h = true;
        i.add(qq4Var.g);
    }

    public static void d(e26 e26Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, e26Var) == null) || e26Var == null || e26Var.c() == null || e26Var.c().i == null || e26Var.c().i.h || a(e26Var.c().i.g)) {
            return;
        }
        e26Var.c().j = e26Var.c().i.a;
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(ClogBuilder.LogType.SHOW).v(e26Var.c().j).q(String.valueOf(e26Var.c().position + 1)).w(String.valueOf(e26Var.c().i.b)).p(e26Var.c().i.g);
        uz0.b(clogBuilder);
        hg7.b(hg7.a(e26Var.c()));
        e26Var.c().i.h = true;
        i.add(e26Var.c().i.g);
    }

    public static void e(qq4 qq4Var, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{qq4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || qq4Var == null || qq4Var.h || a(qq4Var.g)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(z ? ClogBuilder.LogType.STOCK : ClogBuilder.LogType.SHOW).v(qq4Var.a).q(String.valueOf(i2 + 1)).w(String.valueOf(qq4Var.b)).p(qq4Var.g);
        uz0.b(clogBuilder);
        qq4Var.h = true;
        i.add(qq4Var.g);
    }

    public static void f(um8 um8Var) {
        qq4 qq4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, um8Var) == null) || um8Var == null || um8Var.getAdvertAppInfo() == null || (qq4Var = um8Var.getAdvertAppInfo().i) == null || qq4Var.h || a(qq4Var.g)) {
            return;
        }
        um8Var.W0 = qq4Var.d;
        um8Var.X0 = qq4Var.e;
        um8Var.V0 = qq4Var.c;
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(ClogBuilder.LogType.SHOW).q(String.valueOf(um8Var.b1 + 1)).w(String.valueOf(um8Var.Z0)).v(qq4Var.a).r(qq4Var.d).s(qq4Var.e).t(qq4Var.c).p(qq4Var.g);
        uz0.b(clogBuilder);
        qq4Var.h = true;
        i.add(qq4Var.g);
    }

    public static void g(qq4 qq4Var, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{qq4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || qq4Var == null || qq4Var.h || a(qq4Var.g)) {
            return;
        }
        boolean equals = "PB_BANNER".equals(qq4Var.a);
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(z ? ClogBuilder.LogType.STOCK : ClogBuilder.LogType.SHOW).q(String.valueOf(equals ? -1 : i2 + 1)).w(String.valueOf(equals ? -1 : qq4Var.b)).v(qq4Var.a).r(qq4Var.d).s(qq4Var.e).t(qq4Var.c).p(qq4Var.g);
        uz0.b(clogBuilder);
        qq4Var.h = true;
        i.add(qq4Var.g);
    }
}
