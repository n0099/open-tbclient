package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class p76 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile o76 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized o76 a() {
        InterceptResult invokeV;
        o76 o76Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (p76.class) {
                if (a == null) {
                    a = new o76();
                }
                o76Var = a;
            }
            return o76Var;
        }
        return (o76) invokeV.objValue;
    }
}
