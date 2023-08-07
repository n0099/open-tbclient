package com.baidu.tieba;

import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public final class mi2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static gi2 a(ni2 ni2Var, dj2 dj2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, ni2Var, dj2Var, v8ThreadDelegatePolicy)) == null) {
            oi2 a = fu2.B0().a(ni2Var);
            gi2 a2 = a.a(ni2Var.a(), dj2Var, v8ThreadDelegatePolicy);
            a2.H0(a.getUserAgent());
            return a2;
        }
        return (gi2) invokeLLL.objValue;
    }

    public static gi2 b(ni2 ni2Var, dj2 dj2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, ni2Var, dj2Var, v8ThreadDelegatePolicy)) == null) {
            gi2 a = a(ni2Var, dj2Var, v8ThreadDelegatePolicy);
            a.p0();
            return a;
        }
        return (gi2) invokeLLL.objValue;
    }
}
