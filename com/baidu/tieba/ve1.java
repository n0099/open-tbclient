package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ve1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ue1 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ue1 a() {
        InterceptResult invokeV;
        ue1 ue1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ve1.class) {
                if (a == null) {
                    a = new ue1();
                }
                ue1Var = a;
            }
            return ue1Var;
        }
        return (ue1) invokeV.objValue;
    }
}
