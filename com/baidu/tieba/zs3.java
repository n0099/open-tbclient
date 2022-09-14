package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class zs3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ys3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ys3 a() {
        InterceptResult invokeV;
        ys3 ys3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (zs3.class) {
                if (a == null) {
                    a = new ys3();
                }
                ys3Var = a;
            }
            return ys3Var;
        }
        return (ys3) invokeV.objValue;
    }
}
