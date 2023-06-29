package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class px3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ox3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ox3 a() {
        InterceptResult invokeV;
        ox3 ox3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (px3.class) {
                if (a == null) {
                    a = new ox3();
                }
                ox3Var = a;
            }
            return ox3Var;
        }
        return (ox3) invokeV.objValue;
    }
}
