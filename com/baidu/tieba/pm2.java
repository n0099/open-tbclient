package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class pm2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile om2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized om2 a() {
        InterceptResult invokeV;
        om2 om2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (pm2.class) {
                if (a == null) {
                    a = new om2();
                }
                om2Var = a;
            }
            return om2Var;
        }
        return (om2) invokeV.objValue;
    }
}
