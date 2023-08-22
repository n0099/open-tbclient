package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.tieba.zt2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.List;
/* loaded from: classes8.dex */
public class w63 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948222485, "Lcom/baidu/tieba/w63;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948222485, "Lcom/baidu/tieba/w63;");
                return;
            }
        }
        a = nr1.a;
    }

    public static void a() {
        String[] list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && (list = zt2.q().list()) != null && list.length > 0) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    ek4 ek4Var = new ek4();
                    ek4Var.g = str;
                    ek4Var.i = -1L;
                    aj4.i().f(ek4Var);
                }
            }
            zt2.e.d();
        }
    }

    public static void b(String str) {
        File s;
        String[] list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, str) == null) && !TextUtils.isEmpty(str) && (s = zt2.s(str)) != null && (list = s.list()) != null && list.length > 1) {
            List<ek4> q = k63.q(str);
            for (String str2 : list) {
                long j = -1;
                try {
                    j = Long.parseLong(str2);
                } catch (NumberFormatException e) {
                    if (a) {
                        v63.b(Log.getStackTraceString(e));
                    }
                }
                if (!c(j, q)) {
                    hr4.L(zt2.t(str, str2));
                    v63.b("delete plugin name = " + str + " ; version = " + str2);
                }
            }
            ek4 ek4Var = null;
            if (q != null) {
                if (q.size() == 1) {
                    ek4Var = q.get(0);
                } else if (q.size() >= 2) {
                    ek4Var = q.get(1);
                }
            }
            if (ek4Var != null) {
                aj4.i().f(ek4Var);
            }
        }
    }

    public static boolean c(long j, List<ek4> list) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65539, null, j, list)) == null) {
            if (j >= 0 && list != null && list.size() != 0) {
                int min = Math.min(list.size(), 2);
                for (int i = 0; i < min; i++) {
                    ek4 ek4Var = list.get(i);
                    if (ek4Var != null && (j == ek4Var.i || j == so3.c(ek4Var.j))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeJL.booleanValue;
    }
}
