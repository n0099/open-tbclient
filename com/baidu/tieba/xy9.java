package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class xy9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wy9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized wy9 a() {
        InterceptResult invokeV;
        wy9 wy9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xy9.class) {
                if (a == null) {
                    a = new wy9();
                }
                wy9Var = a;
            }
            return wy9Var;
        }
        return (wy9) invokeV.objValue;
    }
}
