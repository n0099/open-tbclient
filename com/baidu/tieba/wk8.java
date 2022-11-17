package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class wk8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vk8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized vk8 a() {
        InterceptResult invokeV;
        vk8 vk8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (wk8.class) {
                if (a == null) {
                    a = new vk8();
                }
                vk8Var = a;
            }
            return vk8Var;
        }
        return (vk8) invokeV.objValue;
    }
}
