package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class xu2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wu2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized wu2 a() {
        InterceptResult invokeV;
        wu2 wu2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xu2.class) {
                if (a == null) {
                    a = new wu2();
                }
                wu2Var = a;
            }
            return wu2Var;
        }
        return (wu2) invokeV.objValue;
    }
}
