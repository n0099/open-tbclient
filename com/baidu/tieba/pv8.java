package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class pv8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ov8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ov8 a() {
        InterceptResult invokeV;
        ov8 ov8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (pv8.class) {
                if (a == null) {
                    a = new ov8();
                }
                ov8Var = a;
            }
            return ov8Var;
        }
        return (ov8) invokeV.objValue;
    }
}
