package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class kl9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jl9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized jl9 a() {
        InterceptResult invokeV;
        jl9 jl9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (kl9.class) {
                if (a == null) {
                    a = new jl9();
                }
                jl9Var = a;
            }
            return jl9Var;
        }
        return (jl9) invokeV.objValue;
    }
}
