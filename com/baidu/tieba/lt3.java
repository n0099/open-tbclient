package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class lt3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile kt3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized kt3 a() {
        InterceptResult invokeV;
        kt3 kt3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (lt3.class) {
                if (a == null) {
                    a = new kt3();
                }
                kt3Var = a;
            }
            return kt3Var;
        }
        return (kt3) invokeV.objValue;
    }
}
