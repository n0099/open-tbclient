package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class lz3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile kz3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized kz3 a() {
        InterceptResult invokeV;
        kz3 kz3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (lz3.class) {
                if (a == null) {
                    a = new kz3();
                }
                kz3Var = a;
            }
            return kz3Var;
        }
        return (kz3) invokeV.objValue;
    }
}
