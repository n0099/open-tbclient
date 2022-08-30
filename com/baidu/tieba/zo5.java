package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class zo5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yo5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized yo5 a() {
        InterceptResult invokeV;
        yo5 yo5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (zo5.class) {
                if (a == null) {
                    a = new yo5();
                }
                yo5Var = a;
            }
            return yo5Var;
        }
        return (yo5) invokeV.objValue;
    }
}
