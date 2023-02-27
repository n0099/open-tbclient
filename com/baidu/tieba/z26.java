package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class z26 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile y26 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized y26 a() {
        InterceptResult invokeV;
        y26 y26Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (z26.class) {
                if (a == null) {
                    a = new y26();
                }
                y26Var = a;
            }
            return y26Var;
        }
        return (y26) invokeV.objValue;
    }
}
