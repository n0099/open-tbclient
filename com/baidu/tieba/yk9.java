package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class yk9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xk9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized xk9 a() {
        InterceptResult invokeV;
        xk9 xk9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (yk9.class) {
                if (a == null) {
                    a = new xk9();
                }
                xk9Var = a;
            }
            return xk9Var;
        }
        return (xk9) invokeV.objValue;
    }
}
