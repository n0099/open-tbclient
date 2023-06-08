package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class so9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ro9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ro9 a() {
        InterceptResult invokeV;
        ro9 ro9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (so9.class) {
                if (a == null) {
                    a = new ro9();
                }
                ro9Var = a;
            }
            return ro9Var;
        }
        return (ro9) invokeV.objValue;
    }
}
