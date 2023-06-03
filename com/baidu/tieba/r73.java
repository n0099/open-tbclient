package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.tieba.uu2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.List;
/* loaded from: classes7.dex */
public class r73 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948074491, "Lcom/baidu/tieba/r73;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948074491, "Lcom/baidu/tieba/r73;");
                return;
            }
        }
        a = is1.a;
    }

    public static void a() {
        String[] list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && (list = uu2.q().list()) != null && list.length > 0) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    zk4 zk4Var = new zk4();
                    zk4Var.g = str;
                    zk4Var.i = -1L;
                    vj4.i().f(zk4Var);
                }
            }
            uu2.e.d();
        }
    }

    public static void b(String str) {
        File s;
        String[] list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, str) == null) && !TextUtils.isEmpty(str) && (s = uu2.s(str)) != null && (list = s.list()) != null && list.length > 1) {
            List<zk4> q = f73.q(str);
            for (String str2 : list) {
                long j = -1;
                try {
                    j = Long.parseLong(str2);
                } catch (NumberFormatException e) {
                    if (a) {
                        q73.b(Log.getStackTraceString(e));
                    }
                }
                if (!c(j, q)) {
                    cs4.L(uu2.t(str, str2));
                    q73.b("delete plugin name = " + str + " ; version = " + str2);
                }
            }
            zk4 zk4Var = null;
            if (q != null) {
                if (q.size() == 1) {
                    zk4Var = q.get(0);
                } else if (q.size() >= 2) {
                    zk4Var = q.get(1);
                }
            }
            if (zk4Var != null) {
                vj4.i().f(zk4Var);
            }
        }
    }

    public static boolean c(long j, List<zk4> list) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65539, null, j, list)) == null) {
            if (j >= 0 && list != null && list.size() != 0) {
                int min = Math.min(list.size(), 2);
                for (int i = 0; i < min; i++) {
                    zk4 zk4Var = list.get(i);
                    if (zk4Var != null && (j == zk4Var.i || j == np3.c(zk4Var.j))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeJL.booleanValue;
    }
}
