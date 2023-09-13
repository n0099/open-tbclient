package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class vy0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile uy0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized uy0 a() {
        InterceptResult invokeV;
        uy0 uy0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (vy0.class) {
                if (a == null) {
                    a = new uy0();
                }
                uy0Var = a;
            }
            return uy0Var;
        }
        return (uy0) invokeV.objValue;
    }
}
