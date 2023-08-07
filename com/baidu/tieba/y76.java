package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class y76 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile x76 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized x76 a() {
        InterceptResult invokeV;
        x76 x76Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (y76.class) {
                if (a == null) {
                    a = new x76();
                }
                x76Var = a;
            }
            return x76Var;
        }
        return (x76) invokeV.objValue;
    }
}
