package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class lp5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile kp5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized kp5 a() {
        InterceptResult invokeV;
        kp5 kp5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (lp5.class) {
                if (a == null) {
                    a = new kp5();
                }
                kp5Var = a;
            }
            return kp5Var;
        }
        return (kp5) invokeV.objValue;
    }
}
