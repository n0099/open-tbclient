package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class jz3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile iz3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized iz3 a() {
        InterceptResult invokeV;
        iz3 iz3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (jz3.class) {
                if (a == null) {
                    a = new iz3();
                }
                iz3Var = a;
            }
            return iz3Var;
        }
        return (iz3) invokeV.objValue;
    }
}
