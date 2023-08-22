package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class z96 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile y96 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized y96 a() {
        InterceptResult invokeV;
        y96 y96Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (z96.class) {
                if (a == null) {
                    a = new y96();
                }
                y96Var = a;
            }
            return y96Var;
        }
        return (y96) invokeV.objValue;
    }
}
