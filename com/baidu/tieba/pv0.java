package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class pv0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ov0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ov0 a() {
        InterceptResult invokeV;
        ov0 ov0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (pv0.class) {
                if (a == null) {
                    a = new ov0();
                }
                ov0Var = a;
            }
            return ov0Var;
        }
        return (ov0) invokeV.objValue;
    }
}
