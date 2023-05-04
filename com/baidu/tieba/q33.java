package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.tieba.tq2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.List;
/* loaded from: classes6.dex */
public class q33 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948040856, "Lcom/baidu/tieba/q33;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948040856, "Lcom/baidu/tieba/q33;");
                return;
            }
        }
        a = ho1.a;
    }

    public static void a() {
        String[] list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && (list = tq2.q().list()) != null && list.length > 0) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    yg4 yg4Var = new yg4();
                    yg4Var.g = str;
                    yg4Var.i = -1L;
                    uf4.i().f(yg4Var);
                }
            }
            tq2.e.d();
        }
    }

    public static void b(String str) {
        File s;
        String[] list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, str) == null) && !TextUtils.isEmpty(str) && (s = tq2.s(str)) != null && (list = s.list()) != null && list.length > 1) {
            List<yg4> q = e33.q(str);
            for (String str2 : list) {
                long j = -1;
                try {
                    j = Long.parseLong(str2);
                } catch (NumberFormatException e) {
                    if (a) {
                        p33.b(Log.getStackTraceString(e));
                    }
                }
                if (!c(j, q)) {
                    bo4.L(tq2.t(str, str2));
                    p33.b("delete plugin name = " + str + " ; version = " + str2);
                }
            }
            yg4 yg4Var = null;
            if (q != null) {
                if (q.size() == 1) {
                    yg4Var = q.get(0);
                } else if (q.size() >= 2) {
                    yg4Var = q.get(1);
                }
            }
            if (yg4Var != null) {
                uf4.i().f(yg4Var);
            }
        }
    }

    public static boolean c(long j, List<yg4> list) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65539, null, j, list)) == null) {
            if (j >= 0 && list != null && list.size() != 0) {
                int min = Math.min(list.size(), 2);
                for (int i = 0; i < min; i++) {
                    yg4 yg4Var = list.get(i);
                    if (yg4Var != null && (j == yg4Var.i || j == ml3.c(yg4Var.j))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeJL.booleanValue;
    }
}
