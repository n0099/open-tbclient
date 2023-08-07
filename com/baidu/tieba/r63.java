package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.tieba.ut2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.List;
/* loaded from: classes7.dex */
public class r63 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948073530, "Lcom/baidu/tieba/r63;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948073530, "Lcom/baidu/tieba/r63;");
                return;
            }
        }
        a = ir1.a;
    }

    public static void a() {
        String[] list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && (list = ut2.q().list()) != null && list.length > 0) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    zj4 zj4Var = new zj4();
                    zj4Var.g = str;
                    zj4Var.i = -1L;
                    vi4.i().f(zj4Var);
                }
            }
            ut2.e.d();
        }
    }

    public static void b(String str) {
        File s;
        String[] list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, str) == null) && !TextUtils.isEmpty(str) && (s = ut2.s(str)) != null && (list = s.list()) != null && list.length > 1) {
            List<zj4> q = f63.q(str);
            for (String str2 : list) {
                long j = -1;
                try {
                    j = Long.parseLong(str2);
                } catch (NumberFormatException e) {
                    if (a) {
                        q63.b(Log.getStackTraceString(e));
                    }
                }
                if (!c(j, q)) {
                    cr4.L(ut2.t(str, str2));
                    q63.b("delete plugin name = " + str + " ; version = " + str2);
                }
            }
            zj4 zj4Var = null;
            if (q != null) {
                if (q.size() == 1) {
                    zj4Var = q.get(0);
                } else if (q.size() >= 2) {
                    zj4Var = q.get(1);
                }
            }
            if (zj4Var != null) {
                vi4.i().f(zj4Var);
            }
        }
    }

    public static boolean c(long j, List<zj4> list) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65539, null, j, list)) == null) {
            if (j >= 0 && list != null && list.size() != 0) {
                int min = Math.min(list.size(), 2);
                for (int i = 0; i < min; i++) {
                    zj4 zj4Var = list.get(i);
                    if (zj4Var != null && (j == zj4Var.i || j == no3.c(zj4Var.j))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeJL.booleanValue;
    }
}
