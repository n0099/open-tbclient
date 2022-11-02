package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class lw2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile kw2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized kw2 a() {
        InterceptResult invokeV;
        kw2 kw2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (lw2.class) {
                if (a == null) {
                    a = new kw2();
                }
                kw2Var = a;
            }
            return kw2Var;
        }
        return (kw2) invokeV.objValue;
    }
}
