package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class qn2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pn2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized pn2 a() {
        InterceptResult invokeV;
        pn2 pn2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (qn2.class) {
                if (a == null) {
                    a = new pn2();
                }
                pn2Var = a;
            }
            return pn2Var;
        }
        return (pn2) invokeV.objValue;
    }
}
