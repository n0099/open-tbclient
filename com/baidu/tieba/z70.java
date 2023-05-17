package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class z70 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile y70 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized y70 a() {
        InterceptResult invokeV;
        y70 y70Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (z70.class) {
                if (a == null) {
                    a = new y70();
                }
                y70Var = a;
            }
            return y70Var;
        }
        return (y70) invokeV.objValue;
    }
}
