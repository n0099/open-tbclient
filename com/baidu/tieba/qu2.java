package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class qu2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pu2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized pu2 a() {
        InterceptResult invokeV;
        pu2 pu2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (qu2.class) {
                if (a == null) {
                    a = new pu2();
                }
                pu2Var = a;
            }
            return pu2Var;
        }
        return (pu2) invokeV.objValue;
    }
}
