package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class wi9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vi9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized vi9 a() {
        InterceptResult invokeV;
        vi9 vi9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (wi9.class) {
                if (a == null) {
                    a = new vi9();
                }
                vi9Var = a;
            }
            return vi9Var;
        }
        return (vi9) invokeV.objValue;
    }
}
