package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class kp5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jp5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized jp5 a() {
        InterceptResult invokeV;
        jp5 jp5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (kp5.class) {
                if (a == null) {
                    a = new jp5();
                }
                jp5Var = a;
            }
            return jp5Var;
        }
        return (jp5) invokeV.objValue;
    }
}
