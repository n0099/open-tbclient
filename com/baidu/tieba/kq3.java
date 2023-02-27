package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class kq3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jq3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized jq3 a() {
        InterceptResult invokeV;
        jq3 jq3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (kq3.class) {
                if (a == null) {
                    a = new jq3();
                }
                jq3Var = a;
            }
            return jq3Var;
        }
        return (jq3) invokeV.objValue;
    }
}
