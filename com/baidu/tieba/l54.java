package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class l54 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile k54 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized k54 a() {
        InterceptResult invokeV;
        k54 k54Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (l54.class) {
                if (a == null) {
                    a = new k54();
                }
                k54Var = a;
            }
            return k54Var;
        }
        return (k54) invokeV.objValue;
    }
}
