package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class sq3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rq3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized rq3 a() {
        InterceptResult invokeV;
        rq3 rq3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (sq3.class) {
                if (a == null) {
                    a = new rq3();
                }
                rq3Var = a;
            }
            return rq3Var;
        }
        return (rq3) invokeV.objValue;
    }
}
