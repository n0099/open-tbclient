package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ts9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ss9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ss9 a() {
        InterceptResult invokeV;
        ss9 ss9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ts9.class) {
                if (a == null) {
                    a = new ss9();
                }
                ss9Var = a;
            }
            return ss9Var;
        }
        return (ss9) invokeV.objValue;
    }
}
