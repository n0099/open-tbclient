package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class zx3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yx3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized yx3 a() {
        InterceptResult invokeV;
        yx3 yx3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (zx3.class) {
                if (a == null) {
                    a = new yx3();
                }
                yx3Var = a;
            }
            return yx3Var;
        }
        return (yx3) invokeV.objValue;
    }
}
