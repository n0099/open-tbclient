package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class j84 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile i84 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized i84 a() {
        InterceptResult invokeV;
        i84 i84Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (j84.class) {
                if (a == null) {
                    a = new i84();
                }
                i84Var = a;
            }
            return i84Var;
        }
        return (i84) invokeV.objValue;
    }
}
