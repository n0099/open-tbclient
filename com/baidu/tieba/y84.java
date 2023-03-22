package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class y84 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile x84 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized x84 a() {
        InterceptResult invokeV;
        x84 x84Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (y84.class) {
                if (a == null) {
                    a = new x84();
                }
                x84Var = a;
            }
            return x84Var;
        }
        return (x84) invokeV.objValue;
    }
}
