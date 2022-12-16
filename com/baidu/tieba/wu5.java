package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class wu5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vu5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized vu5 a() {
        InterceptResult invokeV;
        vu5 vu5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (wu5.class) {
                if (a == null) {
                    a = new vu5();
                }
                vu5Var = a;
            }
            return vu5Var;
        }
        return (vu5) invokeV.objValue;
    }
}
