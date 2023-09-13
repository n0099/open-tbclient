package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class iy6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hy6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized hy6 a() {
        InterceptResult invokeV;
        hy6 hy6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (iy6.class) {
                if (a == null) {
                    a = new hy6();
                }
                hy6Var = a;
            }
            return hy6Var;
        }
        return (hy6) invokeV.objValue;
    }
}
