package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class xs6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ws6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ws6 a() {
        InterceptResult invokeV;
        ws6 ws6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xs6.class) {
                if (a == null) {
                    a = new ws6();
                }
                ws6Var = a;
            }
            return ws6Var;
        }
        return (ws6) invokeV.objValue;
    }
}
