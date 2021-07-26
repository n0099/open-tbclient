package com.baidu.wallet.statistics.api;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.d.a.a.b.d;
import java.util.Collection;
import java.util.Map;
/* loaded from: classes5.dex */
public class SensorStatisticApi extends StatisticDecorate {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static SensorStatisticApi f27476a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1085915489, "Lcom/baidu/wallet/statistics/api/SensorStatisticApi$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1085915489, "Lcom/baidu/wallet/statistics/api/SensorStatisticApi$a;");
                    return;
                }
            }
            f27476a = new SensorStatisticApi();
        }
    }

    public SensorStatisticApi() {
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

    public static SensorStatisticApi getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a.f27476a : (SensorStatisticApi) invokeV.objValue;
    }

    @Override // com.baidu.wallet.statistics.api.StatisticDecorate, com.baidu.wallet.statistics.api.IStatistic
    public void onEvent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            super.onEvent(str);
            d.d.a.a.a.onEvent(str);
        }
    }

    @Override // com.baidu.wallet.statistics.api.StatisticDecorate, com.baidu.wallet.statistics.api.IStatistic
    public void onEventEnd(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2) == null) {
            super.onEventEnd(str, i2);
            d.d.a.a.a.i(str, i2);
        }
    }

    @Override // com.baidu.wallet.statistics.api.StatisticDecorate, com.baidu.wallet.statistics.api.IStatistic
    public void onEventEndWithValue(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048580, this, str, i2, str2) == null) {
            super.onEventEndWithValue(str, i2, str2);
            d.d.a.a.a.k(str, i2, str2);
        }
    }

    @Override // com.baidu.wallet.statistics.api.StatisticDecorate, com.baidu.wallet.statistics.api.IStatistic
    public void onEventEndWithValues(String str, int i2, Collection<String> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048582, this, str, i2, collection) == null) {
            super.onEventEndWithValues(str, i2, collection);
            d.d.a.a.a.m(str, i2, collection);
        }
    }

    @Override // com.baidu.wallet.statistics.api.StatisticDecorate, com.baidu.wallet.statistics.api.IStatistic
    public void onEventStart(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            super.onEventStart(str);
            d.d.a.a.a.q(str);
        }
    }

    @Override // com.baidu.wallet.statistics.api.StatisticDecorate, com.baidu.wallet.statistics.api.IStatistic
    public void onEventWithValue(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, str2) == null) {
            super.onEventWithValue(str, str2);
            d.d.a.a.a.r(str, str2);
        }
    }

    @Override // com.baidu.wallet.statistics.api.StatisticDecorate, com.baidu.wallet.statistics.api.IStatistic
    public void onEventWithValues(String str, Collection<String> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, collection) == null) {
            super.onEventWithValues(str, collection);
            d.d.a.a.a.t(str, collection);
        }
    }

    @Override // com.baidu.wallet.statistics.api.StatisticDecorate, com.baidu.wallet.statistics.api.IStatistic
    public void triggerSending() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.triggerSending();
            d.h().i("normal_log");
        }
    }

    @Override // com.baidu.wallet.statistics.api.StatisticDecorate, com.baidu.wallet.statistics.api.IStatistic
    public void onEvent(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            super.onEvent(str, str2);
            d.d.a.a.a.h(str, str2);
        }
    }

    @Override // com.baidu.wallet.statistics.api.StatisticDecorate, com.baidu.wallet.statistics.api.IStatistic
    public void onEventEnd(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, str, i2, str2) == null) {
            super.onEventEnd(str, i2, str2);
            d.d.a.a.a.j(str, i2, str2);
        }
    }

    @Override // com.baidu.wallet.statistics.api.StatisticDecorate, com.baidu.wallet.statistics.api.IStatistic
    public void onEventEndWithValue(String str, int i2, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048581, this, str, i2, str2, str3) == null) {
            super.onEventEndWithValue(str, i2, str2, str3);
            d.d.a.a.a.l(str, i2, str2, str3);
        }
    }

    @Override // com.baidu.wallet.statistics.api.StatisticDecorate, com.baidu.wallet.statistics.api.IStatistic
    public void onEventEndWithValues(String str, int i2, Collection<String> collection, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, i2, collection, map) == null) {
            super.onEventEndWithValues(str, i2, collection, map);
            d.d.a.a.a.o(str, i2, collection, map);
        }
    }

    @Override // com.baidu.wallet.statistics.api.StatisticDecorate, com.baidu.wallet.statistics.api.IStatistic
    public void onEventWithValue(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, str, str2, str3) == null) {
            super.onEventWithValue(str, str2, str3);
            d.d.a.a.a.s(str, str2, str3);
        }
    }

    @Override // com.baidu.wallet.statistics.api.StatisticDecorate, com.baidu.wallet.statistics.api.IStatistic
    public void onEventWithValues(String str, Collection<String> collection, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, str, collection, map) == null) {
            super.onEventWithValues(str, collection, map);
            d.d.a.a.a.v(str, collection, map);
        }
    }

    @Override // com.baidu.wallet.statistics.api.StatisticDecorate, com.baidu.wallet.statistics.api.IStatistic
    public void onEventEndWithValues(String str, int i2, Collection<String> collection, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048583, this, str, i2, collection, str2) == null) {
            super.onEventEndWithValues(str, i2, collection, str2);
            d.d.a.a.a.n(str, i2, collection, str2);
        }
    }

    @Override // com.baidu.wallet.statistics.api.StatisticDecorate, com.baidu.wallet.statistics.api.IStatistic
    public void onEventWithValues(String str, Collection<String> collection, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, str, collection, str2) == null) {
            super.onEventWithValues(str, collection, str2);
            d.d.a.a.a.u(str, collection, str2);
        }
    }

    @Override // com.baidu.wallet.statistics.api.StatisticDecorate, com.baidu.wallet.statistics.api.IStatistic
    public void onEventEndWithValues(String str, int i2, Collection<String> collection, Map<String, Object> map, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, Integer.valueOf(i2), collection, map, str2}) == null) {
            super.onEventEndWithValues(str, i2, collection, map, str2);
            d.d.a.a.a.p(str, i2, collection, map, str2);
        }
    }

    @Override // com.baidu.wallet.statistics.api.StatisticDecorate, com.baidu.wallet.statistics.api.IStatistic
    public void onEventWithValues(String str, Collection<String> collection, Map<String, Object> map, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048592, this, str, collection, map, str2) == null) {
            super.onEventWithValues(str, collection, map, str2);
            d.d.a.a.a.w(str, collection, map, str2);
        }
    }
}
