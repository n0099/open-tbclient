package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class qn8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pn8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized pn8 a() {
        InterceptResult invokeV;
        pn8 pn8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (qn8.class) {
                if (a == null) {
                    a = new pn8();
                }
                pn8Var = a;
            }
            return pn8Var;
        }
        return (pn8) invokeV.objValue;
    }
}
