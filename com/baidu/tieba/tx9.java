package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class tx9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile sx9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized sx9 a() {
        InterceptResult invokeV;
        sx9 sx9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (tx9.class) {
                if (a == null) {
                    a = new sx9();
                }
                sx9Var = a;
            }
            return sx9Var;
        }
        return (sx9) invokeV.objValue;
    }
}
