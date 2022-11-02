package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class mt5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile lt5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized lt5 a() {
        InterceptResult invokeV;
        lt5 lt5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (mt5.class) {
                if (a == null) {
                    a = new lt5();
                }
                lt5Var = a;
            }
            return lt5Var;
        }
        return (lt5) invokeV.objValue;
    }
}
