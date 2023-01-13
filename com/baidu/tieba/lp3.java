package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class lp3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile kp3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized kp3 a() {
        InterceptResult invokeV;
        kp3 kp3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (lp3.class) {
                if (a == null) {
                    a = new kp3();
                }
                kp3Var = a;
            }
            return kp3Var;
        }
        return (kp3) invokeV.objValue;
    }
}
