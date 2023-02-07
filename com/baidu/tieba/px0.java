package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class px0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ox0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ox0 a() {
        InterceptResult invokeV;
        ox0 ox0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (px0.class) {
                if (a == null) {
                    a = new ox0();
                }
                ox0Var = a;
            }
            return ox0Var;
        }
        return (ox0) invokeV.objValue;
    }
}
