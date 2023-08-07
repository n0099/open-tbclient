package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class tt3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile st3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized st3 a() {
        InterceptResult invokeV;
        st3 st3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (tt3.class) {
                if (a == null) {
                    a = new st3();
                }
                st3Var = a;
            }
            return st3Var;
        }
        return (st3) invokeV.objValue;
    }
}
