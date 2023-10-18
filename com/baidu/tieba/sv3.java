package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class sv3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rv3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized rv3 a() {
        InterceptResult invokeV;
        rv3 rv3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (sv3.class) {
                if (a == null) {
                    a = new rv3();
                }
                rv3Var = a;
            }
            return rv3Var;
        }
        return (rv3) invokeV.objValue;
    }
}
