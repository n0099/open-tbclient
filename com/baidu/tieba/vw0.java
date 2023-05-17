package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class vw0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile uw0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized uw0 a() {
        InterceptResult invokeV;
        uw0 uw0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (vw0.class) {
                if (a == null) {
                    a = new uw0();
                }
                uw0Var = a;
            }
            return uw0Var;
        }
        return (uw0) invokeV.objValue;
    }
}
