package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class sk3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rk3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized rk3 a() {
        InterceptResult invokeV;
        rk3 rk3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (sk3.class) {
                if (a == null) {
                    a = new rk3();
                }
                rk3Var = a;
            }
            return rk3Var;
        }
        return (rk3) invokeV.objValue;
    }
}
