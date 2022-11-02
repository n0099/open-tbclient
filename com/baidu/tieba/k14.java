package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class k14 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile j14 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized j14 a() {
        InterceptResult invokeV;
        j14 j14Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (k14.class) {
                if (a == null) {
                    a = new j14();
                }
                j14Var = a;
            }
            return j14Var;
        }
        return (j14) invokeV.objValue;
    }
}
