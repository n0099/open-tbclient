package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class vx3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ux3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ux3 a() {
        InterceptResult invokeV;
        ux3 ux3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (vx3.class) {
                if (a == null) {
                    a = new ux3();
                }
                ux3Var = a;
            }
            return ux3Var;
        }
        return (ux3) invokeV.objValue;
    }
}
