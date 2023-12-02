package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class n84 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile m84 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized m84 a() {
        InterceptResult invokeV;
        m84 m84Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (n84.class) {
                if (a == null) {
                    a = new m84();
                }
                m84Var = a;
            }
            return m84Var;
        }
        return (m84) invokeV.objValue;
    }
}
