package com.baidu.tieba;

import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public final class yd2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static sd2 a(zd2 zd2Var, pe2 pe2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, zd2Var, pe2Var, v8ThreadDelegatePolicy)) == null) {
            ae2 a = rp2.B0().a(zd2Var);
            sd2 a2 = a.a(zd2Var.a(), pe2Var, v8ThreadDelegatePolicy);
            a2.G0(a.getUserAgent());
            return a2;
        }
        return (sd2) invokeLLL.objValue;
    }

    public static sd2 b(zd2 zd2Var, pe2 pe2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, zd2Var, pe2Var, v8ThreadDelegatePolicy)) == null) {
            sd2 a = a(zd2Var, pe2Var, v8ThreadDelegatePolicy);
            a.o0();
            return a;
        }
        return (sd2) invokeLLL.objValue;
    }
}
