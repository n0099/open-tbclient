package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class ur3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile tr3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized tr3 a() {
        InterceptResult invokeV;
        tr3 tr3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ur3.class) {
                if (a == null) {
                    a = new tr3();
                }
                tr3Var = a;
            }
            return tr3Var;
        }
        return (tr3) invokeV.objValue;
    }
}
