package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class xy3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wy3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized wy3 a() {
        InterceptResult invokeV;
        wy3 wy3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xy3.class) {
                if (a == null) {
                    a = new wy3();
                }
                wy3Var = a;
            }
            return wy3Var;
        }
        return (wy3) invokeV.objValue;
    }
}
