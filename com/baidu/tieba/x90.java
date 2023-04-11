package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class x90 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile w90 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized w90 a() {
        InterceptResult invokeV;
        w90 w90Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (x90.class) {
                if (a == null) {
                    a = new w90();
                }
                w90Var = a;
            }
            return w90Var;
        }
        return (w90) invokeV.objValue;
    }
}
