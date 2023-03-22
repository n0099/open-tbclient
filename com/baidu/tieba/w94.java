package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class w94 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile v94 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized v94 a() {
        InterceptResult invokeV;
        v94 v94Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (w94.class) {
                if (a == null) {
                    a = new v94();
                }
                v94Var = a;
            }
            return v94Var;
        }
        return (v94) invokeV.objValue;
    }
}
