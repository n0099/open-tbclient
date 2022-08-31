package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class yp5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xp5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized xp5 a() {
        InterceptResult invokeV;
        xp5 xp5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (yp5.class) {
                if (a == null) {
                    a = new xp5();
                }
                xp5Var = a;
            }
            return xp5Var;
        }
        return (xp5) invokeV.objValue;
    }
}
