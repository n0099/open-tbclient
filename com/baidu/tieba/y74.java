package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class y74 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile x74 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized x74 a() {
        InterceptResult invokeV;
        x74 x74Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (y74.class) {
                if (a == null) {
                    a = new x74();
                }
                x74Var = a;
            }
            return x74Var;
        }
        return (x74) invokeV.objValue;
    }
}
