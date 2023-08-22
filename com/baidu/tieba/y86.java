package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class y86 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile x86 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized x86 a() {
        InterceptResult invokeV;
        x86 x86Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (y86.class) {
                if (a == null) {
                    a = new x86();
                }
                x86Var = a;
            }
            return x86Var;
        }
        return (x86) invokeV.objValue;
    }
}
