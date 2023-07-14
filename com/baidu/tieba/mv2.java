package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class mv2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile lv2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized lv2 a() {
        InterceptResult invokeV;
        lv2 lv2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (mv2.class) {
                if (a == null) {
                    a = new lv2();
                }
                lv2Var = a;
            }
            return lv2Var;
        }
        return (lv2) invokeV.objValue;
    }
}
