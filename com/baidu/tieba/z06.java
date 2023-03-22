package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class z06 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile y06 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized y06 a() {
        InterceptResult invokeV;
        y06 y06Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (z06.class) {
                if (a == null) {
                    a = new y06();
                }
                y06Var = a;
            }
            return y06Var;
        }
        return (y06) invokeV.objValue;
    }
}
