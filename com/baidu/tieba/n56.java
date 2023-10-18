package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class n56 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile m56 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized m56 a() {
        InterceptResult invokeV;
        m56 m56Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (n56.class) {
                if (a == null) {
                    a = new m56();
                }
                m56Var = a;
            }
            return m56Var;
        }
        return (m56) invokeV.objValue;
    }
}
