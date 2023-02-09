package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class up9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile tp9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized tp9 a() {
        InterceptResult invokeV;
        tp9 tp9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (up9.class) {
                if (a == null) {
                    a = new tp9();
                }
                tp9Var = a;
            }
            return tp9Var;
        }
        return (tp9) invokeV.objValue;
    }
}
