package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.tieba.ul2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.List;
/* loaded from: classes5.dex */
public class ry2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948137886, "Lcom/baidu/tieba/ry2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948137886, "Lcom/baidu/tieba/ry2;");
                return;
            }
        }
        a = ij1.a;
    }

    public static void a() {
        String[] list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, null) == null) || (list = ul2.q().list()) == null || list.length <= 0) {
            return;
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                zb4 zb4Var = new zb4();
                zb4Var.g = str;
                zb4Var.i = -1L;
                va4.i().f(zb4Var);
            }
        }
        ul2.e.d();
    }

    public static void b(String str) {
        File s;
        String[] list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, str) == null) || TextUtils.isEmpty(str) || (s = ul2.s(str)) == null || (list = s.list()) == null || list.length <= 1) {
            return;
        }
        List<zb4> q = fy2.q(str);
        for (String str2 : list) {
            long j = -1;
            try {
                j = Long.parseLong(str2);
            } catch (NumberFormatException e) {
                if (a) {
                    qy2.b(Log.getStackTraceString(e));
                }
            }
            if (!c(j, q)) {
                cj4.L(ul2.t(str, str2));
                qy2.b("delete plugin name = " + str + " ; version = " + str2);
            }
        }
        zb4 zb4Var = null;
        if (q != null) {
            if (q.size() == 1) {
                zb4Var = q.get(0);
            } else if (q.size() >= 2) {
                zb4Var = q.get(1);
            }
        }
        if (zb4Var != null) {
            va4.i().f(zb4Var);
        }
    }

    public static boolean c(long j, List<zb4> list) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65539, null, j, list)) == null) {
            if (j >= 0 && list != null && list.size() != 0) {
                int min = Math.min(list.size(), 2);
                for (int i = 0; i < min; i++) {
                    zb4 zb4Var = list.get(i);
                    if (zb4Var != null && (j == zb4Var.i || j == ng3.c(zb4Var.j))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeJL.booleanValue;
    }
}
