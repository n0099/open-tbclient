package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class sp2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rp2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized rp2 a() {
        InterceptResult invokeV;
        rp2 rp2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (sp2.class) {
                if (a == null) {
                    a = new rp2();
                }
                rp2Var = a;
            }
            return rp2Var;
        }
        return (rp2) invokeV.objValue;
    }
}
