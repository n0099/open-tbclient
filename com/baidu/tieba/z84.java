package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class z84 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile y84 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized y84 a() {
        InterceptResult invokeV;
        y84 y84Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (z84.class) {
                if (a == null) {
                    a = new y84();
                }
                y84Var = a;
            }
            return y84Var;
        }
        return (y84) invokeV.objValue;
    }
}
