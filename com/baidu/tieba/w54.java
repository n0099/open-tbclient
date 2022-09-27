package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class w54 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile v54 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized v54 a() {
        InterceptResult invokeV;
        v54 v54Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (w54.class) {
                if (a == null) {
                    a = new v54();
                }
                v54Var = a;
            }
            return v54Var;
        }
        return (v54) invokeV.objValue;
    }
}
