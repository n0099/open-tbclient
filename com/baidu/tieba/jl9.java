package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class jl9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile il9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized il9 a() {
        InterceptResult invokeV;
        il9 il9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (jl9.class) {
                if (a == null) {
                    a = new il9();
                }
                il9Var = a;
            }
            return il9Var;
        }
        return (il9) invokeV.objValue;
    }
}
