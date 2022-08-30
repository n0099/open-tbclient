package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class sx3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rx3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized rx3 a() {
        InterceptResult invokeV;
        rx3 rx3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (sx3.class) {
                if (a == null) {
                    a = new rx3();
                }
                rx3Var = a;
            }
            return rx3Var;
        }
        return (rx3) invokeV.objValue;
    }
}
