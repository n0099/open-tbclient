package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ly0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ky0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ky0 a() {
        InterceptResult invokeV;
        ky0 ky0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ly0.class) {
                if (a == null) {
                    a = new ky0();
                }
                ky0Var = a;
            }
            return ky0Var;
        }
        return (ky0) invokeV.objValue;
    }
}
