package com.baidu.tieba;

import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public final class ug2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static og2 a(vg2 vg2Var, lh2 lh2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, vg2Var, lh2Var, v8ThreadDelegatePolicy)) == null) {
            wg2 a = ns2.B0().a(vg2Var);
            og2 a2 = a.a(vg2Var.a(), lh2Var, v8ThreadDelegatePolicy);
            a2.I0(a.getUserAgent());
            return a2;
        }
        return (og2) invokeLLL.objValue;
    }

    public static og2 b(vg2 vg2Var, lh2 lh2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, vg2Var, lh2Var, v8ThreadDelegatePolicy)) == null) {
            og2 a = a(vg2Var, lh2Var, v8ThreadDelegatePolicy);
            a.q0();
            return a;
        }
        return (og2) invokeLLL.objValue;
    }
}
