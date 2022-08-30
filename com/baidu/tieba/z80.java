package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class z80 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile y80 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized y80 a() {
        InterceptResult invokeV;
        y80 y80Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (z80.class) {
                if (a == null) {
                    a = new y80();
                }
                y80Var = a;
            }
            return y80Var;
        }
        return (y80) invokeV.objValue;
    }
}
