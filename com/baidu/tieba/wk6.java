package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class wk6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vk6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized vk6 a() {
        InterceptResult invokeV;
        vk6 vk6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (wk6.class) {
                if (a == null) {
                    a = new vk6();
                }
                vk6Var = a;
            }
            return vk6Var;
        }
        return (vk6) invokeV.objValue;
    }
}
