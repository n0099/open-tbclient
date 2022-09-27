package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class yo3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xo3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized xo3 a() {
        InterceptResult invokeV;
        xo3 xo3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (yo3.class) {
                if (a == null) {
                    a = new xo3();
                }
                xo3Var = a;
            }
            return xo3Var;
        }
        return (xo3) invokeV.objValue;
    }
}
