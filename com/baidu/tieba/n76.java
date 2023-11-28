package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class n76 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile m76 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized m76 a() {
        InterceptResult invokeV;
        m76 m76Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (n76.class) {
                if (a == null) {
                    a = new m76();
                }
                m76Var = a;
            }
            return m76Var;
        }
        return (m76) invokeV.objValue;
    }
}
