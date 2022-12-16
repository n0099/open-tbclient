package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class mv5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile lv5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized lv5 a() {
        InterceptResult invokeV;
        lv5 lv5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (mv5.class) {
                if (a == null) {
                    a = new lv5();
                }
                lv5Var = a;
            }
            return lv5Var;
        }
        return (lv5) invokeV.objValue;
    }
}
