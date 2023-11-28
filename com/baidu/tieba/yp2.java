package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class yp2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xp2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized xp2 a() {
        InterceptResult invokeV;
        xp2 xp2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (yp2.class) {
                if (a == null) {
                    a = new xp2();
                }
                xp2Var = a;
            }
            return xp2Var;
        }
        return (xp2) invokeV.objValue;
    }
}
