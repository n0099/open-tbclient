package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ru2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qu2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qu2 a() {
        InterceptResult invokeV;
        qu2 qu2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ru2.class) {
                if (a == null) {
                    a = new qu2();
                }
                qu2Var = a;
            }
            return qu2Var;
        }
        return (qu2) invokeV.objValue;
    }
}
