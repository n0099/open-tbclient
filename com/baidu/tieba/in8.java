package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class in8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hn8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized hn8 a() {
        InterceptResult invokeV;
        hn8 hn8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (in8.class) {
                if (a == null) {
                    a = new hn8();
                }
                hn8Var = a;
            }
            return hn8Var;
        }
        return (hn8) invokeV.objValue;
    }
}
