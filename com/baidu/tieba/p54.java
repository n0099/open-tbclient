package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class p54 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile o54 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized o54 a() {
        InterceptResult invokeV;
        o54 o54Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (p54.class) {
                if (a == null) {
                    a = new o54();
                }
                o54Var = a;
            }
            return o54Var;
        }
        return (o54) invokeV.objValue;
    }
}
