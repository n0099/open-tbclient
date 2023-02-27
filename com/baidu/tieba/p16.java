package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class p16 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile o16 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized o16 a() {
        InterceptResult invokeV;
        o16 o16Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (p16.class) {
                if (a == null) {
                    a = new o16();
                }
                o16Var = a;
            }
            return o16Var;
        }
        return (o16) invokeV.objValue;
    }
}
