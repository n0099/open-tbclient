package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class oy2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ny2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ny2 a() {
        InterceptResult invokeV;
        ny2 ny2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (oy2.class) {
                if (a == null) {
                    a = new ny2();
                }
                ny2Var = a;
            }
            return ny2Var;
        }
        return (ny2) invokeV.objValue;
    }
}
