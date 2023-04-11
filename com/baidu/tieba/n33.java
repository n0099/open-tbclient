package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.tieba.qq2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.List;
/* loaded from: classes5.dex */
public class n33 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947951483, "Lcom/baidu/tieba/n33;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947951483, "Lcom/baidu/tieba/n33;");
                return;
            }
        }
        a = eo1.a;
    }

    public static void a() {
        String[] list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && (list = qq2.q().list()) != null && list.length > 0) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    vg4 vg4Var = new vg4();
                    vg4Var.g = str;
                    vg4Var.i = -1L;
                    rf4.i().f(vg4Var);
                }
            }
            qq2.e.d();
        }
    }

    public static void b(String str) {
        File s;
        String[] list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, str) == null) && !TextUtils.isEmpty(str) && (s = qq2.s(str)) != null && (list = s.list()) != null && list.length > 1) {
            List<vg4> q = b33.q(str);
            for (String str2 : list) {
                long j = -1;
                try {
                    j = Long.parseLong(str2);
                } catch (NumberFormatException e) {
                    if (a) {
                        m33.b(Log.getStackTraceString(e));
                    }
                }
                if (!c(j, q)) {
                    yn4.L(qq2.t(str, str2));
                    m33.b("delete plugin name = " + str + " ; version = " + str2);
                }
            }
            vg4 vg4Var = null;
            if (q != null) {
                if (q.size() == 1) {
                    vg4Var = q.get(0);
                } else if (q.size() >= 2) {
                    vg4Var = q.get(1);
                }
            }
            if (vg4Var != null) {
                rf4.i().f(vg4Var);
            }
        }
    }

    public static boolean c(long j, List<vg4> list) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65539, null, j, list)) == null) {
            if (j >= 0 && list != null && list.size() != 0) {
                int min = Math.min(list.size(), 2);
                for (int i = 0; i < min; i++) {
                    vg4 vg4Var = list.get(i);
                    if (vg4Var != null && (j == vg4Var.i || j == jl3.c(vg4Var.j))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeJL.booleanValue;
    }
}
