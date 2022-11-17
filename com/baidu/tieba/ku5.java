package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class ku5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ju5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ju5 a() {
        InterceptResult invokeV;
        ju5 ju5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ku5.class) {
                if (a == null) {
                    a = new ju5();
                }
                ju5Var = a;
            }
            return ju5Var;
        }
        return (ju5) invokeV.objValue;
    }
}
