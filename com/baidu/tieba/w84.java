package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class w84 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile v84 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized v84 a() {
        InterceptResult invokeV;
        v84 v84Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (w84.class) {
                if (a == null) {
                    a = new v84();
                }
                v84Var = a;
            }
            return v84Var;
        }
        return (v84) invokeV.objValue;
    }
}
