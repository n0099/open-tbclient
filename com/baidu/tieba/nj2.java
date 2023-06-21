package com.baidu.tieba;

import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public final class nj2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static hj2 a(oj2 oj2Var, ek2 ek2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, oj2Var, ek2Var, v8ThreadDelegatePolicy)) == null) {
            pj2 a = gv2.B0().a(oj2Var);
            hj2 a2 = a.a(oj2Var.a(), ek2Var, v8ThreadDelegatePolicy);
            a2.H0(a.getUserAgent());
            return a2;
        }
        return (hj2) invokeLLL.objValue;
    }

    public static hj2 b(oj2 oj2Var, ek2 ek2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, oj2Var, ek2Var, v8ThreadDelegatePolicy)) == null) {
            hj2 a = a(oj2Var, ek2Var, v8ThreadDelegatePolicy);
            a.p0();
            return a;
        }
        return (hj2) invokeLLL.objValue;
    }
}
