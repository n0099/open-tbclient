package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class pu3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ou3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ou3 a() {
        InterceptResult invokeV;
        ou3 ou3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (pu3.class) {
                if (a == null) {
                    a = new ou3();
                }
                ou3Var = a;
            }
            return ou3Var;
        }
        return (ou3) invokeV.objValue;
    }
}
