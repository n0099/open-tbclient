package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class nx0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mx0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized mx0 a() {
        InterceptResult invokeV;
        mx0 mx0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (nx0.class) {
                if (a == null) {
                    a = new mx0();
                }
                mx0Var = a;
            }
            return mx0Var;
        }
        return (mx0) invokeV.objValue;
    }
}
