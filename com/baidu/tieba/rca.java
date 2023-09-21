package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class rca {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qca a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qca a() {
        InterceptResult invokeV;
        qca qcaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rca.class) {
                if (a == null) {
                    a = new qca();
                }
                qcaVar = a;
            }
            return qcaVar;
        }
        return (qca) invokeV.objValue;
    }
}
