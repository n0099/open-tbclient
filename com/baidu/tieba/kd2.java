package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class kd2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947909168, "Lcom/baidu/tieba/kd2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947909168, "Lcom/baidu/tieba/kd2;");
                return;
            }
        }
        a = nr1.a;
    }

    public static boolean a(ba2 ba2Var, String str) {
        InterceptResult invokeLL;
        db3 b0;
        fd2 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, ba2Var, str)) == null) {
            if (a) {
                Log.d("MasterIsolationHelper", "JS CALL - " + str);
            }
            boolean z = false;
            if (c73.D()) {
                return false;
            }
            if (ba2Var != null && !TextUtils.isEmpty(ba2Var.getContainerId())) {
                if (sd2.i().k(ba2Var.getContainerId())) {
                    return true;
                }
                if (!df2.h()) {
                    return false;
                }
                String containerId = ba2Var.getContainerId();
                if (!jd2.a(containerId) || (b0 = db3.b0()) == null || !b(ba2Var) || (a2 = md2.b().a()) == null) {
                    return false;
                }
                String h = a2.h();
                if (TextUtils.isEmpty(h)) {
                    return false;
                }
                z = (TextUtils.equals(a2.i().a(), ba2Var.getContainerId()) && TextUtils.equals(h, b0.b)) ? true : true;
                if (a && z) {
                    Log.w("MasterIsolationHelper", "master id - " + containerId + ",can not call API - " + str + ", intercept for preload/prefetch");
                }
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public static boolean b(ba2 ba2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ba2Var)) == null) {
            if ((ba2Var instanceof li2) && ((li2) ba2Var).getInvokeSourceType() == 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
