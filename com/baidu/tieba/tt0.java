package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class tt0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile st0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized st0 a() {
        InterceptResult invokeV;
        st0 st0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (tt0.class) {
                if (a == null) {
                    a = new st0();
                }
                st0Var = a;
            }
            return st0Var;
        }
        return (st0) invokeV.objValue;
    }
}
