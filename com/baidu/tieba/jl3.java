package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class jl3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile il3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized il3 a() {
        InterceptResult invokeV;
        il3 il3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (jl3.class) {
                if (a == null) {
                    a = new il3();
                }
                il3Var = a;
            }
            return il3Var;
        }
        return (il3) invokeV.objValue;
    }
}
