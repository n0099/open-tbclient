package com.baidu.tieba;

import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public final class vi2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static pi2 a(wi2 wi2Var, mj2 mj2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, wi2Var, mj2Var, v8ThreadDelegatePolicy)) == null) {
            xi2 a = ou2.B0().a(wi2Var);
            pi2 a2 = a.a(wi2Var.a(), mj2Var, v8ThreadDelegatePolicy);
            a2.H0(a.getUserAgent());
            return a2;
        }
        return (pi2) invokeLLL.objValue;
    }

    public static pi2 b(wi2 wi2Var, mj2 mj2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, wi2Var, mj2Var, v8ThreadDelegatePolicy)) == null) {
            pi2 a = a(wi2Var, mj2Var, v8ThreadDelegatePolicy);
            a.p0();
            return a;
        }
        return (pi2) invokeLLL.objValue;
    }
}
