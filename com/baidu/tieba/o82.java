package com.baidu.tieba;

import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public final class o82 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static i82 a(p82 p82Var, f92 f92Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, p82Var, f92Var, v8ThreadDelegatePolicy)) == null) {
            q82 a = hk2.B0().a(p82Var);
            i82 a2 = a.a(p82Var.a(), f92Var, v8ThreadDelegatePolicy);
            a2.I0(a.getUserAgent());
            return a2;
        }
        return (i82) invokeLLL.objValue;
    }

    public static i82 b(p82 p82Var, f92 f92Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, p82Var, f92Var, v8ThreadDelegatePolicy)) == null) {
            i82 a = a(p82Var, f92Var, v8ThreadDelegatePolicy);
            a.q0();
            return a;
        }
        return (i82) invokeLLL.objValue;
    }
}
