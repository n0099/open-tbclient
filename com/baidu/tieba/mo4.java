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
public class mo4 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947979383, "Lcom/baidu/tieba/mo4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947979383, "Lcom/baidu/tieba/mo4;");
                return;
            }
        }
        i = new HashSet();
    }

    public mo4() {
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
        mo4 mo4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) || advertAppInfo == null || (mo4Var = advertAppInfo.i) == null || mo4Var.h || a(mo4Var.g)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(ClogBuilder.LogType.SHOW).v(advertAppInfo.j).q(String.valueOf(advertAppInfo.position + 1)).r(mo4Var.d).s(mo4Var.e).t(mo4Var.c).w(String.valueOf(mo4Var.b)).p(advertAppInfo.g);
        iy0.b(clogBuilder);
        df7.b(df7.a(advertAppInfo));
        mo4Var.h = true;
        i.add(mo4Var.g);
    }

    public static void c(mo4 mo4Var, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{mo4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || mo4Var == null || mo4Var.h || a(mo4Var.g)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(z ? ClogBuilder.LogType.STOCK : ClogBuilder.LogType.SHOW).v(mo4Var.a).q(String.valueOf(i2 + 1)).r(mo4Var.d).s(mo4Var.e).t(mo4Var.c).w(String.valueOf(mo4Var.b)).p(mo4Var.g);
        iy0.b(clogBuilder);
        mo4Var.h = true;
        i.add(mo4Var.g);
    }

    public static void d(p06 p06Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, p06Var) == null) || p06Var == null || p06Var.c() == null || p06Var.c().i == null || p06Var.c().i.h || a(p06Var.c().i.g)) {
            return;
        }
        p06Var.c().j = p06Var.c().i.a;
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(ClogBuilder.LogType.SHOW).v(p06Var.c().j).q(String.valueOf(p06Var.c().position + 1)).w(String.valueOf(p06Var.c().i.b)).p(p06Var.c().i.g);
        iy0.b(clogBuilder);
        df7.b(df7.a(p06Var.c()));
        p06Var.c().i.h = true;
        i.add(p06Var.c().i.g);
    }

    public static void e(mo4 mo4Var, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{mo4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || mo4Var == null || mo4Var.h || a(mo4Var.g)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(z ? ClogBuilder.LogType.STOCK : ClogBuilder.LogType.SHOW).v(mo4Var.a).q(String.valueOf(i2 + 1)).w(String.valueOf(mo4Var.b)).p(mo4Var.g);
        iy0.b(clogBuilder);
        mo4Var.h = true;
        i.add(mo4Var.g);
    }

    public static void f(il8 il8Var) {
        mo4 mo4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, il8Var) == null) || il8Var == null || il8Var.getAdvertAppInfo() == null || (mo4Var = il8Var.getAdvertAppInfo().i) == null || mo4Var.h || a(mo4Var.g)) {
            return;
        }
        il8Var.W0 = mo4Var.d;
        il8Var.X0 = mo4Var.e;
        il8Var.V0 = mo4Var.c;
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(ClogBuilder.LogType.SHOW).q(String.valueOf(il8Var.b1 + 1)).w(String.valueOf(il8Var.Z0)).v(mo4Var.a).r(mo4Var.d).s(mo4Var.e).t(mo4Var.c).p(mo4Var.g);
        iy0.b(clogBuilder);
        mo4Var.h = true;
        i.add(mo4Var.g);
    }

    public static void g(mo4 mo4Var, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{mo4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || mo4Var == null || mo4Var.h || a(mo4Var.g)) {
            return;
        }
        boolean equals = "PB_BANNER".equals(mo4Var.a);
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(z ? ClogBuilder.LogType.STOCK : ClogBuilder.LogType.SHOW).q(String.valueOf(equals ? -1 : i2 + 1)).w(String.valueOf(equals ? -1 : mo4Var.b)).v(mo4Var.a).r(mo4Var.d).s(mo4Var.e).t(mo4Var.c).p(mo4Var.g);
        iy0.b(clogBuilder);
        mo4Var.h = true;
        i.add(mo4Var.g);
    }
}
