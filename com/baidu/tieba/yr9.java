package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class yr9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xr9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized xr9 a() {
        InterceptResult invokeV;
        xr9 xr9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (yr9.class) {
                if (a == null) {
                    a = new xr9();
                }
                xr9Var = a;
            }
            return xr9Var;
        }
        return (xr9) invokeV.objValue;
    }
}
