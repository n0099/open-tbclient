package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class nw0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mw0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized mw0 a() {
        InterceptResult invokeV;
        mw0 mw0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (nw0.class) {
                if (a == null) {
                    a = new mw0();
                }
                mw0Var = a;
            }
            return mw0Var;
        }
        return (mw0) invokeV.objValue;
    }
}
