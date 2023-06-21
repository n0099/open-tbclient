package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class sv2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rv2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized rv2 a() {
        InterceptResult invokeV;
        rv2 rv2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (sv2.class) {
                if (a == null) {
                    a = new rv2();
                }
                rv2Var = a;
            }
            return rv2Var;
        }
        return (rv2) invokeV.objValue;
    }
}
