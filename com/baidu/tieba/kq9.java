package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class kq9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jq9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized jq9 a() {
        InterceptResult invokeV;
        jq9 jq9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (kq9.class) {
                if (a == null) {
                    a = new jq9();
                }
                jq9Var = a;
            }
            return jq9Var;
        }
        return (jq9) invokeV.objValue;
    }
}
