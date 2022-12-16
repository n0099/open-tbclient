package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class yp3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xp3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized xp3 a() {
        InterceptResult invokeV;
        xp3 xp3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (yp3.class) {
                if (a == null) {
                    a = new xp3();
                }
                xp3Var = a;
            }
            return xp3Var;
        }
        return (xp3) invokeV.objValue;
    }
}
