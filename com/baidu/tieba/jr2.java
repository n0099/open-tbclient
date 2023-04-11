package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class jr2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ir2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ir2 a() {
        InterceptResult invokeV;
        ir2 ir2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (jr2.class) {
                if (a == null) {
                    a = new ir2();
                }
                ir2Var = a;
            }
            return ir2Var;
        }
        return (ir2) invokeV.objValue;
    }
}
