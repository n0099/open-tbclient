package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class rs5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qs5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qs5 a() {
        InterceptResult invokeV;
        qs5 qs5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rs5.class) {
                if (a == null) {
                    a = new qs5();
                }
                qs5Var = a;
            }
            return qs5Var;
        }
        return (qs5) invokeV.objValue;
    }
}
