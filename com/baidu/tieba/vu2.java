package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class vu2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile uu2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized uu2 a() {
        InterceptResult invokeV;
        uu2 uu2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (vu2.class) {
                if (a == null) {
                    a = new uu2();
                }
                uu2Var = a;
            }
            return uu2Var;
        }
        return (uu2) invokeV.objValue;
    }
}
