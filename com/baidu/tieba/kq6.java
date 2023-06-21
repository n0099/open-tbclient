package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class kq6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jq6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized jq6 a() {
        InterceptResult invokeV;
        jq6 jq6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (kq6.class) {
                if (a == null) {
                    a = new jq6();
                }
                jq6Var = a;
            }
            return jq6Var;
        }
        return (jq6) invokeV.objValue;
    }
}
