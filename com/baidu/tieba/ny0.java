package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ny0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile my0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized my0 a() {
        InterceptResult invokeV;
        my0 my0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ny0.class) {
                if (a == null) {
                    a = new my0();
                }
                my0Var = a;
            }
            return my0Var;
        }
        return (my0) invokeV.objValue;
    }
}
