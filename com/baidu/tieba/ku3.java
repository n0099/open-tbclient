package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ku3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ju3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ju3 a() {
        InterceptResult invokeV;
        ju3 ju3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ku3.class) {
                if (a == null) {
                    a = new ju3();
                }
                ju3Var = a;
            }
            return ju3Var;
        }
        return (ju3) invokeV.objValue;
    }
}
