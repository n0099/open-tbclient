package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.tieba.sr2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.List;
/* loaded from: classes5.dex */
public class p43 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948012026, "Lcom/baidu/tieba/p43;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948012026, "Lcom/baidu/tieba/p43;");
                return;
            }
        }
        a = gp1.a;
    }

    public static void a() {
        String[] list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && (list = sr2.q().list()) != null && list.length > 0) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    xh4 xh4Var = new xh4();
                    xh4Var.g = str;
                    xh4Var.i = -1L;
                    tg4.i().f(xh4Var);
                }
            }
            sr2.e.d();
        }
    }

    public static void b(String str) {
        File s;
        String[] list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, str) == null) && !TextUtils.isEmpty(str) && (s = sr2.s(str)) != null && (list = s.list()) != null && list.length > 1) {
            List<xh4> q = d43.q(str);
            for (String str2 : list) {
                long j = -1;
                try {
                    j = Long.parseLong(str2);
                } catch (NumberFormatException e) {
                    if (a) {
                        o43.b(Log.getStackTraceString(e));
                    }
                }
                if (!c(j, q)) {
                    ap4.L(sr2.t(str, str2));
                    o43.b("delete plugin name = " + str + " ; version = " + str2);
                }
            }
            xh4 xh4Var = null;
            if (q != null) {
                if (q.size() == 1) {
                    xh4Var = q.get(0);
                } else if (q.size() >= 2) {
                    xh4Var = q.get(1);
                }
            }
            if (xh4Var != null) {
                tg4.i().f(xh4Var);
            }
        }
    }

    public static boolean c(long j, List<xh4> list) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65539, null, j, list)) == null) {
            if (j >= 0 && list != null && list.size() != 0) {
                int min = Math.min(list.size(), 2);
                for (int i = 0; i < min; i++) {
                    xh4 xh4Var = list.get(i);
                    if (xh4Var != null && (j == xh4Var.i || j == lm3.c(xh4Var.j))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeJL.booleanValue;
    }
}
