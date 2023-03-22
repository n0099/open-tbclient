package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class su3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ru3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ru3 a() {
        InterceptResult invokeV;
        ru3 ru3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (su3.class) {
                if (a == null) {
                    a = new ru3();
                }
                ru3Var = a;
            }
            return ru3Var;
        }
        return (ru3) invokeV.objValue;
    }
}
