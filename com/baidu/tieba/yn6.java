package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class yn6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xn6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized xn6 a() {
        InterceptResult invokeV;
        xn6 xn6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (yn6.class) {
                if (a == null) {
                    a = new xn6();
                }
                xn6Var = a;
            }
            return xn6Var;
        }
        return (xn6) invokeV.objValue;
    }
}
