package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class uy0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ty0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ty0 a() {
        InterceptResult invokeV;
        ty0 ty0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (uy0.class) {
                if (a == null) {
                    a = new ty0();
                }
                ty0Var = a;
            }
            return ty0Var;
        }
        return (ty0) invokeV.objValue;
    }
}
