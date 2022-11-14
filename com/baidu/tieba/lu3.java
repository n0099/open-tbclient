package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class lu3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ku3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ku3 a() {
        InterceptResult invokeV;
        ku3 ku3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (lu3.class) {
                if (a == null) {
                    a = new ku3();
                }
                ku3Var = a;
            }
            return ku3Var;
        }
        return (ku3) invokeV.objValue;
    }
}
