package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class q76 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile p76 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized p76 a() {
        InterceptResult invokeV;
        p76 p76Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (q76.class) {
                if (a == null) {
                    a = new p76();
                }
                p76Var = a;
            }
            return p76Var;
        }
        return (p76) invokeV.objValue;
    }
}
