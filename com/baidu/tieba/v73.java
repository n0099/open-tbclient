package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.tieba.yu2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.List;
/* loaded from: classes8.dex */
public class v73 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948193655, "Lcom/baidu/tieba/v73;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948193655, "Lcom/baidu/tieba/v73;");
                return;
            }
        }
        a = ms1.a;
    }

    public static void a() {
        String[] list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && (list = yu2.q().list()) != null && list.length > 0) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    dl4 dl4Var = new dl4();
                    dl4Var.g = str;
                    dl4Var.i = -1L;
                    zj4.i().f(dl4Var);
                }
            }
            yu2.e.d();
        }
    }

    public static void b(String str) {
        File s;
        String[] list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, str) == null) && !TextUtils.isEmpty(str) && (s = yu2.s(str)) != null && (list = s.list()) != null && list.length > 1) {
            List<dl4> q = j73.q(str);
            for (String str2 : list) {
                long j = -1;
                try {
                    j = Long.parseLong(str2);
                } catch (NumberFormatException e) {
                    if (a) {
                        u73.b(Log.getStackTraceString(e));
                    }
                }
                if (!c(j, q)) {
                    gs4.L(yu2.t(str, str2));
                    u73.b("delete plugin name = " + str + " ; version = " + str2);
                }
            }
            dl4 dl4Var = null;
            if (q != null) {
                if (q.size() == 1) {
                    dl4Var = q.get(0);
                } else if (q.size() >= 2) {
                    dl4Var = q.get(1);
                }
            }
            if (dl4Var != null) {
                zj4.i().f(dl4Var);
            }
        }
    }

    public static boolean c(long j, List<dl4> list) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65539, null, j, list)) == null) {
            if (j >= 0 && list != null && list.size() != 0) {
                int min = Math.min(list.size(), 2);
                for (int i = 0; i < min; i++) {
                    dl4 dl4Var = list.get(i);
                    if (dl4Var != null && (j == dl4Var.i || j == rp3.c(dl4Var.j))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeJL.booleanValue;
    }
}
