package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class yr5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xr5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized xr5 a() {
        InterceptResult invokeV;
        xr5 xr5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (yr5.class) {
                if (a == null) {
                    a = new xr5();
                }
                xr5Var = a;
            }
            return xr5Var;
        }
        return (xr5) invokeV.objValue;
    }
}
