package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class xs5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ws5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ws5 a() {
        InterceptResult invokeV;
        ws5 ws5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xs5.class) {
                if (a == null) {
                    a = new ws5();
                }
                ws5Var = a;
            }
            return ws5Var;
        }
        return (ws5) invokeV.objValue;
    }
}
