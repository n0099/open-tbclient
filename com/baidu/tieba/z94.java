package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class z94 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile y94 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized y94 a() {
        InterceptResult invokeV;
        y94 y94Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (z94.class) {
                if (a == null) {
                    a = new y94();
                }
                y94Var = a;
            }
            return y94Var;
        }
        return (y94) invokeV.objValue;
    }
}
