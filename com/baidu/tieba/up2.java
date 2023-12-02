package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class up2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile tp2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized tp2 a() {
        InterceptResult invokeV;
        tp2 tp2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (up2.class) {
                if (a == null) {
                    a = new tp2();
                }
                tp2Var = a;
            }
            return tp2Var;
        }
        return (tp2) invokeV.objValue;
    }
}
