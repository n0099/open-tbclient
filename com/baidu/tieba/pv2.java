package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class pv2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ov2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ov2 a() {
        InterceptResult invokeV;
        ov2 ov2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (pv2.class) {
                if (a == null) {
                    a = new ov2();
                }
                ov2Var = a;
            }
            return ov2Var;
        }
        return (ov2) invokeV.objValue;
    }
}
