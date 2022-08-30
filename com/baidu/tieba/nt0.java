package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class nt0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mt0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized mt0 a() {
        InterceptResult invokeV;
        mt0 mt0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (nt0.class) {
                if (a == null) {
                    a = new mt0();
                }
                mt0Var = a;
            }
            return mt0Var;
        }
        return (mt0) invokeV.objValue;
    }
}
