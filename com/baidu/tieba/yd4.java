package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class yd4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xd4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized xd4 a() {
        InterceptResult invokeV;
        xd4 xd4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (yd4.class) {
                if (a == null) {
                    a = new xd4();
                }
                xd4Var = a;
            }
            return xd4Var;
        }
        return (xd4) invokeV.objValue;
    }
}
