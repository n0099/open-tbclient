package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class zq6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yq6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized yq6 a() {
        InterceptResult invokeV;
        yq6 yq6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (zq6.class) {
                if (a == null) {
                    a = new yq6();
                }
                yq6Var = a;
            }
            return yq6Var;
        }
        return (yq6) invokeV.objValue;
    }
}
