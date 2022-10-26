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

    public static float switchYFenToYBean(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65539, null, j)) == null) ? ((float) j) / 100.0f : invokeJ.floatValue;
    }

    public CurrencyHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String getFormatOverBaiwanNum(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            if (CurrencySwitchUtil.isYyIsConvert(i)) {
                return StringHelper.formatYdouOverBaiwanNum(switchYFenToYBean(j));
            }
            return StringHelper.formatOverBaiwanNum(j);
        }
        return (String) invokeCommon.objValue;
    }

    public static String getFormatOverBaiwanNum(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j)) == null) {
            if (CurrencySwitchUtil.isYyIsConvert()) {
                return StringHelper.formatYdouOverBaiwanNum(switchYFenToYBean(j));
            }
            return StringHelper.formatOverBaiwanNum(j);
        }
        return (String) invokeJ.objValue;
    }
}
