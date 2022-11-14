package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class io5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            long m = py4.k().m("key_youngster_use_time_dialog_show_time", 0L);
            if (m > System.currentTimeMillis() || System.currentTimeMillis() - m <= 600000) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
