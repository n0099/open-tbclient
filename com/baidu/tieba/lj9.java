package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class lj9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile kj9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized kj9 a() {
        InterceptResult invokeV;
        kj9 kj9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (lj9.class) {
                if (a == null) {
                    a = new kj9();
                }
                kj9Var = a;
            }
            return kj9Var;
        }
        return (kj9) invokeV.objValue;
    }
}
