package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class w99 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile v99 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized v99 a() {
        InterceptResult invokeV;
        v99 v99Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (w99.class) {
                if (a == null) {
                    a = new v99();
                }
                v99Var = a;
            }
            return v99Var;
        }
        return (v99) invokeV.objValue;
    }
}
