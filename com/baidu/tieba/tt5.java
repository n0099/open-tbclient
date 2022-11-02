package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class tt5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile st5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized st5 a() {
        InterceptResult invokeV;
        st5 st5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (tt5.class) {
                if (a == null) {
                    a = new st5();
                }
                st5Var = a;
            }
            return st5Var;
        }
        return (st5) invokeV.objValue;
    }
}
