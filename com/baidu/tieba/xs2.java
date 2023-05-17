package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class xs2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ws2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ws2 a() {
        InterceptResult invokeV;
        ws2 ws2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xs2.class) {
                if (a == null) {
                    a = new ws2();
                }
                ws2Var = a;
            }
            return ws2Var;
        }
        return (ws2) invokeV.objValue;
    }
}
