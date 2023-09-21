package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class oy3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ny3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ny3 a() {
        InterceptResult invokeV;
        ny3 ny3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (oy3.class) {
                if (a == null) {
                    a = new ny3();
                }
                ny3Var = a;
            }
            return ny3Var;
        }
        return (ny3) invokeV.objValue;
    }
}
