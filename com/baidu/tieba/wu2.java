package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class wu2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vu2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized vu2 a() {
        InterceptResult invokeV;
        vu2 vu2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (wu2.class) {
                if (a == null) {
                    a = new vu2();
                }
                vu2Var = a;
            }
            return vu2Var;
        }
        return (vu2) invokeV.objValue;
    }
}
