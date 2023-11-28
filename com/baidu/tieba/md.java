package com.baidu.tieba;

import android.content.Context;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class md {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (!BdUtilHelper.deviceDataInited) {
                BdUtilHelper.initDeviceData(context);
            }
            return BdUtilHelper.displayMetricsWidthPixels;
        }
        return invokeL.intValue;
    }
}
