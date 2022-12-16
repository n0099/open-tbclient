package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class tn8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile sn8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized sn8 a() {
        InterceptResult invokeV;
        sn8 sn8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (tn8.class) {
                if (a == null) {
                    a = new sn8();
                }
                sn8Var = a;
            }
            return sn8Var;
        }
        return (sn8) invokeV.objValue;
    }
}
