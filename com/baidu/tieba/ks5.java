package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class ks5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile js5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized js5 a() {
        InterceptResult invokeV;
        js5 js5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ks5.class) {
                if (a == null) {
                    a = new js5();
                }
                js5Var = a;
            }
            return js5Var;
        }
        return (js5) invokeV.objValue;
    }
}
