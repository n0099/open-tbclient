package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class z86 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile y86 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized y86 a() {
        InterceptResult invokeV;
        y86 y86Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (z86.class) {
                if (a == null) {
                    a = new y86();
                }
                y86Var = a;
            }
            return y86Var;
        }
        return (y86) invokeV.objValue;
    }
}
