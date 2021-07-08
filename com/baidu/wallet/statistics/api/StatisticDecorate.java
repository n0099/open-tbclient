package com.baidu.wallet.statistics.api;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.Map;
/* loaded from: classes5.dex */
public class StatisticDecorate implements IStatistic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public IStatistic f27319a;

    public StatisticDecorate() {
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
        IStatistic iStatistic;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (iStatistic = this.f27319a) == null) {
            return;
        }
        iStatistic.onEvent(str);
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventEnd(String str, int i2) {
        IStatistic iStatistic;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2) == null) || (iStatistic = this.f27319a) == null) {
            return;
        }
        iStatistic.onEventEnd(str, i2);
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventEndWithValue(String str, int i2, String str2) {
        IStatistic iStatistic;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048580, this, str, i2, str2) == null) || (iStatistic = this.f27319a) == null) {
            return;
        }
        iStatistic.onEventEndWithValue(str, i2, str2);
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventEndWithValues(String str, int i2, Collection<String> collection) {
        IStatistic iStatistic;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048582, this, str, i2, collection) == null) || (iStatistic = this.f27319a) == null) {
            return;
        }
        iStatistic.onEventEndWithValues(str, i2, collection);
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventStart(String str) {
        IStatistic iStatistic;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || (iStatistic = this.f27319a) == null) {
            return;
        }
        iStatistic.onEventStart(str);
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventWithValue(String str, String str2) {
        IStatistic iStatistic;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, str, str2) == null) || (iStatistic = this.f27319a) == null) {
            return;
        }
        iStatistic.onEventWithValue(str, str2);
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventWithValues(String str, Collection<String> collection) {
        IStatistic iStatistic;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, str, collection) == null) || (iStatistic = this.f27319a) == null) {
            return;
        }
        iStatistic.onEventWithValues(str, collection);
    }

    public void setStatistic(IStatistic iStatistic) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, iStatistic) == null) {
            this.f27319a = iStatistic;
        }
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void triggerSending() {
        IStatistic iStatistic;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (iStatistic = this.f27319a) == null) {
            return;
        }
        iStatistic.triggerSending();
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEvent(String str, String str2) {
        IStatistic iStatistic;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || (iStatistic = this.f27319a) == null) {
            return;
        }
        iStatistic.onEvent(str, str2);
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventEnd(String str, int i2, String str2) {
        IStatistic iStatistic;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048579, this, str, i2, str2) == null) || (iStatistic = this.f27319a) == null) {
            return;
        }
        iStatistic.onEventEnd(str, i2, str2);
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventEndWithValue(String str, int i2, String str2, String str3) {
        IStatistic iStatistic;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(1048581, this, str, i2, str2, str3) == null) || (iStatistic = this.f27319a) == null) {
            return;
        }
        iStatistic.onEventEndWithValue(str, i2, str2, str3);
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventEndWithValues(String str, int i2, Collection<String> collection, Map<String, Object> map) {
        IStatistic iStatistic;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, i2, collection, map) == null) || (iStatistic = this.f27319a) == null) {
            return;
        }
        iStatistic.onEventEndWithValues(str, i2, collection, map);
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventWithValue(String str, String str2, String str3) {
        IStatistic iStatistic;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048588, this, str, str2, str3) == null) || (iStatistic = this.f27319a) == null) {
            return;
        }
        iStatistic.onEventWithValue(str, str2, str3);
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventWithValues(String str, Collection<String> collection, Map<String, Object> map) {
        IStatistic iStatistic;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048591, this, str, collection, map) == null) || (iStatistic = this.f27319a) == null) {
            return;
        }
        iStatistic.onEventWithValues(str, collection, map);
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventEndWithValues(String str, int i2, Collection<String> collection, String str2) {
        IStatistic iStatistic;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(1048583, this, str, i2, collection, str2) == null) || (iStatistic = this.f27319a) == null) {
            return;
        }
        iStatistic.onEventEndWithValues(str, i2, collection, str2);
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventWithValues(String str, Collection<String> collection, String str2) {
        IStatistic iStatistic;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048590, this, str, collection, str2) == null) || (iStatistic = this.f27319a) == null) {
            return;
        }
        iStatistic.onEventWithValues(str, collection, str2);
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventEndWithValues(String str, int i2, Collection<String> collection, Map<String, Object> map, String str2) {
        IStatistic iStatistic;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, Integer.valueOf(i2), collection, map, str2}) == null) || (iStatistic = this.f27319a) == null) {
            return;
        }
        iStatistic.onEventEndWithValues(str, i2, collection, map, str2);
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventWithValues(String str, Collection<String> collection, Map<String, Object> map, String str2) {
        IStatistic iStatistic;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048592, this, str, collection, map, str2) == null) || (iStatistic = this.f27319a) == null) {
            return;
        }
        iStatistic.onEventWithValues(str, collection, map, str2);
    }
}
