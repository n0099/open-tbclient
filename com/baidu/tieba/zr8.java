package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class zr8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yr8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized yr8 a() {
        InterceptResult invokeV;
        yr8 yr8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (zr8.class) {
                if (a == null) {
                    a = new yr8();
                }
                yr8Var = a;
            }
            return yr8Var;
        }
        return (yr8) invokeV.objValue;
    }
}
