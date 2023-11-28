package com.baidu.tieba;

import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public final class vd2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static pd2 a(wd2 wd2Var, me2 me2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, wd2Var, me2Var, v8ThreadDelegatePolicy)) == null) {
            xd2 a = op2.B0().a(wd2Var);
            pd2 a2 = a.a(wd2Var.a(), me2Var, v8ThreadDelegatePolicy);
            a2.G0(a.getUserAgent());
            return a2;
        }
        return (pd2) invokeLLL.objValue;
    }

    public static pd2 b(wd2 wd2Var, me2 me2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, wd2Var, me2Var, v8ThreadDelegatePolicy)) == null) {
            pd2 a = a(wd2Var, me2Var, v8ThreadDelegatePolicy);
            a.o0();
            return a;
        }
        return (pd2) invokeLLL.objValue;
    }
}
