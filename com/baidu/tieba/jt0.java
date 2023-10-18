package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class jt0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile it0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized it0 a() {
        InterceptResult invokeV;
        it0 it0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (jt0.class) {
                if (a == null) {
                    a = new it0();
                }
                it0Var = a;
            }
            return it0Var;
        }
        return (it0) invokeV.objValue;
    }
}
