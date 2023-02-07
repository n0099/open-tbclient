package com.baidu.tieba;

import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public final class kg2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static eg2 a(lg2 lg2Var, bh2 bh2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, lg2Var, bh2Var, v8ThreadDelegatePolicy)) == null) {
            mg2 a = ds2.B0().a(lg2Var);
            eg2 a2 = a.a(lg2Var.a(), bh2Var, v8ThreadDelegatePolicy);
            a2.I0(a.getUserAgent());
            return a2;
        }
        return (eg2) invokeLLL.objValue;
    }

    public static eg2 b(lg2 lg2Var, bh2 bh2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, lg2Var, bh2Var, v8ThreadDelegatePolicy)) == null) {
            eg2 a = a(lg2Var, bh2Var, v8ThreadDelegatePolicy);
            a.q0();
            return a;
        }
        return (eg2) invokeLLL.objValue;
    }
}
