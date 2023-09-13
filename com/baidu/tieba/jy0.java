package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class jy0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile iy0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized iy0 a() {
        InterceptResult invokeV;
        iy0 iy0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (jy0.class) {
                if (a == null) {
                    a = new iy0();
                }
                iy0Var = a;
            }
            return iy0Var;
        }
        return (iy0) invokeV.objValue;
    }
}
