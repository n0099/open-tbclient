package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ja6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ia6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ia6 a() {
        InterceptResult invokeV;
        ia6 ia6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ja6.class) {
                if (a == null) {
                    a = new ia6();
                }
                ia6Var = a;
            }
            return ia6Var;
        }
        return (ia6) invokeV.objValue;
    }
}
