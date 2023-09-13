package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class n80 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile m80 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized m80 a() {
        InterceptResult invokeV;
        m80 m80Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (n80.class) {
                if (a == null) {
                    a = new m80();
                }
                m80Var = a;
            }
            return m80Var;
        }
        return (m80) invokeV.objValue;
    }
}
