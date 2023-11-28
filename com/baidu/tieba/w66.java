package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class w66 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile v66 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized v66 a() {
        InterceptResult invokeV;
        v66 v66Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (w66.class) {
                if (a == null) {
                    a = new v66();
                }
                v66Var = a;
            }
            return v66Var;
        }
        return (v66) invokeV.objValue;
    }
}
