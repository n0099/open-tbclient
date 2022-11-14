package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class yn2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xn2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized xn2 a() {
        InterceptResult invokeV;
        xn2 xn2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (yn2.class) {
                if (a == null) {
                    a = new xn2();
                }
                xn2Var = a;
            }
            return xn2Var;
        }
        return (xn2) invokeV.objValue;
    }
}
