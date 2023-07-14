package com.baidu.tieba;

import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final class jj2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static dj2 a(kj2 kj2Var, ak2 ak2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, kj2Var, ak2Var, v8ThreadDelegatePolicy)) == null) {
            lj2 a = cv2.B0().a(kj2Var);
            dj2 a2 = a.a(kj2Var.a(), ak2Var, v8ThreadDelegatePolicy);
            a2.H0(a.getUserAgent());
            return a2;
        }
        return (dj2) invokeLLL.objValue;
    }

    public static dj2 b(kj2 kj2Var, ak2 ak2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, kj2Var, ak2Var, v8ThreadDelegatePolicy)) == null) {
            dj2 a = a(kj2Var, ak2Var, v8ThreadDelegatePolicy);
            a.p0();
            return a;
        }
        return (dj2) invokeLLL.objValue;
    }
}
