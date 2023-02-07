package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ux0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile tx0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized tx0 a() {
        InterceptResult invokeV;
        tx0 tx0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ux0.class) {
                if (a == null) {
                    a = new tx0();
                }
                tx0Var = a;
            }
            return tx0Var;
        }
        return (tx0) invokeV.objValue;
    }
}
