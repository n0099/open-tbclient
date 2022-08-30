package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class jm3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile im3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized im3 a() {
        InterceptResult invokeV;
        im3 im3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (jm3.class) {
                if (a == null) {
                    a = new im3();
                }
                im3Var = a;
            }
            return im3Var;
        }
        return (im3) invokeV.objValue;
    }
}
