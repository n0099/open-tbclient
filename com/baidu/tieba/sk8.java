package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class sk8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rk8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized rk8 a() {
        InterceptResult invokeV;
        rk8 rk8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (sk8.class) {
                if (a == null) {
                    a = new rk8();
                }
                rk8Var = a;
            }
            return rk8Var;
        }
        return (rk8) invokeV.objValue;
    }
}
