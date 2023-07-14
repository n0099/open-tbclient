package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class mb6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile lb6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized lb6 a() {
        InterceptResult invokeV;
        lb6 lb6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (mb6.class) {
                if (a == null) {
                    a = new lb6();
                }
                lb6Var = a;
            }
            return lb6Var;
        }
        return (lb6) invokeV.objValue;
    }
}
