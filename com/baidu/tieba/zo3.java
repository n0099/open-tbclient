package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class zo3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yo3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized yo3 a() {
        InterceptResult invokeV;
        yo3 yo3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (zo3.class) {
                if (a == null) {
                    a = new yo3();
                }
                yo3Var = a;
            }
            return yo3Var;
        }
        return (yo3) invokeV.objValue;
    }
}
