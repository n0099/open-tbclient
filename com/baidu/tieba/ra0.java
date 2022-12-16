package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ra0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qa0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qa0 a() {
        InterceptResult invokeV;
        qa0 qa0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ra0.class) {
                if (a == null) {
                    a = new qa0();
                }
                qa0Var = a;
            }
            return qa0Var;
        }
        return (qa0) invokeV.objValue;
    }
}
