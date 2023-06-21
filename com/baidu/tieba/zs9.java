package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class zs9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ys9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ys9 a() {
        InterceptResult invokeV;
        ys9 ys9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (zs9.class) {
                if (a == null) {
                    a = new ys9();
                }
                ys9Var = a;
            }
            return ys9Var;
        }
        return (ys9) invokeV.objValue;
    }
}
