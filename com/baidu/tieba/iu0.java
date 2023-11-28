package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class iu0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hu0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized hu0 a() {
        InterceptResult invokeV;
        hu0 hu0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (iu0.class) {
                if (a == null) {
                    a = new hu0();
                }
                hu0Var = a;
            }
            return hu0Var;
        }
        return (hu0) invokeV.objValue;
    }
}
