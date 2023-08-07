package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class zx0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yx0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized yx0 a() {
        InterceptResult invokeV;
        yx0 yx0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (zx0.class) {
                if (a == null) {
                    a = new yx0();
                }
                yx0Var = a;
            }
            return yx0Var;
        }
        return (yx0) invokeV.objValue;
    }
}
