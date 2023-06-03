package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class vr9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ur9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ur9 a() {
        InterceptResult invokeV;
        ur9 ur9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (vr9.class) {
                if (a == null) {
                    a = new ur9();
                }
                ur9Var = a;
            }
            return ur9Var;
        }
        return (ur9) invokeV.objValue;
    }
}
