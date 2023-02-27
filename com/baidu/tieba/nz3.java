package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class nz3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mz3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized mz3 a() {
        InterceptResult invokeV;
        mz3 mz3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (nz3.class) {
                if (a == null) {
                    a = new mz3();
                }
                mz3Var = a;
            }
            return mz3Var;
        }
        return (mz3) invokeV.objValue;
    }
}
