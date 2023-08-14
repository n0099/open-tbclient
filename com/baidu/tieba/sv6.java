package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class sv6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rv6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized rv6 a() {
        InterceptResult invokeV;
        rv6 rv6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (sv6.class) {
                if (a == null) {
                    a = new rv6();
                }
                rv6Var = a;
            }
            return rv6Var;
        }
        return (rv6) invokeV.objValue;
    }
}
