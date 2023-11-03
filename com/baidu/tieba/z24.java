package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class z24 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile y24 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized y24 a() {
        InterceptResult invokeV;
        y24 y24Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (z24.class) {
                if (a == null) {
                    a = new y24();
                }
                y24Var = a;
            }
            return y24Var;
        }
        return (y24) invokeV.objValue;
    }
}
