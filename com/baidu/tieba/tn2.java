package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class tn2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile sn2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized sn2 a() {
        InterceptResult invokeV;
        sn2 sn2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (tn2.class) {
                if (a == null) {
                    a = new sn2();
                }
                sn2Var = a;
            }
            return sn2Var;
        }
        return (sn2) invokeV.objValue;
    }
}
