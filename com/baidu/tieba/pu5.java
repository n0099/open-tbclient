package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class pu5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ou5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ou5 a() {
        InterceptResult invokeV;
        ou5 ou5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (pu5.class) {
                if (a == null) {
                    a = new ou5();
                }
                ou5Var = a;
            }
            return ou5Var;
        }
        return (ou5) invokeV.objValue;
    }
}
