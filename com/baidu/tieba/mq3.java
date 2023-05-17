package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class mq3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile lq3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized lq3 a() {
        InterceptResult invokeV;
        lq3 lq3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (mq3.class) {
                if (a == null) {
                    a = new lq3();
                }
                lq3Var = a;
            }
            return lq3Var;
        }
        return (lq3) invokeV.objValue;
    }
}
