package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class uc4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile tc4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized tc4 a() {
        InterceptResult invokeV;
        tc4 tc4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (uc4.class) {
                if (a == null) {
                    a = new tc4();
                }
                tc4Var = a;
            }
            return tc4Var;
        }
        return (tc4) invokeV.objValue;
    }
}
