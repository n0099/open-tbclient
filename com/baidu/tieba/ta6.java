package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class ta6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile sa6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized sa6 a() {
        InterceptResult invokeV;
        sa6 sa6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ta6.class) {
                if (a == null) {
                    a = new sa6();
                }
                sa6Var = a;
            }
            return sa6Var;
        }
        return (sa6) invokeV.objValue;
    }
}
