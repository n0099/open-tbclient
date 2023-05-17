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
public class oy4 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948048575, "Lcom/baidu/tieba/oy4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948048575, "Lcom/baidu/tieba/oy4;");
                return;
            }
        }
        i = new HashSet();
    }

    public oy4() {
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
        oy4 oy4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) && advertAppInfo != null && (oy4Var = advertAppInfo.i) != null && !oy4Var.h && !a(oy4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(advertAppInfo.j).q(String.valueOf(advertAppInfo.position + 1)).r(oy4Var.d).s(oy4Var.e).t(oy4Var.c).w(String.valueOf(oy4Var.b)).p(advertAppInfo.g);
            e21.b(clogBuilder);
            si8.b(si8.a(advertAppInfo));
            oy4Var.h = true;
            i.add(oy4Var.g);
        }
    }

    public static void f(qr9 qr9Var) {
        oy4 oy4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, qr9Var) == null) && qr9Var != null && qr9Var.getAdvertAppInfo() != null && (oy4Var = qr9Var.getAdvertAppInfo().i) != null && !oy4Var.h && !a(oy4Var.g)) {
            qr9Var.e1 = oy4Var.d;
            qr9Var.f1 = oy4Var.e;
            qr9Var.d1 = oy4Var.c;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).q(String.valueOf(qr9Var.j1 + 1)).w(String.valueOf(qr9Var.h1)).v(oy4Var.a).r(oy4Var.d).s(oy4Var.e).t(oy4Var.c).p(oy4Var.g);
            e21.b(clogBuilder);
            oy4Var.h = true;
            i.add(oy4Var.g);
        }
    }

    public static void c(oy4 oy4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{oy4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && oy4Var != null && !oy4Var.h && !a(oy4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            clogBuilder.y(logType).v(oy4Var.a).q(String.valueOf(i2 + 1)).r(oy4Var.d).s(oy4Var.e).t(oy4Var.c).w(String.valueOf(oy4Var.b)).p(oy4Var.g);
            e21.b(clogBuilder);
            oy4Var.h = true;
            i.add(oy4Var.g);
        }
    }

    public static void e(oy4 oy4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{oy4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && oy4Var != null && !oy4Var.h && !a(oy4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            clogBuilder.y(logType).v(oy4Var.a).q(String.valueOf(i2 + 1)).w(String.valueOf(oy4Var.b)).p(oy4Var.g);
            e21.b(clogBuilder);
            oy4Var.h = true;
            i.add(oy4Var.g);
        }
    }

    public static void g(oy4 oy4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{oy4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && oy4Var != null && !oy4Var.h && !a(oy4Var.g)) {
            boolean equals = "PB_BANNER".equals(oy4Var.a);
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
                i4 = oy4Var.b;
            }
            q.w(String.valueOf(i4)).v(oy4Var.a).r(oy4Var.d).s(oy4Var.e).t(oy4Var.c).p(oy4Var.g);
            e21.b(clogBuilder);
            oy4Var.h = true;
            i.add(oy4Var.g);
        }
    }

    public static void d(ek6 ek6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, ek6Var) == null) && ek6Var != null && ek6Var.c() != null && ek6Var.c().i != null && !ek6Var.c().i.h && !a(ek6Var.c().i.g)) {
            ek6Var.c().j = ek6Var.c().i.a;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(ek6Var.c().j).q(String.valueOf(ek6Var.c().position + 1)).w(String.valueOf(ek6Var.c().i.b)).p(ek6Var.c().i.g);
            e21.b(clogBuilder);
            si8.b(si8.a(ek6Var.c()));
            ek6Var.c().i.h = true;
            i.add(ek6Var.c().i.g);
        }
    }
}
