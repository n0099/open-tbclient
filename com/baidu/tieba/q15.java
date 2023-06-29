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
public class q15 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948038996, "Lcom/baidu/tieba/q15;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948038996, "Lcom/baidu/tieba/q15;");
                return;
            }
        }
        i = new HashSet();
    }

    public q15() {
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
        q15 q15Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) && advertAppInfo != null && (q15Var = advertAppInfo.i) != null && !q15Var.h && !a(q15Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(advertAppInfo.j).q(String.valueOf(advertAppInfo.position + 1)).r(q15Var.d).s(q15Var.e).t(q15Var.c).w(String.valueOf(q15Var.b)).p(advertAppInfo.g);
            r31.b(clogBuilder);
            yt8.b(yt8.a(advertAppInfo));
            q15Var.h = true;
            i.add(q15Var.g);
        }
    }

    public static void f(m4a m4aVar) {
        q15 q15Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, m4aVar) == null) && m4aVar != null && m4aVar.getAdvertAppInfo() != null && (q15Var = m4aVar.getAdvertAppInfo().i) != null && !q15Var.h && !a(q15Var.g)) {
            m4aVar.j1 = q15Var.d;
            m4aVar.k1 = q15Var.e;
            m4aVar.i1 = q15Var.c;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).q(String.valueOf(m4aVar.o1 + 1)).w(String.valueOf(m4aVar.m1)).v(q15Var.a).r(q15Var.d).s(q15Var.e).t(q15Var.c).p(q15Var.g);
            r31.b(clogBuilder);
            q15Var.h = true;
            i.add(q15Var.g);
        }
    }

    public static void c(q15 q15Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{q15Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && q15Var != null && !q15Var.h && !a(q15Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            clogBuilder.y(logType).v(q15Var.a).q(String.valueOf(i2 + 1)).r(q15Var.d).s(q15Var.e).t(q15Var.c).w(String.valueOf(q15Var.b)).p(q15Var.g);
            r31.b(clogBuilder);
            q15Var.h = true;
            i.add(q15Var.g);
        }
    }

    public static void e(q15 q15Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{q15Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && q15Var != null && !q15Var.h && !a(q15Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            clogBuilder.y(logType).v(q15Var.a).q(String.valueOf(i2 + 1)).w(String.valueOf(q15Var.b)).p(q15Var.g);
            r31.b(clogBuilder);
            q15Var.h = true;
            i.add(q15Var.g);
        }
    }

    public static void g(q15 q15Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{q15Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && q15Var != null && !q15Var.h && !a(q15Var.g)) {
            boolean equals = "PB_BANNER".equals(q15Var.a);
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
                i4 = q15Var.b;
            }
            q.w(String.valueOf(i4)).v(q15Var.a).r(q15Var.d).s(q15Var.e).t(q15Var.c).p(q15Var.g);
            r31.b(clogBuilder);
            q15Var.h = true;
            i.add(q15Var.g);
        }
    }

    public static void d(ap6 ap6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, ap6Var) == null) && ap6Var != null && ap6Var.c() != null && ap6Var.c().i != null && !ap6Var.c().i.h && !a(ap6Var.c().i.g)) {
            ap6Var.c().j = ap6Var.c().i.a;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(ap6Var.c().j).q(String.valueOf(ap6Var.c().position + 1)).w(String.valueOf(ap6Var.c().i.b)).p(ap6Var.c().i.g);
            r31.b(clogBuilder);
            yt8.b(yt8.a(ap6Var.c()));
            ap6Var.c().i.h = true;
            i.add(ap6Var.c().i.g);
        }
    }
}
