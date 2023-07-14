package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class jy6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile iy6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized iy6 a() {
        InterceptResult invokeV;
        iy6 iy6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (jy6.class) {
                if (a == null) {
                    a = new iy6();
                }
                iy6Var = a;
            }
            return iy6Var;
        }
        return (iy6) invokeV.objValue;
    }
}
