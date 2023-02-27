package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class n64 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile m64 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized m64 a() {
        InterceptResult invokeV;
        m64 m64Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (n64.class) {
                if (a == null) {
                    a = new m64();
                }
                m64Var = a;
            }
            return m64Var;
        }
        return (m64) invokeV.objValue;
    }
}
