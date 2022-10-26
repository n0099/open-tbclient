package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ym2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xm2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized xm2 a() {
        InterceptResult invokeV;
        xm2 xm2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ym2.class) {
                if (a == null) {
                    a = new xm2();
                }
                xm2Var = a;
            }
            return xm2Var;
        }
        return (xm2) invokeV.objValue;
    }
}
