package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class xs3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ws3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ws3 a() {
        InterceptResult invokeV;
        ws3 ws3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xs3.class) {
                if (a == null) {
                    a = new ws3();
                }
                ws3Var = a;
            }
            return ws3Var;
        }
        return (ws3) invokeV.objValue;
    }
}
