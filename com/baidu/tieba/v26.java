package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class v26 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile u26 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized u26 a() {
        InterceptResult invokeV;
        u26 u26Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (v26.class) {
                if (a == null) {
                    a = new u26();
                }
                u26Var = a;
            }
            return u26Var;
        }
        return (u26) invokeV.objValue;
    }
}
