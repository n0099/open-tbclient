package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.tieba.ru2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.List;
/* loaded from: classes7.dex */
public class o73 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947985118, "Lcom/baidu/tieba/o73;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947985118, "Lcom/baidu/tieba/o73;");
                return;
            }
        }
        a = fs1.a;
    }

    public static void a() {
        String[] list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && (list = ru2.q().list()) != null && list.length > 0) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    wk4 wk4Var = new wk4();
                    wk4Var.g = str;
                    wk4Var.i = -1L;
                    sj4.i().f(wk4Var);
                }
            }
            ru2.e.d();
        }
    }

    public static void b(String str) {
        File s;
        String[] list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, str) == null) && !TextUtils.isEmpty(str) && (s = ru2.s(str)) != null && (list = s.list()) != null && list.length > 1) {
            List<wk4> q = c73.q(str);
            for (String str2 : list) {
                long j = -1;
                try {
                    j = Long.parseLong(str2);
                } catch (NumberFormatException e) {
                    if (a) {
                        n73.b(Log.getStackTraceString(e));
                    }
                }
                if (!c(j, q)) {
                    zr4.L(ru2.t(str, str2));
                    n73.b("delete plugin name = " + str + " ; version = " + str2);
                }
            }
            wk4 wk4Var = null;
            if (q != null) {
                if (q.size() == 1) {
                    wk4Var = q.get(0);
                } else if (q.size() >= 2) {
                    wk4Var = q.get(1);
                }
            }
            if (wk4Var != null) {
                sj4.i().f(wk4Var);
            }
        }
    }

    public static boolean c(long j, List<wk4> list) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65539, null, j, list)) == null) {
            if (j >= 0 && list != null && list.size() != 0) {
                int min = Math.min(list.size(), 2);
                for (int i = 0; i < min; i++) {
                    wk4 wk4Var = list.get(i);
                    if (wk4Var != null && (j == wk4Var.i || j == kp3.c(wk4Var.j))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeJL.booleanValue;
    }
}
