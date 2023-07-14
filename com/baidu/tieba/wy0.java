package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class wy0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vy0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized vy0 a() {
        InterceptResult invokeV;
        vy0 vy0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (wy0.class) {
                if (a == null) {
                    a = new vy0();
                }
                vy0Var = a;
            }
            return vy0Var;
        }
        return (vy0) invokeV.objValue;
    }
}
