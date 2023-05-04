package com.baidu.tieba;

import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public final class lf2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ff2 a(mf2 mf2Var, cg2 cg2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, mf2Var, cg2Var, v8ThreadDelegatePolicy)) == null) {
            nf2 a = er2.B0().a(mf2Var);
            ff2 a2 = a.a(mf2Var.a(), cg2Var, v8ThreadDelegatePolicy);
            a2.I0(a.getUserAgent());
            return a2;
        }
        return (ff2) invokeLLL.objValue;
    }

    public static ff2 b(mf2 mf2Var, cg2 cg2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, mf2Var, cg2Var, v8ThreadDelegatePolicy)) == null) {
            ff2 a = a(mf2Var, cg2Var, v8ThreadDelegatePolicy);
            a.q0();
            return a;
        }
        return (ff2) invokeLLL.objValue;
    }
}
