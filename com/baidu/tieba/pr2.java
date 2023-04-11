package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class pr2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile or2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized or2 a() {
        InterceptResult invokeV;
        or2 or2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (pr2.class) {
                if (a == null) {
                    a = new or2();
                }
                or2Var = a;
            }
            return or2Var;
        }
        return (or2) invokeV.objValue;
    }
}
