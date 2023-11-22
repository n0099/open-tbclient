package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class y66 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile x66 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized x66 a() {
        InterceptResult invokeV;
        x66 x66Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (y66.class) {
                if (a == null) {
                    a = new x66();
                }
                x66Var = a;
            }
            return x66Var;
        }
        return (x66) invokeV.objValue;
    }
}
