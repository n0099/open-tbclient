package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class t46 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile s46 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized s46 a() {
        InterceptResult invokeV;
        s46 s46Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (t46.class) {
                if (a == null) {
                    a = new s46();
                }
                s46Var = a;
            }
            return s46Var;
        }
        return (s46) invokeV.objValue;
    }
}
