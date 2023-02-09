package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class tx8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile sx8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized sx8 a() {
        InterceptResult invokeV;
        sx8 sx8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (tx8.class) {
                if (a == null) {
                    a = new sx8();
                }
                sx8Var = a;
            }
            return sx8Var;
        }
        return (sx8) invokeV.objValue;
    }
}
