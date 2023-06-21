package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class st9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rt9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized rt9 a() {
        InterceptResult invokeV;
        rt9 rt9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (st9.class) {
                if (a == null) {
                    a = new rt9();
                }
                rt9Var = a;
            }
            return rt9Var;
        }
        return (rt9) invokeV.objValue;
    }
}
