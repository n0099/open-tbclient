package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class m80 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile l80 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized l80 a() {
        InterceptResult invokeV;
        l80 l80Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (m80.class) {
                if (a == null) {
                    a = new l80();
                }
                l80Var = a;
            }
            return l80Var;
        }
        return (l80) invokeV.objValue;
    }
}
