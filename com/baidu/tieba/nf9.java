package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class nf9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mf9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized mf9 a() {
        InterceptResult invokeV;
        mf9 mf9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (nf9.class) {
                if (a == null) {
                    a = new mf9();
                }
                mf9Var = a;
            }
            return mf9Var;
        }
        return (mf9) invokeV.objValue;
    }
}
