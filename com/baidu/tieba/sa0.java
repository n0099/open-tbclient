package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class sa0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ra0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ra0 a() {
        InterceptResult invokeV;
        ra0 ra0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (sa0.class) {
                if (a == null) {
                    a = new ra0();
                }
                ra0Var = a;
            }
            return ra0Var;
        }
        return (ra0) invokeV.objValue;
    }
}
