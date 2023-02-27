package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class lw3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile kw3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized kw3 a() {
        InterceptResult invokeV;
        kw3 kw3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (lw3.class) {
                if (a == null) {
                    a = new kw3();
                }
                kw3Var = a;
            }
            return kw3Var;
        }
        return (kw3) invokeV.objValue;
    }
}
