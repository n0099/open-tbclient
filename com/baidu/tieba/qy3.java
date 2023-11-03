package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class qy3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile py3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized py3 a() {
        InterceptResult invokeV;
        py3 py3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (qy3.class) {
                if (a == null) {
                    a = new py3();
                }
                py3Var = a;
            }
            return py3Var;
        }
        return (py3) invokeV.objValue;
    }
}
