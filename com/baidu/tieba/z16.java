package com.baidu.tieba;

import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class z16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            long j = SharedPrefHelper.getInstance().getLong("key_youngster_use_time_dialog_show_time", 0L);
            if (j > System.currentTimeMillis() || System.currentTimeMillis() - j <= 600000) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
