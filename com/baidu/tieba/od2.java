package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class od2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948028332, "Lcom/baidu/tieba/od2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948028332, "Lcom/baidu/tieba/od2;");
                return;
            }
        }
        a = rr1.a;
    }

    public static boolean a(fa2 fa2Var, String str) {
        InterceptResult invokeLL;
        hb3 b0;
        jd2 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, fa2Var, str)) == null) {
            if (a) {
                Log.d("MasterIsolationHelper", "JS CALL - " + str);
            }
            boolean z = false;
            if (g73.D()) {
                return false;
            }
            if (fa2Var != null && !TextUtils.isEmpty(fa2Var.getContainerId())) {
                if (wd2.i().k(fa2Var.getContainerId())) {
                    return true;
                }
                if (!hf2.h()) {
                    return false;
                }
                String containerId = fa2Var.getContainerId();
                if (!nd2.a(containerId) || (b0 = hb3.b0()) == null || !b(fa2Var) || (a2 = qd2.b().a()) == null) {
                    return false;
                }
                String h = a2.h();
                if (TextUtils.isEmpty(h)) {
                    return false;
                }
                z = (TextUtils.equals(a2.i().a(), fa2Var.getContainerId()) && TextUtils.equals(h, b0.b)) ? true : true;
                if (a && z) {
                    Log.w("MasterIsolationHelper", "master id - " + containerId + ",can not call API - " + str + ", intercept for preload/prefetch");
                }
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public static boolean b(fa2 fa2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, fa2Var)) == null) {
            if ((fa2Var instanceof pi2) && ((pi2) fa2Var).getInvokeSourceType() == 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
