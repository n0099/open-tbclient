package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.tieba.pq2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.List;
/* loaded from: classes5.dex */
public class m33 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947921692, "Lcom/baidu/tieba/m33;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947921692, "Lcom/baidu/tieba/m33;");
                return;
            }
        }
        a = do1.a;
    }

    public static void a() {
        String[] list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && (list = pq2.q().list()) != null && list.length > 0) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    ug4 ug4Var = new ug4();
                    ug4Var.g = str;
                    ug4Var.i = -1L;
                    qf4.i().f(ug4Var);
                }
            }
            pq2.e.d();
        }
    }

    public static void b(String str) {
        File s;
        String[] list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, str) == null) && !TextUtils.isEmpty(str) && (s = pq2.s(str)) != null && (list = s.list()) != null && list.length > 1) {
            List<ug4> q = a33.q(str);
            for (String str2 : list) {
                long j = -1;
                try {
                    j = Long.parseLong(str2);
                } catch (NumberFormatException e) {
                    if (a) {
                        l33.b(Log.getStackTraceString(e));
                    }
                }
                if (!c(j, q)) {
                    xn4.L(pq2.t(str, str2));
                    l33.b("delete plugin name = " + str + " ; version = " + str2);
                }
            }
            ug4 ug4Var = null;
            if (q != null) {
                if (q.size() == 1) {
                    ug4Var = q.get(0);
                } else if (q.size() >= 2) {
                    ug4Var = q.get(1);
                }
            }
            if (ug4Var != null) {
                qf4.i().f(ug4Var);
            }
        }
    }

    public static boolean c(long j, List<ug4> list) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65539, null, j, list)) == null) {
            if (j >= 0 && list != null && list.size() != 0) {
                int min = Math.min(list.size(), 2);
                for (int i = 0; i < min; i++) {
                    ug4 ug4Var = list.get(i);
                    if (ug4Var != null && (j == ug4Var.i || j == il3.c(ug4Var.j))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeJL.booleanValue;
    }
}
