package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class xu3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wu3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized wu3 a() {
        InterceptResult invokeV;
        wu3 wu3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xu3.class) {
                if (a == null) {
                    a = new wu3();
                }
                wu3Var = a;
            }
            return wu3Var;
        }
        return (wu3) invokeV.objValue;
    }
}
