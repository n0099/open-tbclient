package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class l96 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile k96 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized k96 a() {
        InterceptResult invokeV;
        k96 k96Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (l96.class) {
                if (a == null) {
                    a = new k96();
                }
                k96Var = a;
            }
            return k96Var;
        }
        return (k96) invokeV.objValue;
    }
}
