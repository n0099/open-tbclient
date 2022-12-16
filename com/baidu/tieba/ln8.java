package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ln8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile kn8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized kn8 a() {
        InterceptResult invokeV;
        kn8 kn8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ln8.class) {
                if (a == null) {
                    a = new kn8();
                }
                kn8Var = a;
            }
            return kn8Var;
        }
        return (kn8) invokeV.objValue;
    }
}
