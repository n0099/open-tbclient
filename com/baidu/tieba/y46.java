package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class y46 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile x46 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized x46 a() {
        InterceptResult invokeV;
        x46 x46Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (y46.class) {
                if (a == null) {
                    a = new x46();
                }
                x46Var = a;
            }
            return x46Var;
        }
        return (x46) invokeV.objValue;
    }
}
