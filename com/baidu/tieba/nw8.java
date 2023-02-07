package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class nw8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mw8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized mw8 a() {
        InterceptResult invokeV;
        mw8 mw8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (nw8.class) {
                if (a == null) {
                    a = new mw8();
                }
                mw8Var = a;
            }
            return mw8Var;
        }
        return (mw8) invokeV.objValue;
    }
}
