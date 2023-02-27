package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class tx0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile sx0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized sx0 a() {
        InterceptResult invokeV;
        sx0 sx0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (tx0.class) {
                if (a == null) {
                    a = new sx0();
                }
                sx0Var = a;
            }
            return sx0Var;
        }
        return (sx0) invokeV.objValue;
    }
}
