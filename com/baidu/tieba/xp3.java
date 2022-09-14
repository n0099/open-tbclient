package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class xp3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wp3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized wp3 a() {
        InterceptResult invokeV;
        wp3 wp3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xp3.class) {
                if (a == null) {
                    a = new wp3();
                }
                wp3Var = a;
            }
            return wp3Var;
        }
        return (wp3) invokeV.objValue;
    }
}
