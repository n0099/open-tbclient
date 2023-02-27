package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class uw3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile tw3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized tw3 a() {
        InterceptResult invokeV;
        tw3 tw3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (uw3.class) {
                if (a == null) {
                    a = new tw3();
                }
                tw3Var = a;
            }
            return tw3Var;
        }
        return (tw3) invokeV.objValue;
    }
}
