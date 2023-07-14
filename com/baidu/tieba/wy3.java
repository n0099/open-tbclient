package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class wy3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vy3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized vy3 a() {
        InterceptResult invokeV;
        vy3 vy3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (wy3.class) {
                if (a == null) {
                    a = new vy3();
                }
                vy3Var = a;
            }
            return vy3Var;
        }
        return (vy3) invokeV.objValue;
    }
}
