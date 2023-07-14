package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class u74 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile t74 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized t74 a() {
        InterceptResult invokeV;
        t74 t74Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (u74.class) {
                if (a == null) {
                    a = new t74();
                }
                t74Var = a;
            }
            return t74Var;
        }
        return (t74) invokeV.objValue;
    }
}
