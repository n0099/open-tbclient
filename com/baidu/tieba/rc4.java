package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class rc4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qc4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qc4 a() {
        InterceptResult invokeV;
        qc4 qc4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rc4.class) {
                if (a == null) {
                    a = new qc4();
                }
                qc4Var = a;
            }
            return qc4Var;
        }
        return (qc4) invokeV.objValue;
    }
}
