package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class jy3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile iy3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized iy3 a() {
        InterceptResult invokeV;
        iy3 iy3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (jy3.class) {
                if (a == null) {
                    a = new iy3();
                }
                iy3Var = a;
            }
            return iy3Var;
        }
        return (iy3) invokeV.objValue;
    }
}
