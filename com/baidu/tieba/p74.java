package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class p74 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile o74 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized o74 a() {
        InterceptResult invokeV;
        o74 o74Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (p74.class) {
                if (a == null) {
                    a = new o74();
                }
                o74Var = a;
            }
            return o74Var;
        }
        return (o74) invokeV.objValue;
    }
}
