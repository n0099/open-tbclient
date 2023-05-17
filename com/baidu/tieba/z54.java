package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class z54 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile y54 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized y54 a() {
        InterceptResult invokeV;
        y54 y54Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (z54.class) {
                if (a == null) {
                    a = new y54();
                }
                y54Var = a;
            }
            return y54Var;
        }
        return (y54) invokeV.objValue;
    }
}
