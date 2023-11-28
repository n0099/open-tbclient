package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class roa {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qoa a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qoa a() {
        InterceptResult invokeV;
        qoa qoaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (roa.class) {
                if (a == null) {
                    a = new qoa();
                }
                qoaVar = a;
            }
            return qoaVar;
        }
        return (qoa) invokeV.objValue;
    }
}
