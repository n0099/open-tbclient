package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class zo2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yo2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized yo2 a() {
        InterceptResult invokeV;
        yo2 yo2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (zo2.class) {
                if (a == null) {
                    a = new yo2();
                }
                yo2Var = a;
            }
            return yo2Var;
        }
        return (yo2) invokeV.objValue;
    }
}
