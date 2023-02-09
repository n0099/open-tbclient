package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class yw8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xw8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized xw8 a() {
        InterceptResult invokeV;
        xw8 xw8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (yw8.class) {
                if (a == null) {
                    a = new xw8();
                }
                xw8Var = a;
            }
            return xw8Var;
        }
        return (xw8) invokeV.objValue;
    }
}
