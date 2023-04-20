package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.tieba.rq2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.List;
/* loaded from: classes5.dex */
public class o33 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947981274, "Lcom/baidu/tieba/o33;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947981274, "Lcom/baidu/tieba/o33;");
                return;
            }
        }
        a = fo1.a;
    }

    public static void a() {
        String[] list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && (list = rq2.q().list()) != null && list.length > 0) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    wg4 wg4Var = new wg4();
                    wg4Var.g = str;
                    wg4Var.i = -1L;
                    sf4.i().f(wg4Var);
                }
            }
            rq2.e.d();
        }
    }

    public static void b(String str) {
        File s;
        String[] list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, str) == null) && !TextUtils.isEmpty(str) && (s = rq2.s(str)) != null && (list = s.list()) != null && list.length > 1) {
            List<wg4> q = c33.q(str);
            for (String str2 : list) {
                long j = -1;
                try {
                    j = Long.parseLong(str2);
                } catch (NumberFormatException e) {
                    if (a) {
                        n33.b(Log.getStackTraceString(e));
                    }
                }
                if (!c(j, q)) {
                    zn4.L(rq2.t(str, str2));
                    n33.b("delete plugin name = " + str + " ; version = " + str2);
                }
            }
            wg4 wg4Var = null;
            if (q != null) {
                if (q.size() == 1) {
                    wg4Var = q.get(0);
                } else if (q.size() >= 2) {
                    wg4Var = q.get(1);
                }
            }
            if (wg4Var != null) {
                sf4.i().f(wg4Var);
            }
        }
    }

    public static boolean c(long j, List<wg4> list) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65539, null, j, list)) == null) {
            if (j >= 0 && list != null && list.size() != 0) {
                int min = Math.min(list.size(), 2);
                for (int i = 0; i < min; i++) {
                    wg4 wg4Var = list.get(i);
                    if (wg4Var != null && (j == wg4Var.i || j == kl3.c(wg4Var.j))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeJL.booleanValue;
    }
}
