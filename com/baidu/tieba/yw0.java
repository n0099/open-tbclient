package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class yw0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xw0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized xw0 a() {
        InterceptResult invokeV;
        xw0 xw0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (yw0.class) {
                if (a == null) {
                    a = new xw0();
                }
                xw0Var = a;
            }
            return xw0Var;
        }
        return (xw0) invokeV.objValue;
    }
}
