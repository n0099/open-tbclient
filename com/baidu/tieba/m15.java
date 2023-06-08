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
public class m15 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947919832, "Lcom/baidu/tieba/m15;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947919832, "Lcom/baidu/tieba/m15;");
                return;
            }
        }
        i = new HashSet();
    }

    public m15() {
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
        m15 m15Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) && advertAppInfo != null && (m15Var = advertAppInfo.i) != null && !m15Var.h && !a(m15Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(advertAppInfo.j).q(String.valueOf(advertAppInfo.position + 1)).r(m15Var.d).s(m15Var.e).t(m15Var.c).w(String.valueOf(m15Var.b)).p(advertAppInfo.g);
            n31.b(clogBuilder);
            to8.b(to8.a(advertAppInfo));
            m15Var.h = true;
            i.add(m15Var.g);
        }
    }

    public static void f(iy9 iy9Var) {
        m15 m15Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, iy9Var) == null) && iy9Var != null && iy9Var.getAdvertAppInfo() != null && (m15Var = iy9Var.getAdvertAppInfo().i) != null && !m15Var.h && !a(m15Var.g)) {
            iy9Var.e1 = m15Var.d;
            iy9Var.f1 = m15Var.e;
            iy9Var.d1 = m15Var.c;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).q(String.valueOf(iy9Var.j1 + 1)).w(String.valueOf(iy9Var.h1)).v(m15Var.a).r(m15Var.d).s(m15Var.e).t(m15Var.c).p(m15Var.g);
            n31.b(clogBuilder);
            m15Var.h = true;
            i.add(m15Var.g);
        }
    }

    public static void c(m15 m15Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{m15Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && m15Var != null && !m15Var.h && !a(m15Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            clogBuilder.y(logType).v(m15Var.a).q(String.valueOf(i2 + 1)).r(m15Var.d).s(m15Var.e).t(m15Var.c).w(String.valueOf(m15Var.b)).p(m15Var.g);
            n31.b(clogBuilder);
            m15Var.h = true;
            i.add(m15Var.g);
        }
    }

    public static void e(m15 m15Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{m15Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && m15Var != null && !m15Var.h && !a(m15Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            clogBuilder.y(logType).v(m15Var.a).q(String.valueOf(i2 + 1)).w(String.valueOf(m15Var.b)).p(m15Var.g);
            n31.b(clogBuilder);
            m15Var.h = true;
            i.add(m15Var.g);
        }
    }

    public static void g(m15 m15Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{m15Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && m15Var != null && !m15Var.h && !a(m15Var.g)) {
            boolean equals = "PB_BANNER".equals(m15Var.a);
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
                i4 = m15Var.b;
            }
            q.w(String.valueOf(i4)).v(m15Var.a).r(m15Var.d).s(m15Var.e).t(m15Var.c).p(m15Var.g);
            n31.b(clogBuilder);
            m15Var.h = true;
            i.add(m15Var.g);
        }
    }

    public static void d(qo6 qo6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, qo6Var) == null) && qo6Var != null && qo6Var.c() != null && qo6Var.c().i != null && !qo6Var.c().i.h && !a(qo6Var.c().i.g)) {
            qo6Var.c().j = qo6Var.c().i.a;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(qo6Var.c().j).q(String.valueOf(qo6Var.c().position + 1)).w(String.valueOf(qo6Var.c().i.b)).p(qo6Var.c().i.g);
            n31.b(clogBuilder);
            to8.b(to8.a(qo6Var.c()));
            qo6Var.c().i.h = true;
            i.add(qo6Var.c().i.g);
        }
    }
}
