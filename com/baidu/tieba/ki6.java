package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ki6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ji6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ji6 a() {
        InterceptResult invokeV;
        ji6 ji6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ki6.class) {
                if (a == null) {
                    a = new ji6();
                }
                ji6Var = a;
            }
            return ji6Var;
        }
        return (ji6) invokeV.objValue;
    }
}
