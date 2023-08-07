package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class z74 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile y74 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized y74 a() {
        InterceptResult invokeV;
        y74 y74Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (z74.class) {
                if (a == null) {
                    a = new y74();
                }
                y74Var = a;
            }
            return y74Var;
        }
        return (y74) invokeV.objValue;
    }
}
