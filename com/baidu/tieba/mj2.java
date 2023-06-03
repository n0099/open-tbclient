package com.baidu.tieba;

import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final class mj2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static gj2 a(nj2 nj2Var, dk2 dk2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, nj2Var, dk2Var, v8ThreadDelegatePolicy)) == null) {
            oj2 a = fv2.B0().a(nj2Var);
            gj2 a2 = a.a(nj2Var.a(), dk2Var, v8ThreadDelegatePolicy);
            a2.H0(a.getUserAgent());
            return a2;
        }
        return (gj2) invokeLLL.objValue;
    }

    public static gj2 b(nj2 nj2Var, dk2 dk2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, nj2Var, dk2Var, v8ThreadDelegatePolicy)) == null) {
            gj2 a = a(nj2Var, dk2Var, v8ThreadDelegatePolicy);
            a.p0();
            return a;
        }
        return (gj2) invokeLLL.objValue;
    }
}
