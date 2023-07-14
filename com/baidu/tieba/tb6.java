package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class tb6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile sb6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized sb6 a() {
        InterceptResult invokeV;
        sb6 sb6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (tb6.class) {
                if (a == null) {
                    a = new sb6();
                }
                sb6Var = a;
            }
            return sb6Var;
        }
        return (sb6) invokeV.objValue;
    }
}
