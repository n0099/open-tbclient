package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class nf4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mf4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized mf4 a() {
        InterceptResult invokeV;
        mf4 mf4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (nf4.class) {
                if (a == null) {
                    a = new mf4();
                }
                mf4Var = a;
            }
            return mf4Var;
        }
        return (mf4) invokeV.objValue;
    }
}
