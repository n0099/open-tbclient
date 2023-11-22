package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class y56 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile x56 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized x56 a() {
        InterceptResult invokeV;
        x56 x56Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (y56.class) {
                if (a == null) {
                    a = new x56();
                }
                x56Var = a;
            }
            return x56Var;
        }
        return (x56) invokeV.objValue;
    }
}
