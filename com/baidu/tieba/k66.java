package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class k66 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile j66 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized j66 a() {
        InterceptResult invokeV;
        j66 j66Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (k66.class) {
                if (a == null) {
                    a = new j66();
                }
                j66Var = a;
            }
            return j66Var;
        }
        return (j66) invokeV.objValue;
    }
}
