package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class iq9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hq9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized hq9 a() {
        InterceptResult invokeV;
        hq9 hq9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (iq9.class) {
                if (a == null) {
                    a = new hq9();
                }
                hq9Var = a;
            }
            return hq9Var;
        }
        return (hq9) invokeV.objValue;
    }
}
