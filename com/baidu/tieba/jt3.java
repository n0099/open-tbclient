package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class jt3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile it3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized it3 a() {
        InterceptResult invokeV;
        it3 it3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (jt3.class) {
                if (a == null) {
                    a = new it3();
                }
                it3Var = a;
            }
            return it3Var;
        }
        return (it3) invokeV.objValue;
    }
}
