package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class z64 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile y64 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized y64 a() {
        InterceptResult invokeV;
        y64 y64Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (z64.class) {
                if (a == null) {
                    a = new y64();
                }
                y64Var = a;
            }
            return y64Var;
        }
        return (y64) invokeV.objValue;
    }
}
