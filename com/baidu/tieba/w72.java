package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class w72 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948223415, "Lcom/baidu/tieba/w72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948223415, "Lcom/baidu/tieba/w72;");
                return;
            }
        }
        a = am1.a;
    }

    public static boolean a(n42 n42Var, String str) {
        InterceptResult invokeLL;
        p53 c0;
        r72 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, n42Var, str)) == null) {
            if (a) {
                Log.d("MasterIsolationHelper", "JS CALL - " + str);
            }
            boolean z = false;
            if (o13.D()) {
                return false;
            }
            if (n42Var != null && !TextUtils.isEmpty(n42Var.getContainerId())) {
                if (e82.i().k(n42Var.getContainerId())) {
                    return true;
                }
                if (!p92.h()) {
                    return false;
                }
                String containerId = n42Var.getContainerId();
                if (!v72.a(containerId) || (c0 = p53.c0()) == null || !b(n42Var) || (a2 = y72.b().a()) == null) {
                    return false;
                }
                String h = a2.h();
                if (TextUtils.isEmpty(h)) {
                    return false;
                }
                z = (TextUtils.equals(a2.i().a(), n42Var.getContainerId()) && TextUtils.equals(h, c0.b)) ? true : true;
                if (a && z) {
                    Log.w("MasterIsolationHelper", "master id - " + containerId + ",can not call API - " + str + ", intercept for preload/prefetch");
                }
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public static boolean b(n42 n42Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, n42Var)) == null) {
            if ((n42Var instanceof xc2) && ((xc2) n42Var).getInvokeSourceType() == 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
