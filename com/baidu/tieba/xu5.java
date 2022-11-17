package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class xu5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wu5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized wu5 a() {
        InterceptResult invokeV;
        wu5 wu5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xu5.class) {
                if (a == null) {
                    a = new wu5();
                }
                wu5Var = a;
            }
            return wu5Var;
        }
        return (wu5) invokeV.objValue;
    }
}
