package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class jw0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile iw0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized iw0 a() {
        InterceptResult invokeV;
        iw0 iw0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (jw0.class) {
                if (a == null) {
                    a = new iw0();
                }
                iw0Var = a;
            }
            return iw0Var;
        }
        return (iw0) invokeV.objValue;
    }
}
