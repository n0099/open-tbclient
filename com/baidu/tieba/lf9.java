package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class lf9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile kf9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized kf9 a() {
        InterceptResult invokeV;
        kf9 kf9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (lf9.class) {
                if (a == null) {
                    a = new kf9();
                }
                kf9Var = a;
            }
            return kf9Var;
        }
        return (kf9) invokeV.objValue;
    }
}
