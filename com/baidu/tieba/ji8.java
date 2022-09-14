package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class ji8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ii8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ii8 a() {
        InterceptResult invokeV;
        ii8 ii8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ji8.class) {
                if (a == null) {
                    a = new ii8();
                }
                ii8Var = a;
            }
            return ii8Var;
        }
        return (ii8) invokeV.objValue;
    }
}
