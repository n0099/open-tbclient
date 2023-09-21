package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class oy6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ny6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ny6 a() {
        InterceptResult invokeV;
        ny6 ny6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (oy6.class) {
                if (a == null) {
                    a = new ny6();
                }
                ny6Var = a;
            }
            return ny6Var;
        }
        return (ny6) invokeV.objValue;
    }
}
