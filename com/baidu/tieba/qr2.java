package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class qr2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pr2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized pr2 a() {
        InterceptResult invokeV;
        pr2 pr2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (qr2.class) {
                if (a == null) {
                    a = new pr2();
                }
                pr2Var = a;
            }
            return pr2Var;
        }
        return (pr2) invokeV.objValue;
    }
}
