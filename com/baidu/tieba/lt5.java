package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class lt5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile kt5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized kt5 a() {
        InterceptResult invokeV;
        kt5 kt5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (lt5.class) {
                if (a == null) {
                    a = new kt5();
                }
                kt5Var = a;
            }
            return kt5Var;
        }
        return (kt5) invokeV.objValue;
    }
}
