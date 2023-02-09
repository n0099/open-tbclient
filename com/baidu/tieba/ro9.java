package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ro9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qo9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qo9 a() {
        InterceptResult invokeV;
        qo9 qo9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ro9.class) {
                if (a == null) {
                    a = new qo9();
                }
                qo9Var = a;
            }
            return qo9Var;
        }
        return (qo9) invokeV.objValue;
    }
}
