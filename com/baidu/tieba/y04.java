package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class y04 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile x04 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized x04 a() {
        InterceptResult invokeV;
        x04 x04Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (y04.class) {
                if (a == null) {
                    a = new x04();
                }
                x04Var = a;
            }
            return x04Var;
        }
        return (x04) invokeV.objValue;
    }
}
