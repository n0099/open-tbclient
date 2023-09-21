package com.baidu.tieba;

import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public final class ui2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static oi2 a(vi2 vi2Var, lj2 lj2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, vi2Var, lj2Var, v8ThreadDelegatePolicy)) == null) {
            wi2 a = nu2.B0().a(vi2Var);
            oi2 a2 = a.a(vi2Var.a(), lj2Var, v8ThreadDelegatePolicy);
            a2.H0(a.getUserAgent());
            return a2;
        }
        return (oi2) invokeLLL.objValue;
    }

    public static oi2 b(vi2 vi2Var, lj2 lj2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, vi2Var, lj2Var, v8ThreadDelegatePolicy)) == null) {
            oi2 a = a(vi2Var, lj2Var, v8ThreadDelegatePolicy);
            a.p0();
            return a;
        }
        return (oi2) invokeLLL.objValue;
    }
}
