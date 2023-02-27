package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class vx0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ux0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ux0 a() {
        InterceptResult invokeV;
        ux0 ux0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (vx0.class) {
                if (a == null) {
                    a = new ux0();
                }
                ux0Var = a;
            }
            return ux0Var;
        }
        return (ux0) invokeV.objValue;
    }
}
