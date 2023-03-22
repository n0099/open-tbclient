package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class w90 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile v90 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized v90 a() {
        InterceptResult invokeV;
        v90 v90Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (w90.class) {
                if (a == null) {
                    a = new v90();
                }
                v90Var = a;
            }
            return v90Var;
        }
        return (v90) invokeV.objValue;
    }
}
