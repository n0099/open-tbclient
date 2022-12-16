package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class sv5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rv5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized rv5 a() {
        InterceptResult invokeV;
        rv5 rv5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (sv5.class) {
                if (a == null) {
                    a = new rv5();
                }
                rv5Var = a;
            }
            return rv5Var;
        }
        return (rv5) invokeV.objValue;
    }
}
