package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class p46 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile o46 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized o46 a() {
        InterceptResult invokeV;
        o46 o46Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (p46.class) {
                if (a == null) {
                    a = new o46();
                }
                o46Var = a;
            }
            return o46Var;
        }
        return (o46) invokeV.objValue;
    }
}
