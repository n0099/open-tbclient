package com.baidu.tieba;

import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final class tb2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static nb2 a(ub2 ub2Var, kc2 kc2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, ub2Var, kc2Var, v8ThreadDelegatePolicy)) == null) {
            vb2 a = mn2.B0().a(ub2Var);
            nb2 a2 = a.a(ub2Var.a(), kc2Var, v8ThreadDelegatePolicy);
            a2.I0(a.getUserAgent());
            return a2;
        }
        return (nb2) invokeLLL.objValue;
    }

    public static nb2 b(ub2 ub2Var, kc2 kc2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, ub2Var, kc2Var, v8ThreadDelegatePolicy)) == null) {
            nb2 a = a(ub2Var, kc2Var, v8ThreadDelegatePolicy);
            a.q0();
            return a;
        }
        return (nb2) invokeLLL.objValue;
    }
}
