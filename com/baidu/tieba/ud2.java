package com.baidu.tieba;

import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public final class ud2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static od2 a(vd2 vd2Var, le2 le2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, vd2Var, le2Var, v8ThreadDelegatePolicy)) == null) {
            wd2 a = np2.B0().a(vd2Var);
            od2 a2 = a.a(vd2Var.a(), le2Var, v8ThreadDelegatePolicy);
            a2.G0(a.getUserAgent());
            return a2;
        }
        return (od2) invokeLLL.objValue;
    }

    public static od2 b(vd2 vd2Var, le2 le2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, vd2Var, le2Var, v8ThreadDelegatePolicy)) == null) {
            od2 a = a(vd2Var, le2Var, v8ThreadDelegatePolicy);
            a.o0();
            return a;
        }
        return (od2) invokeLLL.objValue;
    }
}
