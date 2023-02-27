package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class lx0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile kx0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized kx0 a() {
        InterceptResult invokeV;
        kx0 kx0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (lx0.class) {
                if (a == null) {
                    a = new kx0();
                }
                kx0Var = a;
            }
            return kx0Var;
        }
        return (kx0) invokeV.objValue;
    }
}
