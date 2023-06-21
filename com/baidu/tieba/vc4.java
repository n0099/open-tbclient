package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class vc4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile uc4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized uc4 a() {
        InterceptResult invokeV;
        uc4 uc4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (vc4.class) {
                if (a == null) {
                    a = new uc4();
                }
                uc4Var = a;
            }
            return uc4Var;
        }
        return (uc4) invokeV.objValue;
    }
}
