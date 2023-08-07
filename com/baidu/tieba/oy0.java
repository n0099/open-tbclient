package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class oy0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ny0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ny0 a() {
        InterceptResult invokeV;
        ny0 ny0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (oy0.class) {
                if (a == null) {
                    a = new ny0();
                }
                ny0Var = a;
            }
            return ny0Var;
        }
        return (ny0) invokeV.objValue;
    }
}
