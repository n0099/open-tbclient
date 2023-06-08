package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class p96 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile o96 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized o96 a() {
        InterceptResult invokeV;
        o96 o96Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (p96.class) {
                if (a == null) {
                    a = new o96();
                }
                o96Var = a;
            }
            return o96Var;
        }
        return (o96) invokeV.objValue;
    }
}
