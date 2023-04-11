package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class o26 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile n26 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized n26 a() {
        InterceptResult invokeV;
        n26 n26Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (o26.class) {
                if (a == null) {
                    a = new n26();
                }
                n26Var = a;
            }
            return n26Var;
        }
        return (n26) invokeV.objValue;
    }
}
