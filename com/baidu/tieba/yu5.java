package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class yu5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xu5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized xu5 a() {
        InterceptResult invokeV;
        xu5 xu5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (yu5.class) {
                if (a == null) {
                    a = new xu5();
                }
                xu5Var = a;
            }
            return xu5Var;
        }
        return (xu5) invokeV.objValue;
    }
}
