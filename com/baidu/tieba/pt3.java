package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class pt3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ot3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ot3 a() {
        InterceptResult invokeV;
        ot3 ot3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (pt3.class) {
                if (a == null) {
                    a = new ot3();
                }
                ot3Var = a;
            }
            return ot3Var;
        }
        return (ot3) invokeV.objValue;
    }
}
