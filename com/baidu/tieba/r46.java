package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class r46 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile q46 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized q46 a() {
        InterceptResult invokeV;
        q46 q46Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (r46.class) {
                if (a == null) {
                    a = new q46();
                }
                q46Var = a;
            }
            return q46Var;
        }
        return (q46) invokeV.objValue;
    }
}
