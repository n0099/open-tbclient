package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class w96 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile v96 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized v96 a() {
        InterceptResult invokeV;
        v96 v96Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (w96.class) {
                if (a == null) {
                    a = new v96();
                }
                v96Var = a;
            }
            return v96Var;
        }
        return (v96) invokeV.objValue;
    }
}
