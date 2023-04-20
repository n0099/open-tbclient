package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class lw0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile kw0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized kw0 a() {
        InterceptResult invokeV;
        kw0 kw0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (lw0.class) {
                if (a == null) {
                    a = new kw0();
                }
                kw0Var = a;
            }
            return kw0Var;
        }
        return (kw0) invokeV.objValue;
    }
}
