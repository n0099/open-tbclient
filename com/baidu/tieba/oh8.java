package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class oh8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile nh8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized nh8 a() {
        InterceptResult invokeV;
        nh8 nh8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (oh8.class) {
                if (a == null) {
                    a = new nh8();
                }
                nh8Var = a;
            }
            return nh8Var;
        }
        return (nh8) invokeV.objValue;
    }
}
