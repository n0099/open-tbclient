package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class qy0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile py0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized py0 a() {
        InterceptResult invokeV;
        py0 py0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (qy0.class) {
                if (a == null) {
                    a = new py0();
                }
                py0Var = a;
            }
            return py0Var;
        }
        return (py0) invokeV.objValue;
    }
}
