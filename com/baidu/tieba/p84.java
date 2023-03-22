package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class p84 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile o84 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized o84 a() {
        InterceptResult invokeV;
        o84 o84Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (p84.class) {
                if (a == null) {
                    a = new o84();
                }
                o84Var = a;
            }
            return o84Var;
        }
        return (o84) invokeV.objValue;
    }
}
