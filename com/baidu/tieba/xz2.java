package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.tieba.an2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.List;
/* loaded from: classes6.dex */
public class xz2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948317593, "Lcom/baidu/tieba/xz2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948317593, "Lcom/baidu/tieba/xz2;");
                return;
            }
        }
        a = ok1.a;
    }

    public static void a() {
        String[] list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && (list = an2.q().list()) != null && list.length > 0) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    fd4 fd4Var = new fd4();
                    fd4Var.g = str;
                    fd4Var.i = -1L;
                    bc4.i().f(fd4Var);
                }
            }
            an2.e.d();
        }
    }

    public static void b(String str) {
        File s;
        String[] list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, str) == null) && !TextUtils.isEmpty(str) && (s = an2.s(str)) != null && (list = s.list()) != null && list.length > 1) {
            List<fd4> q = lz2.q(str);
            for (String str2 : list) {
                long j = -1;
                try {
                    j = Long.parseLong(str2);
                } catch (NumberFormatException e) {
                    if (a) {
                        wz2.b(Log.getStackTraceString(e));
                    }
                }
                if (!c(j, q)) {
                    ik4.L(an2.t(str, str2));
                    wz2.b("delete plugin name = " + str + " ; version = " + str2);
                }
            }
            fd4 fd4Var = null;
            if (q != null) {
                if (q.size() == 1) {
                    fd4Var = q.get(0);
                } else if (q.size() >= 2) {
                    fd4Var = q.get(1);
                }
            }
            if (fd4Var != null) {
                bc4.i().f(fd4Var);
            }
        }
    }

    public static boolean c(long j, List<fd4> list) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65539, null, j, list)) == null) {
            if (j >= 0 && list != null && list.size() != 0) {
                int min = Math.min(list.size(), 2);
                for (int i = 0; i < min; i++) {
                    fd4 fd4Var = list.get(i);
                    if (fd4Var != null && (j == fd4Var.i || j == th3.c(fd4Var.j))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeJL.booleanValue;
    }
}
