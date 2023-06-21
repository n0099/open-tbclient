package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class n96 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile m96 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized m96 a() {
        InterceptResult invokeV;
        m96 m96Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (n96.class) {
                if (a == null) {
                    a = new m96();
                }
                m96Var = a;
            }
            return m96Var;
        }
        return (m96) invokeV.objValue;
    }
}
