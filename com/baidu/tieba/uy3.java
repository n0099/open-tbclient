package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class uy3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ty3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ty3 a() {
        InterceptResult invokeV;
        ty3 ty3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (uy3.class) {
                if (a == null) {
                    a = new ty3();
                }
                ty3Var = a;
            }
            return ty3Var;
        }
        return (ty3) invokeV.objValue;
    }
}
