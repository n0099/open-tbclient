package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class iy3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hy3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized hy3 a() {
        InterceptResult invokeV;
        hy3 hy3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (iy3.class) {
                if (a == null) {
                    a = new hy3();
                }
                hy3Var = a;
            }
            return hy3Var;
        }
        return (hy3) invokeV.objValue;
    }
}
