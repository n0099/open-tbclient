package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ot9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile nt9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized nt9 a() {
        InterceptResult invokeV;
        nt9 nt9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ot9.class) {
                if (a == null) {
                    a = new nt9();
                }
                nt9Var = a;
            }
            return nt9Var;
        }
        return (nt9) invokeV.objValue;
    }
}
