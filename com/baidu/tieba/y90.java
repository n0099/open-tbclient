package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class y90 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile x90 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized x90 a() {
        InterceptResult invokeV;
        x90 x90Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (y90.class) {
                if (a == null) {
                    a = new x90();
                }
                x90Var = a;
            }
            return x90Var;
        }
        return (x90) invokeV.objValue;
    }
}
