package com.baidu.wallet.statistics.api;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.statistics.LogSender;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.Map;
/* loaded from: classes6.dex */
public class PMStatisticApi implements IStatistic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PMStatisticApi() {
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

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEvent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            PayStatisticsUtil.onEvent(str);
        }
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventEnd(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2) == null) {
            PayStatisticsUtil.onEventEnd(str, i2);
        }
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventEndWithValue(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048580, this, str, i2, str2) == null) {
            PayStatisticsUtil.onEventEndWithValue(str, i2, str2);
        }
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventEndWithValues(String str, int i2, Collection<String> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048582, this, str, i2, collection) == null) {
            PayStatisticsUtil.onEventEndWithValues(str, i2, collection);
        }
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventEndWithValues(String str, int i2, Collection<String> collection, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, i2, collection, map) == null) {
        }
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventEndWithValues(String str, int i2, Collection<String> collection, Map<String, Object> map, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, Integer.valueOf(i2), collection, map, str2}) == null) {
        }
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventStart(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            PayStatisticsUtil.onEventStart(str);
        }
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventWithValue(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, str2) == null) {
            PayStatisticsUtil.onEventWithValue(str, str2);
        }
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventWithValues(String str, Collection<String> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, collection) == null) {
            PayStatisticsUtil.onEventWithValues(str, collection);
        }
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventWithValues(String str, Collection<String> collection, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, str, collection, map) == null) {
        }
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventWithValues(String str, Collection<String> collection, Map<String, Object> map, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048592, this, str, collection, map, str2) == null) {
        }
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void triggerSending() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            LogSender.getInstance().triggerSending("normal_log");
        }
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEvent(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            PayStatisticsUtil.onEvent(str, str2);
        }
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventEnd(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, str, i2, str2) == null) {
            PayStatisticsUtil.onEventEnd(str, i2, str2);
        }
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventEndWithValue(String str, int i2, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048581, this, str, i2, str2, str3) == null) {
            PayStatisticsUtil.onEventEndWithValue(str, i2, str2, str3);
        }
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventEndWithValues(String str, int i2, Collection<String> collection, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048583, this, str, i2, collection, str2) == null) {
            PayStatisticsUtil.onEventEndWithValues(str, i2, collection, str2);
        }
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventWithValue(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, str, str2, str3) == null) {
            PayStatisticsUtil.onEventWithValue(str, str2, str3);
        }
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventWithValues(String str, Collection<String> collection, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, str, collection, str2) == null) {
            PayStatisticsUtil.onEventWithValues(str, collection, str2);
        }
    }
}
