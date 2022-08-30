package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class yw3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xw3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized xw3 a() {
        InterceptResult invokeV;
        xw3 xw3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (yw3.class) {
                if (a == null) {
                    a = new xw3();
                }
                xw3Var = a;
            }
            return xw3Var;
        }
        return (xw3) invokeV.objValue;
    }
}
