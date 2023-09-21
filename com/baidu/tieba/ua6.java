package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class ua6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ta6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ta6 a() {
        InterceptResult invokeV;
        ta6 ta6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ua6.class) {
                if (a == null) {
                    a = new ta6();
                }
                ta6Var = a;
            }
            return ta6Var;
        }
        return (ta6) invokeV.objValue;
    }
}
