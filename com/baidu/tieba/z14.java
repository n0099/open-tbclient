package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class z14 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile y14 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized y14 a() {
        InterceptResult invokeV;
        y14 y14Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (z14.class) {
                if (a == null) {
                    a = new y14();
                }
                y14Var = a;
            }
            return y14Var;
        }
        return (y14) invokeV.objValue;
    }
}
