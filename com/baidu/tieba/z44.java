package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class z44 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile y44 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized y44 a() {
        InterceptResult invokeV;
        y44 y44Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (z44.class) {
                if (a == null) {
                    a = new y44();
                }
                y44Var = a;
            }
            return y44Var;
        }
        return (y44) invokeV.objValue;
    }
}
