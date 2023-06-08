package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class qo9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile po9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized po9 a() {
        InterceptResult invokeV;
        po9 po9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (qo9.class) {
                if (a == null) {
                    a = new po9();
                }
                po9Var = a;
            }
            return po9Var;
        }
        return (po9) invokeV.objValue;
    }
}
