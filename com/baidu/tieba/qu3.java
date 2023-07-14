package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class qu3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pu3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized pu3 a() {
        InterceptResult invokeV;
        pu3 pu3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (qu3.class) {
                if (a == null) {
                    a = new pu3();
                }
                pu3Var = a;
            }
            return pu3Var;
        }
        return (pu3) invokeV.objValue;
    }
}
