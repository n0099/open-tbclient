package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class sw0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rw0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized rw0 a() {
        InterceptResult invokeV;
        rw0 rw0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (sw0.class) {
                if (a == null) {
                    a = new rw0();
                }
                rw0Var = a;
            }
            return rw0Var;
        }
        return (rw0) invokeV.objValue;
    }
}
