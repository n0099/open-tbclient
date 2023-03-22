package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class j69 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile i69 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized i69 a() {
        InterceptResult invokeV;
        i69 i69Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (j69.class) {
                if (a == null) {
                    a = new i69();
                }
                i69Var = a;
            }
            return i69Var;
        }
        return (i69) invokeV.objValue;
    }
}
