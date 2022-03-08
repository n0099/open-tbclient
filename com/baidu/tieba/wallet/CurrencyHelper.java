package com.baidu.tieba.wallet;

import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class CurrencyHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CurrencyHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String getFormatOverBaiwanNum(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            if (CurrencySwitchUtil.isYyIsConvert(i2)) {
                return StringHelper.formatYdouOverBaiwanNum(switchYFenToYBean(j2));
            }
            return StringHelper.formatOverBaiwanNum(j2);
        }
        return (String) invokeCommon.objValue;
    }

    public static float switchYFenToYBean(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65539, null, j2)) == null) ? ((float) j2) / 100.0f : invokeJ.floatValue;
    }

    public static String getFormatOverBaiwanNum(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j2)) == null) {
            if (CurrencySwitchUtil.isYyIsConvert()) {
                return StringHelper.formatYdouOverBaiwanNum(switchYFenToYBean(j2));
            }
            return StringHelper.formatOverBaiwanNum(j2);
        }
        return (String) invokeJ.objValue;
    }
}
