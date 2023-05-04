package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class w34 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile v34 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized v34 a() {
        InterceptResult invokeV;
        v34 v34Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (w34.class) {
                if (a == null) {
                    a = new v34();
                }
                v34Var = a;
            }
            return v34Var;
        }
        return (v34) invokeV.objValue;
    }
}
