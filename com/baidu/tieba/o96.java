package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class o96 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile n96 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized n96 a() {
        InterceptResult invokeV;
        n96 n96Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (o96.class) {
                if (a == null) {
                    a = new n96();
                }
                n96Var = a;
            }
            return n96Var;
        }
        return (n96) invokeV.objValue;
    }
}
