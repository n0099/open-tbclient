package com.baidu.tieba;

import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final class za2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ta2 a(ab2 ab2Var, qb2 qb2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, ab2Var, qb2Var, v8ThreadDelegatePolicy)) == null) {
            bb2 a = sm2.B0().a(ab2Var);
            ta2 a2 = a.a(ab2Var.a(), qb2Var, v8ThreadDelegatePolicy);
            a2.I0(a.getUserAgent());
            return a2;
        }
        return (ta2) invokeLLL.objValue;
    }

    public static ta2 b(ab2 ab2Var, qb2 qb2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, ab2Var, qb2Var, v8ThreadDelegatePolicy)) == null) {
            ta2 a = a(ab2Var, qb2Var, v8ThreadDelegatePolicy);
            a.q0();
            return a;
        }
        return (ta2) invokeLLL.objValue;
    }
}
