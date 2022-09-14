package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class uu0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile tu0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized tu0 a() {
        InterceptResult invokeV;
        tu0 tu0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (uu0.class) {
                if (a == null) {
                    a = new tu0();
                }
                tu0Var = a;
            }
            return tu0Var;
        }
        return (tu0) invokeV.objValue;
    }
}
