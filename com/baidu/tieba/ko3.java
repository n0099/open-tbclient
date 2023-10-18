package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ko3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jo3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized jo3 a() {
        InterceptResult invokeV;
        jo3 jo3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ko3.class) {
                if (a == null) {
                    a = new jo3();
                }
                jo3Var = a;
            }
            return jo3Var;
        }
        return (jo3) invokeV.objValue;
    }
}
