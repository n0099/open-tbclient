package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class vk9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile uk9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized uk9 a() {
        InterceptResult invokeV;
        uk9 uk9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (vk9.class) {
                if (a == null) {
                    a = new uk9();
                }
                uk9Var = a;
            }
            return uk9Var;
        }
        return (uk9) invokeV.objValue;
    }
}
