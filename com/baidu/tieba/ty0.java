package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class ty0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile sy0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized sy0 a() {
        InterceptResult invokeV;
        sy0 sy0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ty0.class) {
                if (a == null) {
                    a = new sy0();
                }
                sy0Var = a;
            }
            return sy0Var;
        }
        return (sy0) invokeV.objValue;
    }
}
