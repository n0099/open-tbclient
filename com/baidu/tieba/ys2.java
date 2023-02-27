package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ys2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xs2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized xs2 a() {
        InterceptResult invokeV;
        xs2 xs2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ys2.class) {
                if (a == null) {
                    a = new xs2();
                }
                xs2Var = a;
            }
            return xs2Var;
        }
        return (xs2) invokeV.objValue;
    }
}
