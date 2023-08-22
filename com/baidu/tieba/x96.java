package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class x96 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile w96 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized w96 a() {
        InterceptResult invokeV;
        w96 w96Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (x96.class) {
                if (a == null) {
                    a = new w96();
                }
                w96Var = a;
            }
            return w96Var;
        }
        return (w96) invokeV.objValue;
    }
}
