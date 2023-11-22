package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class qp2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pp2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized pp2 a() {
        InterceptResult invokeV;
        pp2 pp2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (qp2.class) {
                if (a == null) {
                    a = new pp2();
                }
                pp2Var = a;
            }
            return pp2Var;
        }
        return (pp2) invokeV.objValue;
    }
}
