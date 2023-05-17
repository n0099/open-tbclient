package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class sk9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rk9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized rk9 a() {
        InterceptResult invokeV;
        rk9 rk9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (sk9.class) {
                if (a == null) {
                    a = new rk9();
                }
                rk9Var = a;
            }
            return rk9Var;
        }
        return (rk9) invokeV.objValue;
    }
}
