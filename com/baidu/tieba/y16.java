package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class y16 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile x16 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized x16 a() {
        InterceptResult invokeV;
        x16 x16Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (y16.class) {
                if (a == null) {
                    a = new x16();
                }
                x16Var = a;
            }
            return x16Var;
        }
        return (x16) invokeV.objValue;
    }
}
