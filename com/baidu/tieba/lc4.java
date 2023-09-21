package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class lc4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile kc4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized kc4 a() {
        InterceptResult invokeV;
        kc4 kc4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (lc4.class) {
                if (a == null) {
                    a = new kc4();
                }
                kc4Var = a;
            }
            return kc4Var;
        }
        return (kc4) invokeV.objValue;
    }
}
