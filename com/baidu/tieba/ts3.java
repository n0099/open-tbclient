package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class ts3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ss3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ss3 a() {
        InterceptResult invokeV;
        ss3 ss3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ts3.class) {
                if (a == null) {
                    a = new ss3();
                }
                ss3Var = a;
            }
            return ss3Var;
        }
        return (ss3) invokeV.objValue;
    }
}
