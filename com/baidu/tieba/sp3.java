package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class sp3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rp3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized rp3 a() {
        InterceptResult invokeV;
        rp3 rp3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (sp3.class) {
                if (a == null) {
                    a = new rp3();
                }
                rp3Var = a;
            }
            return rp3Var;
        }
        return (rp3) invokeV.objValue;
    }
}
