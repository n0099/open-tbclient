package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class ra4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qa4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qa4 a() {
        InterceptResult invokeV;
        qa4 qa4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ra4.class) {
                if (a == null) {
                    a = new qa4();
                }
                qa4Var = a;
            }
            return qa4Var;
        }
        return (qa4) invokeV.objValue;
    }
}
