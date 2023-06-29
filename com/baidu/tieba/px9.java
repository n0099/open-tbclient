package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class px9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ox9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ox9 a() {
        InterceptResult invokeV;
        ox9 ox9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (px9.class) {
                if (a == null) {
                    a = new ox9();
                }
                ox9Var = a;
            }
            return ox9Var;
        }
        return (ox9) invokeV.objValue;
    }
}
