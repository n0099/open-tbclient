package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class od4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile nd4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized nd4 a() {
        InterceptResult invokeV;
        nd4 nd4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (od4.class) {
                if (a == null) {
                    a = new nd4();
                }
                nd4Var = a;
            }
            return nd4Var;
        }
        return (nd4) invokeV.objValue;
    }
}
