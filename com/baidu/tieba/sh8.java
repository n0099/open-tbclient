package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class sh8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rh8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized rh8 a() {
        InterceptResult invokeV;
        rh8 rh8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (sh8.class) {
                if (a == null) {
                    a = new rh8();
                }
                rh8Var = a;
            }
            return rh8Var;
        }
        return (rh8) invokeV.objValue;
    }
}
