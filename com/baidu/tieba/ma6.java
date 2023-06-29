package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ma6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile la6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized la6 a() {
        InterceptResult invokeV;
        la6 la6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ma6.class) {
                if (a == null) {
                    a = new la6();
                }
                la6Var = a;
            }
            return la6Var;
        }
        return (la6) invokeV.objValue;
    }
}
