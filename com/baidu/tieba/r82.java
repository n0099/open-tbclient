package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class r82 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948075421, "Lcom/baidu/tieba/r82;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948075421, "Lcom/baidu/tieba/r82;");
                return;
            }
        }
        a = vm1.a;
    }

    public static boolean a(i52 i52Var, String str) {
        InterceptResult invokeLL;
        k63 c0;
        m82 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, i52Var, str)) == null) {
            if (a) {
                Log.d("MasterIsolationHelper", "JS CALL - " + str);
            }
            boolean z = false;
            if (j23.D()) {
                return false;
            }
            if (i52Var != null && !TextUtils.isEmpty(i52Var.getContainerId())) {
                if (z82.i().k(i52Var.getContainerId())) {
                    return true;
                }
                if (!ka2.h()) {
                    return false;
                }
                String containerId = i52Var.getContainerId();
                if (!q82.a(containerId) || (c0 = k63.c0()) == null || !b(i52Var) || (a2 = t82.b().a()) == null) {
                    return false;
                }
                String h = a2.h();
                if (TextUtils.isEmpty(h)) {
                    return false;
                }
                z = (TextUtils.equals(a2.i().a(), i52Var.getContainerId()) && TextUtils.equals(h, c0.b)) ? true : true;
                if (a && z) {
                    Log.w("MasterIsolationHelper", "master id - " + containerId + ",can not call API - " + str + ", intercept for preload/prefetch");
                }
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public static boolean b(i52 i52Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, i52Var)) == null) {
            if ((i52Var instanceof sd2) && ((sd2) i52Var).getInvokeSourceType() == 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
