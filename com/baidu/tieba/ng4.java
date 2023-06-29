package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ng4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mg4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized mg4 a() {
        InterceptResult invokeV;
        mg4 mg4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ng4.class) {
                if (a == null) {
                    a = new mg4();
                }
                mg4Var = a;
            }
            return mg4Var;
        }
        return (mg4) invokeV.objValue;
    }
}
