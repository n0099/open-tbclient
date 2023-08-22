package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class m96 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile l96 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized l96 a() {
        InterceptResult invokeV;
        l96 l96Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (m96.class) {
                if (a == null) {
                    a = new l96();
                }
                l96Var = a;
            }
            return l96Var;
        }
        return (l96) invokeV.objValue;
    }
}
