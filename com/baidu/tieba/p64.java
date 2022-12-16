package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class p64 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile o64 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized o64 a() {
        InterceptResult invokeV;
        o64 o64Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (p64.class) {
                if (a == null) {
                    a = new o64();
                }
                o64Var = a;
            }
            return o64Var;
        }
        return (o64) invokeV.objValue;
    }
}
