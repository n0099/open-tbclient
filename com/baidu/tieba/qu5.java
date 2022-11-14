package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class qu5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pu5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized pu5 a() {
        InterceptResult invokeV;
        pu5 pu5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (qu5.class) {
                if (a == null) {
                    a = new pu5();
                }
                pu5Var = a;
            }
            return pu5Var;
        }
        return (pu5) invokeV.objValue;
    }
}
