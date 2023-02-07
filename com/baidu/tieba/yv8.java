package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class yv8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xv8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized xv8 a() {
        InterceptResult invokeV;
        xv8 xv8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (yv8.class) {
                if (a == null) {
                    a = new xv8();
                }
                xv8Var = a;
            }
            return xv8Var;
        }
        return (xv8) invokeV.objValue;
    }
}
