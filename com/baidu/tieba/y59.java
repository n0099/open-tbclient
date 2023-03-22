package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class y59 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile x59 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized x59 a() {
        InterceptResult invokeV;
        x59 x59Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (y59.class) {
                if (a == null) {
                    a = new x59();
                }
                x59Var = a;
            }
            return x59Var;
        }
        return (x59) invokeV.objValue;
    }
}
