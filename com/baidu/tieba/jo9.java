package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class jo9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile io9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized io9 a() {
        InterceptResult invokeV;
        io9 io9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (jo9.class) {
                if (a == null) {
                    a = new io9();
                }
                io9Var = a;
            }
            return io9Var;
        }
        return (io9) invokeV.objValue;
    }
}
