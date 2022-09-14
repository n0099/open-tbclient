package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class im2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hm2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized hm2 a() {
        InterceptResult invokeV;
        hm2 hm2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (im2.class) {
                if (a == null) {
                    a = new hm2();
                }
                hm2Var = a;
            }
            return hm2Var;
        }
        return (hm2) invokeV.objValue;
    }
}
