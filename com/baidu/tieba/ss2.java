package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ss2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rs2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized rs2 a() {
        InterceptResult invokeV;
        rs2 rs2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ss2.class) {
                if (a == null) {
                    a = new rs2();
                }
                rs2Var = a;
            }
            return rs2Var;
        }
        return (rs2) invokeV.objValue;
    }
}
