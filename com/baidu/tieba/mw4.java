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
public class mw4 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947987071, "Lcom/baidu/tieba/mw4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947987071, "Lcom/baidu/tieba/mw4;");
                return;
            }
        }
        i = new HashSet();
    }

    public mw4() {
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
        mw4 mw4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) && advertAppInfo != null && (mw4Var = advertAppInfo.i) != null && !mw4Var.h && !a(mw4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(advertAppInfo.j).q(String.valueOf(advertAppInfo.position + 1)).r(mw4Var.d).s(mw4Var.e).t(mw4Var.c).w(String.valueOf(mw4Var.b)).p(advertAppInfo.g);
            k11.b(clogBuilder);
            q38.b(q38.a(advertAppInfo));
            mw4Var.h = true;
            i.add(mw4Var.g);
        }
    }

    public static void f(ac9 ac9Var) {
        mw4 mw4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, ac9Var) == null) && ac9Var != null && ac9Var.getAdvertAppInfo() != null && (mw4Var = ac9Var.getAdvertAppInfo().i) != null && !mw4Var.h && !a(mw4Var.g)) {
            ac9Var.c1 = mw4Var.d;
            ac9Var.d1 = mw4Var.e;
            ac9Var.b1 = mw4Var.c;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).q(String.valueOf(ac9Var.h1 + 1)).w(String.valueOf(ac9Var.f1)).v(mw4Var.a).r(mw4Var.d).s(mw4Var.e).t(mw4Var.c).p(mw4Var.g);
            k11.b(clogBuilder);
            mw4Var.h = true;
            i.add(mw4Var.g);
        }
    }

    public static void c(mw4 mw4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{mw4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && mw4Var != null && !mw4Var.h && !a(mw4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            clogBuilder.y(logType).v(mw4Var.a).q(String.valueOf(i2 + 1)).r(mw4Var.d).s(mw4Var.e).t(mw4Var.c).w(String.valueOf(mw4Var.b)).p(mw4Var.g);
            k11.b(clogBuilder);
            mw4Var.h = true;
            i.add(mw4Var.g);
        }
    }

    public static void e(mw4 mw4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{mw4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && mw4Var != null && !mw4Var.h && !a(mw4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            clogBuilder.y(logType).v(mw4Var.a).q(String.valueOf(i2 + 1)).w(String.valueOf(mw4Var.b)).p(mw4Var.g);
            k11.b(clogBuilder);
            mw4Var.h = true;
            i.add(mw4Var.g);
        }
    }

    public static void g(mw4 mw4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{mw4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && mw4Var != null && !mw4Var.h && !a(mw4Var.g)) {
            boolean equals = "PB_BANNER".equals(mw4Var.a);
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
                i4 = mw4Var.b;
            }
            q.w(String.valueOf(i4)).v(mw4Var.a).r(mw4Var.d).s(mw4Var.e).t(mw4Var.c).p(mw4Var.g);
            k11.b(clogBuilder);
            mw4Var.h = true;
            i.add(mw4Var.g);
        }
    }

    public static void d(uf6 uf6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, uf6Var) == null) && uf6Var != null && uf6Var.c() != null && uf6Var.c().i != null && !uf6Var.c().i.h && !a(uf6Var.c().i.g)) {
            uf6Var.c().j = uf6Var.c().i.a;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(uf6Var.c().j).q(String.valueOf(uf6Var.c().position + 1)).w(String.valueOf(uf6Var.c().i.b)).p(uf6Var.c().i.g);
            k11.b(clogBuilder);
            q38.b(q38.a(uf6Var.c()));
            uf6Var.c().i.h = true;
            i.add(uf6Var.c().i.g);
        }
    }
}
