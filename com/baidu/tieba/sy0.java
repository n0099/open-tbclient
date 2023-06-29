package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class sy0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ry0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ry0 a() {
        InterceptResult invokeV;
        ry0 ry0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (sy0.class) {
                if (a == null) {
                    a = new ry0();
                }
                ry0Var = a;
            }
            return ry0Var;
        }
        return (ry0) invokeV.objValue;
    }
}
