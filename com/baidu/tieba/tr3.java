package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class tr3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile sr3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized sr3 a() {
        InterceptResult invokeV;
        sr3 sr3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (tr3.class) {
                if (a == null) {
                    a = new sr3();
                }
                sr3Var = a;
            }
            return sr3Var;
        }
        return (sr3) invokeV.objValue;
    }
}
