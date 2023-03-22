package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class n69 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile m69 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized m69 a() {
        InterceptResult invokeV;
        m69 m69Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (n69.class) {
                if (a == null) {
                    a = new m69();
                }
                m69Var = a;
            }
            return m69Var;
        }
        return (m69) invokeV.objValue;
    }
}
