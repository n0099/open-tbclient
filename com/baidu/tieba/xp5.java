package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class xp5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wp5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized wp5 a() {
        InterceptResult invokeV;
        wp5 wp5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xp5.class) {
                if (a == null) {
                    a = new wp5();
                }
                wp5Var = a;
            }
            return wp5Var;
        }
        return (wp5) invokeV.objValue;
    }
}
