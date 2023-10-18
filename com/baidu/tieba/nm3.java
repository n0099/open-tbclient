package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class nm3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mm3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized mm3 a() {
        InterceptResult invokeV;
        mm3 mm3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (nm3.class) {
                if (a == null) {
                    a = new mm3();
                }
                mm3Var = a;
            }
            return mm3Var;
        }
        return (mm3) invokeV.objValue;
    }
}
