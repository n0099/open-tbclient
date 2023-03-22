package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ro3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qo3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qo3 a() {
        InterceptResult invokeV;
        qo3 qo3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ro3.class) {
                if (a == null) {
                    a = new qo3();
                }
                qo3Var = a;
            }
            return qo3Var;
        }
        return (qo3) invokeV.objValue;
    }
}
