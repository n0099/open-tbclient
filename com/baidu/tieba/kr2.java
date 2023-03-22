package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class kr2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jr2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized jr2 a() {
        InterceptResult invokeV;
        jr2 jr2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (kr2.class) {
                if (a == null) {
                    a = new jr2();
                }
                jr2Var = a;
            }
            return jr2Var;
        }
        return (jr2) invokeV.objValue;
    }
}
