package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class vs5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile us5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized us5 a() {
        InterceptResult invokeV;
        us5 us5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (vs5.class) {
                if (a == null) {
                    a = new us5();
                }
                us5Var = a;
            }
            return us5Var;
        }
        return (us5) invokeV.objValue;
    }
}
