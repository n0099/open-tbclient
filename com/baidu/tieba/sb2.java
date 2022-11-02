package com.baidu.tieba;

import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public final class sb2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static mb2 a(tb2 tb2Var, jc2 jc2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, tb2Var, jc2Var, v8ThreadDelegatePolicy)) == null) {
            ub2 a = ln2.B0().a(tb2Var);
            mb2 a2 = a.a(tb2Var.a(), jc2Var, v8ThreadDelegatePolicy);
            a2.I0(a.getUserAgent());
            return a2;
        }
        return (mb2) invokeLLL.objValue;
    }

    public static mb2 b(tb2 tb2Var, jc2 jc2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, tb2Var, jc2Var, v8ThreadDelegatePolicy)) == null) {
            mb2 a = a(tb2Var, jc2Var, v8ThreadDelegatePolicy);
            a.q0();
            return a;
        }
        return (mb2) invokeLLL.objValue;
    }
}
