package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class nw3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mw3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized mw3 a() {
        InterceptResult invokeV;
        mw3 mw3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (nw3.class) {
                if (a == null) {
                    a = new mw3();
                }
                mw3Var = a;
            }
            return mw3Var;
        }
        return (mw3) invokeV.objValue;
    }
}
