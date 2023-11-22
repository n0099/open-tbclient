package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class yka {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xka a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized xka a() {
        InterceptResult invokeV;
        xka xkaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (yka.class) {
                if (a == null) {
                    a = new xka();
                }
                xkaVar = a;
            }
            return xkaVar;
        }
        return (xka) invokeV.objValue;
    }
}
