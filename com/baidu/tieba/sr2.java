package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class sr2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rr2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized rr2 a() {
        InterceptResult invokeV;
        rr2 rr2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (sr2.class) {
                if (a == null) {
                    a = new rr2();
                }
                rr2Var = a;
            }
            return rr2Var;
        }
        return (rr2) invokeV.objValue;
    }
}
