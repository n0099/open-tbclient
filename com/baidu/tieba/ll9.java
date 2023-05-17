package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ll9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile kl9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized kl9 a() {
        InterceptResult invokeV;
        kl9 kl9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ll9.class) {
                if (a == null) {
                    a = new kl9();
                }
                kl9Var = a;
            }
            return kl9Var;
        }
        return (kl9) invokeV.objValue;
    }
}
