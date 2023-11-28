package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class p66 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile o66 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized o66 a() {
        InterceptResult invokeV;
        o66 o66Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (p66.class) {
                if (a == null) {
                    a = new o66();
                }
                o66Var = a;
            }
            return o66Var;
        }
        return (o66) invokeV.objValue;
    }
}
