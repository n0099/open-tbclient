package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class vk2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile uk2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized uk2 a() {
        InterceptResult invokeV;
        uk2 uk2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (vk2.class) {
                if (a == null) {
                    a = new uk2();
                }
                uk2Var = a;
            }
            return uk2Var;
        }
        return (uk2) invokeV.objValue;
    }
}
