package com.baidu.tieba;

import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public final class jf2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static df2 a(kf2 kf2Var, ag2 ag2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, kf2Var, ag2Var, v8ThreadDelegatePolicy)) == null) {
            lf2 a = cr2.B0().a(kf2Var);
            df2 a2 = a.a(kf2Var.a(), ag2Var, v8ThreadDelegatePolicy);
            a2.I0(a.getUserAgent());
            return a2;
        }
        return (df2) invokeLLL.objValue;
    }

    public static df2 b(kf2 kf2Var, ag2 ag2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, kf2Var, ag2Var, v8ThreadDelegatePolicy)) == null) {
            df2 a = a(kf2Var, ag2Var, v8ThreadDelegatePolicy);
            a.q0();
            return a;
        }
        return (df2) invokeLLL.objValue;
    }
}
