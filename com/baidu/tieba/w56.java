package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class w56 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile v56 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized v56 a() {
        InterceptResult invokeV;
        v56 v56Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (w56.class) {
                if (a == null) {
                    a = new v56();
                }
                v56Var = a;
            }
            return v56Var;
        }
        return (v56) invokeV.objValue;
    }
}
