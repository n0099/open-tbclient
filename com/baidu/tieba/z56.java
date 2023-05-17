package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class z56 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile y56 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized y56 a() {
        InterceptResult invokeV;
        y56 y56Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (z56.class) {
                if (a == null) {
                    a = new y56();
                }
                y56Var = a;
            }
            return y56Var;
        }
        return (y56) invokeV.objValue;
    }
}
