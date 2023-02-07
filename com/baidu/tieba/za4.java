package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class za4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ya4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ya4 a() {
        InterceptResult invokeV;
        ya4 ya4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (za4.class) {
                if (a == null) {
                    a = new ya4();
                }
                ya4Var = a;
            }
            return ya4Var;
        }
        return (ya4) invokeV.objValue;
    }
}
