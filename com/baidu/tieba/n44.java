package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class n44 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile m44 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized m44 a() {
        InterceptResult invokeV;
        m44 m44Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (n44.class) {
                if (a == null) {
                    a = new m44();
                }
                m44Var = a;
            }
            return m44Var;
        }
        return (m44) invokeV.objValue;
    }
}
