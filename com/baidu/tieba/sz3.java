package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class sz3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rz3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized rz3 a() {
        InterceptResult invokeV;
        rz3 rz3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (sz3.class) {
                if (a == null) {
                    a = new rz3();
                }
                rz3Var = a;
            }
            return rz3Var;
        }
        return (rz3) invokeV.objValue;
    }
}
