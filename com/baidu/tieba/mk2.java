package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class mk2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile lk2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized lk2 a() {
        InterceptResult invokeV;
        lk2 lk2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (mk2.class) {
                if (a == null) {
                    a = new lk2();
                }
                lk2Var = a;
            }
            return lk2Var;
        }
        return (lk2) invokeV.objValue;
    }
}
