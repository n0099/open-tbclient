package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class lz0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile kz0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized kz0 a() {
        InterceptResult invokeV;
        kz0 kz0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (lz0.class) {
                if (a == null) {
                    a = new kz0();
                }
                kz0Var = a;
            }
            return kz0Var;
        }
        return (kz0) invokeV.objValue;
    }
}
