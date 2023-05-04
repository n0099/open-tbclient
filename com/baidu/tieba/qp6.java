package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class qp6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pp6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized pp6 a() {
        InterceptResult invokeV;
        pp6 pp6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (qp6.class) {
                if (a == null) {
                    a = new pp6();
                }
                pp6Var = a;
            }
            return pp6Var;
        }
        return (pp6) invokeV.objValue;
    }
}
