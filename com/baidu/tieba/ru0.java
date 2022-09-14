package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ru0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qu0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qu0 a() {
        InterceptResult invokeV;
        qu0 qu0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ru0.class) {
                if (a == null) {
                    a = new qu0();
                }
                qu0Var = a;
            }
            return qu0Var;
        }
        return (qu0) invokeV.objValue;
    }
}
