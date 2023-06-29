package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class xy0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wy0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized wy0 a() {
        InterceptResult invokeV;
        wy0 wy0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xy0.class) {
                if (a == null) {
                    a = new wy0();
                }
                wy0Var = a;
            }
            return wy0Var;
        }
        return (wy0) invokeV.objValue;
    }
}
