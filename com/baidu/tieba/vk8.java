package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class vk8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile uk8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized uk8 a() {
        InterceptResult invokeV;
        uk8 uk8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (vk8.class) {
                if (a == null) {
                    a = new uk8();
                }
                uk8Var = a;
            }
            return uk8Var;
        }
        return (uk8) invokeV.objValue;
    }
}
