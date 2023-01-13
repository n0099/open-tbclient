package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class o54 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile n54 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized n54 a() {
        InterceptResult invokeV;
        n54 n54Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (o54.class) {
                if (a == null) {
                    a = new n54();
                }
                n54Var = a;
            }
            return n54Var;
        }
        return (n54) invokeV.objValue;
    }
}
