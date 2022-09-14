package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class nm2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mm2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized mm2 a() {
        InterceptResult invokeV;
        mm2 mm2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (nm2.class) {
                if (a == null) {
                    a = new mm2();
                }
                mm2Var = a;
            }
            return mm2Var;
        }
        return (mm2) invokeV.objValue;
    }
}
