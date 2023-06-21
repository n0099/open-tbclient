package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.tieba.vu2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.List;
/* loaded from: classes7.dex */
public class s73 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948104282, "Lcom/baidu/tieba/s73;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948104282, "Lcom/baidu/tieba/s73;");
                return;
            }
        }
        a = js1.a;
    }

    public static void a() {
        String[] list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && (list = vu2.q().list()) != null && list.length > 0) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    al4 al4Var = new al4();
                    al4Var.g = str;
                    al4Var.i = -1L;
                    wj4.i().f(al4Var);
                }
            }
            vu2.e.d();
        }
    }

    public static void b(String str) {
        File s;
        String[] list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, str) == null) && !TextUtils.isEmpty(str) && (s = vu2.s(str)) != null && (list = s.list()) != null && list.length > 1) {
            List<al4> q = g73.q(str);
            for (String str2 : list) {
                long j = -1;
                try {
                    j = Long.parseLong(str2);
                } catch (NumberFormatException e) {
                    if (a) {
                        r73.b(Log.getStackTraceString(e));
                    }
                }
                if (!c(j, q)) {
                    ds4.L(vu2.t(str, str2));
                    r73.b("delete plugin name = " + str + " ; version = " + str2);
                }
            }
            al4 al4Var = null;
            if (q != null) {
                if (q.size() == 1) {
                    al4Var = q.get(0);
                } else if (q.size() >= 2) {
                    al4Var = q.get(1);
                }
            }
            if (al4Var != null) {
                wj4.i().f(al4Var);
            }
        }
    }

    public static boolean c(long j, List<al4> list) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65539, null, j, list)) == null) {
            if (j >= 0 && list != null && list.size() != 0) {
                int min = Math.min(list.size(), 2);
                for (int i = 0; i < min; i++) {
                    al4 al4Var = list.get(i);
                    if (al4Var != null && (j == al4Var.i || j == op3.c(al4Var.j))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeJL.booleanValue;
    }
}
