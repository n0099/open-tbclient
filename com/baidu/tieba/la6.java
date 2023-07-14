package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class la6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ka6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ka6 a() {
        InterceptResult invokeV;
        ka6 ka6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (la6.class) {
                if (a == null) {
                    a = new ka6();
                }
                ka6Var = a;
            }
            return ka6Var;
        }
        return (ka6) invokeV.objValue;
    }
}
