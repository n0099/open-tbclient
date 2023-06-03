package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class je4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ie4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ie4 a() {
        InterceptResult invokeV;
        ie4 ie4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (je4.class) {
                if (a == null) {
                    a = new ie4();
                }
                ie4Var = a;
            }
            return ie4Var;
        }
        return (ie4) invokeV.objValue;
    }
}
