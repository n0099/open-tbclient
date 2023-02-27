package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class w26 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile v26 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized v26 a() {
        InterceptResult invokeV;
        v26 v26Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (w26.class) {
                if (a == null) {
                    a = new v26();
                }
                v26Var = a;
            }
            return v26Var;
        }
        return (v26) invokeV.objValue;
    }
}
