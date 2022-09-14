package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class jr5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ir5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ir5 a() {
        InterceptResult invokeV;
        ir5 ir5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (jr5.class) {
                if (a == null) {
                    a = new ir5();
                }
                ir5Var = a;
            }
            return ir5Var;
        }
        return (ir5) invokeV.objValue;
    }
}
