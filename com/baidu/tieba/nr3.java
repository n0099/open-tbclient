package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class nr3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mr3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized mr3 a() {
        InterceptResult invokeV;
        mr3 mr3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (nr3.class) {
                if (a == null) {
                    a = new mr3();
                }
                mr3Var = a;
            }
            return mr3Var;
        }
        return (mr3) invokeV.objValue;
    }
}
