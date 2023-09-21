package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class y96 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile x96 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized x96 a() {
        InterceptResult invokeV;
        x96 x96Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (y96.class) {
                if (a == null) {
                    a = new x96();
                }
                x96Var = a;
            }
            return x96Var;
        }
        return (x96) invokeV.objValue;
    }
}
