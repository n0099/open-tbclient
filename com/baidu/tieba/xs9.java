package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class xs9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ws9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ws9 a() {
        InterceptResult invokeV;
        ws9 ws9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xs9.class) {
                if (a == null) {
                    a = new ws9();
                }
                ws9Var = a;
            }
            return ws9Var;
        }
        return (ws9) invokeV.objValue;
    }
}
