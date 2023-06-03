package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class lx3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile kx3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized kx3 a() {
        InterceptResult invokeV;
        kx3 kx3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (lx3.class) {
                if (a == null) {
                    a = new kx3();
                }
                kx3Var = a;
            }
            return kx3Var;
        }
        return (kx3) invokeV.objValue;
    }
}
