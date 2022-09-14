package com.baidu.tieba;

import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public final class ma2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ga2 a(na2 na2Var, db2 db2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, na2Var, db2Var, v8ThreadDelegatePolicy)) == null) {
            oa2 a = fm2.B0().a(na2Var);
            ga2 a2 = a.a(na2Var.a(), db2Var, v8ThreadDelegatePolicy);
            a2.I0(a.getUserAgent());
            return a2;
        }
        return (ga2) invokeLLL.objValue;
    }

    public static ga2 b(na2 na2Var, db2 db2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, na2Var, db2Var, v8ThreadDelegatePolicy)) == null) {
            ga2 a = a(na2Var, db2Var, v8ThreadDelegatePolicy);
            a.q0();
            return a;
        }
        return (ga2) invokeLLL.objValue;
    }
}
