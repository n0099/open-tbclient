package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class jr3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ir3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ir3 a() {
        InterceptResult invokeV;
        ir3 ir3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (jr3.class) {
                if (a == null) {
                    a = new ir3();
                }
                ir3Var = a;
            }
            return ir3Var;
        }
        return (ir3) invokeV.objValue;
    }
}
