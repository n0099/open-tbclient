package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class jw3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile iw3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized iw3 a() {
        InterceptResult invokeV;
        iw3 iw3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (jw3.class) {
                if (a == null) {
                    a = new iw3();
                }
                iw3Var = a;
            }
            return iw3Var;
        }
        return (iw3) invokeV.objValue;
    }
}
