package com.baidu.tieba;

import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final class xb2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static rb2 a(yb2 yb2Var, oc2 oc2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, yb2Var, oc2Var, v8ThreadDelegatePolicy)) == null) {
            zb2 a = qn2.B0().a(yb2Var);
            rb2 a2 = a.a(yb2Var.a(), oc2Var, v8ThreadDelegatePolicy);
            a2.I0(a.getUserAgent());
            return a2;
        }
        return (rb2) invokeLLL.objValue;
    }

    public static rb2 b(yb2 yb2Var, oc2 oc2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, yb2Var, oc2Var, v8ThreadDelegatePolicy)) == null) {
            rb2 a = a(yb2Var, oc2Var, v8ThreadDelegatePolicy);
            a.q0();
            return a;
        }
        return (rb2) invokeLLL.objValue;
    }
}
