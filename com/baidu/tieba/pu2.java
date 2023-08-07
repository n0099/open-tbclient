package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class pu2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ou2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ou2 a() {
        InterceptResult invokeV;
        ou2 ou2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (pu2.class) {
                if (a == null) {
                    a = new ou2();
                }
                ou2Var = a;
            }
            return ou2Var;
        }
        return (ou2) invokeV.objValue;
    }
}
