package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class lk8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile kk8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized kk8 a() {
        InterceptResult invokeV;
        kk8 kk8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (lk8.class) {
                if (a == null) {
                    a = new kk8();
                }
                kk8Var = a;
            }
            return kk8Var;
        }
        return (kk8) invokeV.objValue;
    }
}
