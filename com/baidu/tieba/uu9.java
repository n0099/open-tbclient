package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class uu9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile tu9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized tu9 a() {
        InterceptResult invokeV;
        tu9 tu9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (uu9.class) {
                if (a == null) {
                    a = new tu9();
                }
                tu9Var = a;
            }
            return tu9Var;
        }
        return (tu9) invokeV.objValue;
    }
}
