package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class pm3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile om3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized om3 a() {
        InterceptResult invokeV;
        om3 om3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (pm3.class) {
                if (a == null) {
                    a = new om3();
                }
                om3Var = a;
            }
            return om3Var;
        }
        return (om3) invokeV.objValue;
    }
}
