package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class py3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile oy3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized oy3 a() {
        InterceptResult invokeV;
        oy3 oy3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (py3.class) {
                if (a == null) {
                    a = new oy3();
                }
                oy3Var = a;
            }
            return oy3Var;
        }
        return (oy3) invokeV.objValue;
    }
}
