package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class u76 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile t76 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized t76 a() {
        InterceptResult invokeV;
        t76 t76Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (u76.class) {
                if (a == null) {
                    a = new t76();
                }
                t76Var = a;
            }
            return t76Var;
        }
        return (t76) invokeV.objValue;
    }
}
