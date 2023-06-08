package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class nr9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mr9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized mr9 a() {
        InterceptResult invokeV;
        mr9 mr9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (nr9.class) {
                if (a == null) {
                    a = new mr9();
                }
                mr9Var = a;
            }
            return mr9Var;
        }
        return (mr9) invokeV.objValue;
    }
}
