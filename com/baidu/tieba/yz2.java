package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.tieba.bn2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.List;
/* loaded from: classes6.dex */
public class yz2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948347384, "Lcom/baidu/tieba/yz2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948347384, "Lcom/baidu/tieba/yz2;");
                return;
            }
        }
        a = pk1.a;
    }

    public static void a() {
        String[] list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && (list = bn2.q().list()) != null && list.length > 0) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    gd4 gd4Var = new gd4();
                    gd4Var.g = str;
                    gd4Var.i = -1L;
                    cc4.i().f(gd4Var);
                }
            }
            bn2.e.d();
        }
    }

    public static void b(String str) {
        File s;
        String[] list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, str) == null) && !TextUtils.isEmpty(str) && (s = bn2.s(str)) != null && (list = s.list()) != null && list.length > 1) {
            List<gd4> q = mz2.q(str);
            for (String str2 : list) {
                long j = -1;
                try {
                    j = Long.parseLong(str2);
                } catch (NumberFormatException e) {
                    if (a) {
                        xz2.b(Log.getStackTraceString(e));
                    }
                }
                if (!c(j, q)) {
                    jk4.L(bn2.t(str, str2));
                    xz2.b("delete plugin name = " + str + " ; version = " + str2);
                }
            }
            gd4 gd4Var = null;
            if (q != null) {
                if (q.size() == 1) {
                    gd4Var = q.get(0);
                } else if (q.size() >= 2) {
                    gd4Var = q.get(1);
                }
            }
            if (gd4Var != null) {
                cc4.i().f(gd4Var);
            }
        }
    }

    public static boolean c(long j, List<gd4> list) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65539, null, j, list)) == null) {
            if (j >= 0 && list != null && list.size() != 0) {
                int min = Math.min(list.size(), 2);
                for (int i = 0; i < min; i++) {
                    gd4 gd4Var = list.get(i);
                    if (gd4Var != null && (j == gd4Var.i || j == uh3.c(gd4Var.j))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeJL.booleanValue;
    }
}
