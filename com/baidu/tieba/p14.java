package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class p14 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile o14 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized o14 a() {
        InterceptResult invokeV;
        o14 o14Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (p14.class) {
                if (a == null) {
                    a = new o14();
                }
                o14Var = a;
            }
            return o14Var;
        }
        return (o14) invokeV.objValue;
    }
}
