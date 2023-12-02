package com.baidu.tieba;

import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final class io7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                return 1;
            }
            if (BdNetTypeUtil.isWifiNet()) {
                return 2;
            }
            if (BdNetTypeUtil.isMobileNet()) {
                return 3;
            }
            return 0;
        }
        return invokeV.intValue;
    }
}
