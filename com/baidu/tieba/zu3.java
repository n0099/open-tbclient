package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class zu3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yu3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized yu3 a() {
        InterceptResult invokeV;
        yu3 yu3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (zu3.class) {
                if (a == null) {
                    a = new yu3();
                }
                yu3Var = a;
            }
            return yu3Var;
        }
        return (yu3) invokeV.objValue;
    }
}
