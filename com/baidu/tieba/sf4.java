package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class sf4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rf4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized rf4 a() {
        InterceptResult invokeV;
        rf4 rf4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (sf4.class) {
                if (a == null) {
                    a = new rf4();
                }
                rf4Var = a;
            }
            return rf4Var;
        }
        return (rf4) invokeV.objValue;
    }
}
