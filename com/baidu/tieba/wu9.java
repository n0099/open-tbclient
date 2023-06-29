package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class wu9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vu9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized vu9 a() {
        InterceptResult invokeV;
        vu9 vu9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (wu9.class) {
                if (a == null) {
                    a = new vu9();
                }
                vu9Var = a;
            }
            return vu9Var;
        }
        return (vu9) invokeV.objValue;
    }
}
