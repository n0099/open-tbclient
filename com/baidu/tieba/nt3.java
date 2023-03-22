package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class nt3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mt3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized mt3 a() {
        InterceptResult invokeV;
        mt3 mt3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (nt3.class) {
                if (a == null) {
                    a = new mt3();
                }
                mt3Var = a;
            }
            return mt3Var;
        }
        return (mt3) invokeV.objValue;
    }
}
