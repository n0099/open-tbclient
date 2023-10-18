package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class lt0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile kt0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized kt0 a() {
        InterceptResult invokeV;
        kt0 kt0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (lt0.class) {
                if (a == null) {
                    a = new kt0();
                }
                kt0Var = a;
            }
            return kt0Var;
        }
        return (kt0) invokeV.objValue;
    }
}
