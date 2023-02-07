package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class y06 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile x06 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized x06 a() {
        InterceptResult invokeV;
        x06 x06Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (y06.class) {
                if (a == null) {
                    a = new x06();
                }
                x06Var = a;
            }
            return x06Var;
        }
        return (x06) invokeV.objValue;
    }
}
