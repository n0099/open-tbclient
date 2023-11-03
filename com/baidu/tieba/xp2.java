package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class xp2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wp2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized wp2 a() {
        InterceptResult invokeV;
        wp2 wp2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xp2.class) {
                if (a == null) {
                    a = new wp2();
                }
                wp2Var = a;
            }
            return wp2Var;
        }
        return (wp2) invokeV.objValue;
    }
}
