package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class x94 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile w94 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized w94 a() {
        InterceptResult invokeV;
        w94 w94Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (x94.class) {
                if (a == null) {
                    a = new w94();
                }
                w94Var = a;
            }
            return w94Var;
        }
        return (w94) invokeV.objValue;
    }
}
