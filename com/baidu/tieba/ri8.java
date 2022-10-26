package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ri8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qi8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qi8 a() {
        InterceptResult invokeV;
        qi8 qi8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ri8.class) {
                if (a == null) {
                    a = new qi8();
                }
                qi8Var = a;
            }
            return qi8Var;
        }
        return (qi8) invokeV.objValue;
    }
}
