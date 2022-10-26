package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class la1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ka1 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ka1 a() {
        InterceptResult invokeV;
        ka1 ka1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (la1.class) {
                if (a == null) {
                    a = new ka1();
                }
                ka1Var = a;
            }
            return ka1Var;
        }
        return (ka1) invokeV.objValue;
    }
}
