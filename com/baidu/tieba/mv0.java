package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class mv0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile lv0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized lv0 a() {
        InterceptResult invokeV;
        lv0 lv0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (mv0.class) {
                if (a == null) {
                    a = new lv0();
                }
                lv0Var = a;
            }
            return lv0Var;
        }
        return (lv0) invokeV.objValue;
    }
}
