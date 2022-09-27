package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class zs5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ys5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ys5 a() {
        InterceptResult invokeV;
        ys5 ys5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (zs5.class) {
                if (a == null) {
                    a = new ys5();
                }
                ys5Var = a;
            }
            return ys5Var;
        }
        return (ys5) invokeV.objValue;
    }
}
