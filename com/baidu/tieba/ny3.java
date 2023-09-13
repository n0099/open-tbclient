package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ny3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile my3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized my3 a() {
        InterceptResult invokeV;
        my3 my3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ny3.class) {
                if (a == null) {
                    a = new my3();
                }
                my3Var = a;
            }
            return my3Var;
        }
        return (my3) invokeV.objValue;
    }
}
