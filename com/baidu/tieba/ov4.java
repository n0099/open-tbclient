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
public class ov4 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948045692, "Lcom/baidu/tieba/ov4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948045692, "Lcom/baidu/tieba/ov4;");
                return;
            }
        }
        i = new HashSet();
    }

    public ov4() {
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
        ov4 ov4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) && advertAppInfo != null && (ov4Var = advertAppInfo.i) != null && !ov4Var.h && !a(ov4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(advertAppInfo.j).q(String.valueOf(advertAppInfo.position + 1)).r(ov4Var.d).s(ov4Var.e).t(ov4Var.c).w(String.valueOf(ov4Var.b)).p(advertAppInfo.g);
            jy0.e(clogBuilder);
            zy8.b(zy8.a(advertAppInfo));
            ov4Var.h = true;
            i.add(ov4Var.g);
        }
    }

    public static void d(AdvertAppInfo advertAppInfo) {
        ov4 ov4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, advertAppInfo) == null) && advertAppInfo != null && (ov4Var = advertAppInfo.i) != null && !ov4Var.h && !a(ov4Var.g)) {
            advertAppInfo.j = advertAppInfo.i.a;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(advertAppInfo.j).q(String.valueOf(advertAppInfo.position + 1)).w(String.valueOf(advertAppInfo.i.b)).p(advertAppInfo.i.g);
            jy0.e(clogBuilder);
            zy8.b(zy8.a(advertAppInfo));
            ov4 ov4Var2 = advertAppInfo.i;
            ov4Var2.h = true;
            i.add(ov4Var2.g);
        }
    }

    public static void g(oea oeaVar) {
        ov4 ov4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, null, oeaVar) == null) && oeaVar != null && oeaVar.getAdvertAppInfo() != null && (ov4Var = oeaVar.getAdvertAppInfo().i) != null && !ov4Var.h && !a(ov4Var.g)) {
            oeaVar.j1 = ov4Var.d;
            oeaVar.k1 = ov4Var.e;
            oeaVar.i1 = ov4Var.c;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).q(String.valueOf(oeaVar.o1 + 1)).w(String.valueOf(oeaVar.m1)).v(ov4Var.a).r(ov4Var.d).s(ov4Var.e).t(ov4Var.c).p(ov4Var.g);
            jy0.e(clogBuilder);
            ov4Var.h = true;
            i.add(ov4Var.g);
        }
    }

    public static void c(ov4 ov4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{ov4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && ov4Var != null && !ov4Var.h && !a(ov4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            clogBuilder.y(logType).v(ov4Var.a).q(String.valueOf(i2 + 1)).r(ov4Var.d).s(ov4Var.e).t(ov4Var.c).w(String.valueOf(ov4Var.b)).p(ov4Var.g);
            jy0.e(clogBuilder);
            ov4Var.h = true;
            i.add(ov4Var.g);
        }
    }

    public static void f(ov4 ov4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{ov4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && ov4Var != null && !ov4Var.h && !a(ov4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            clogBuilder.y(logType).v(ov4Var.a).q(String.valueOf(i2 + 1)).w(String.valueOf(ov4Var.b)).p(ov4Var.g);
            jy0.e(clogBuilder);
            ov4Var.h = true;
            i.add(ov4Var.g);
        }
    }

    public static void h(ov4 ov4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{ov4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && ov4Var != null && !ov4Var.h && !a(ov4Var.g)) {
            boolean equals = "PB_BANNER".equals(ov4Var.a);
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
                i4 = ov4Var.b;
            }
            q.w(String.valueOf(i4)).v(ov4Var.a).r(ov4Var.d).s(ov4Var.e).t(ov4Var.c).p(ov4Var.g);
            jy0.e(clogBuilder);
            ov4Var.h = true;
            i.add(ov4Var.g);
        }
    }

    public static void e(lk6 lk6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, lk6Var) == null) && lk6Var != null && lk6Var.c() != null && lk6Var.c().i != null && !lk6Var.c().i.h && !a(lk6Var.c().i.g)) {
            lk6Var.c().j = lk6Var.c().i.a;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(lk6Var.c().j).q(String.valueOf(lk6Var.c().position + 1)).w(String.valueOf(lk6Var.c().i.b)).p(lk6Var.c().i.g);
            jy0.e(clogBuilder);
            zy8.b(zy8.a(lk6Var.c()));
            lk6Var.c().i.h = true;
            i.add(lk6Var.c().i.g);
        }
    }
}
