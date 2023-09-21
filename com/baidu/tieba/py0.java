package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class py0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile oy0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized oy0 a() {
        InterceptResult invokeV;
        oy0 oy0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (py0.class) {
                if (a == null) {
                    a = new oy0();
                }
                oy0Var = a;
            }
            return oy0Var;
        }
        return (oy0) invokeV.objValue;
    }
}
