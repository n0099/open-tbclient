package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class rv3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qv3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qv3 a() {
        InterceptResult invokeV;
        qv3 qv3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rv3.class) {
                if (a == null) {
                    a = new qv3();
                }
                qv3Var = a;
            }
            return qv3Var;
        }
        return (qv3) invokeV.objValue;
    }
}
