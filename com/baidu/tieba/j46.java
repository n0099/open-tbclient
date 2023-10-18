package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class j46 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile i46 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized i46 a() {
        InterceptResult invokeV;
        i46 i46Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (j46.class) {
                if (a == null) {
                    a = new i46();
                }
                i46Var = a;
            }
            return i46Var;
        }
        return (i46) invokeV.objValue;
    }
}
