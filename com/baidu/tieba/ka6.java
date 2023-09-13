package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ka6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ja6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ja6 a() {
        InterceptResult invokeV;
        ja6 ja6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ka6.class) {
                if (a == null) {
                    a = new ja6();
                }
                ja6Var = a;
            }
            return ja6Var;
        }
        return (ja6) invokeV.objValue;
    }
}
