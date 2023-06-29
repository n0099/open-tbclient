package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class lx9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile kx9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized kx9 a() {
        InterceptResult invokeV;
        kx9 kx9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (lx9.class) {
                if (a == null) {
                    a = new kx9();
                }
                kx9Var = a;
            }
            return kx9Var;
        }
        return (kx9) invokeV.objValue;
    }
}
