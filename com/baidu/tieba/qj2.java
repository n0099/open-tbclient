package com.baidu.tieba;

import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public final class qj2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static kj2 a(rj2 rj2Var, hk2 hk2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, rj2Var, hk2Var, v8ThreadDelegatePolicy)) == null) {
            sj2 a = jv2.B0().a(rj2Var);
            kj2 a2 = a.a(rj2Var.a(), hk2Var, v8ThreadDelegatePolicy);
            a2.H0(a.getUserAgent());
            return a2;
        }
        return (kj2) invokeLLL.objValue;
    }

    public static kj2 b(rj2 rj2Var, hk2 hk2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, rj2Var, hk2Var, v8ThreadDelegatePolicy)) == null) {
            kj2 a = a(rj2Var, hk2Var, v8ThreadDelegatePolicy);
            a.p0();
            return a;
        }
        return (kj2) invokeLLL.objValue;
    }
}
