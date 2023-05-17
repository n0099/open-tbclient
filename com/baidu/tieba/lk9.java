package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class lk9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile kk9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized kk9 a() {
        InterceptResult invokeV;
        kk9 kk9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (lk9.class) {
                if (a == null) {
                    a = new kk9();
                }
                kk9Var = a;
            }
            return kk9Var;
        }
        return (kk9) invokeV.objValue;
    }
}
