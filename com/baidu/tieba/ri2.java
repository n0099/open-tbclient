package com.baidu.tieba;

import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public final class ri2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static li2 a(si2 si2Var, ij2 ij2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, si2Var, ij2Var, v8ThreadDelegatePolicy)) == null) {
            ti2 a = ku2.B0().a(si2Var);
            li2 a2 = a.a(si2Var.a(), ij2Var, v8ThreadDelegatePolicy);
            a2.H0(a.getUserAgent());
            return a2;
        }
        return (li2) invokeLLL.objValue;
    }

    public static li2 b(si2 si2Var, ij2 ij2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, si2Var, ij2Var, v8ThreadDelegatePolicy)) == null) {
            li2 a = a(si2Var, ij2Var, v8ThreadDelegatePolicy);
            a.p0();
            return a;
        }
        return (li2) invokeLLL.objValue;
    }
}
