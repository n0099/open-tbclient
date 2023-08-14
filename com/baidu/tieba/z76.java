package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class z76 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile y76 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized y76 a() {
        InterceptResult invokeV;
        y76 y76Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (z76.class) {
                if (a == null) {
                    a = new y76();
                }
                y76Var = a;
            }
            return y76Var;
        }
        return (y76) invokeV.objValue;
    }
}
