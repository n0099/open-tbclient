package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class yn3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xn3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized xn3 a() {
        InterceptResult invokeV;
        xn3 xn3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (yn3.class) {
                if (a == null) {
                    a = new xn3();
                }
                xn3Var = a;
            }
            return xn3Var;
        }
        return (xn3) invokeV.objValue;
    }
}
