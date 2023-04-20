package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class y94 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile x94 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized x94 a() {
        InterceptResult invokeV;
        x94 x94Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (y94.class) {
                if (a == null) {
                    a = new x94();
                }
                x94Var = a;
            }
            return x94Var;
        }
        return (x94) invokeV.objValue;
    }
}
