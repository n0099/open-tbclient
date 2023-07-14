package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ob6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile nb6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized nb6 a() {
        InterceptResult invokeV;
        nb6 nb6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ob6.class) {
                if (a == null) {
                    a = new nb6();
                }
                nb6Var = a;
            }
            return nb6Var;
        }
        return (nb6) invokeV.objValue;
    }
}
