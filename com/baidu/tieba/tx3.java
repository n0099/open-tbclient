package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class tx3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile sx3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized sx3 a() {
        InterceptResult invokeV;
        sx3 sx3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (tx3.class) {
                if (a == null) {
                    a = new sx3();
                }
                sx3Var = a;
            }
            return sx3Var;
        }
        return (sx3) invokeV.objValue;
    }
}
