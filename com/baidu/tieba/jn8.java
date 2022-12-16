package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class jn8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile in8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized in8 a() {
        InterceptResult invokeV;
        in8 in8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (jn8.class) {
                if (a == null) {
                    a = new in8();
                }
                in8Var = a;
            }
            return in8Var;
        }
        return (in8) invokeV.objValue;
    }
}
