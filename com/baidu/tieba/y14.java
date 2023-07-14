package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class y14 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile x14 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized x14 a() {
        InterceptResult invokeV;
        x14 x14Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (y14.class) {
                if (a == null) {
                    a = new x14();
                }
                x14Var = a;
            }
            return x14Var;
        }
        return (x14) invokeV.objValue;
    }
}
