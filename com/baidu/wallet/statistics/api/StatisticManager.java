package com.baidu.wallet.statistics.api;

import androidx.core.view.InputDeviceCompat;
import com.baidu.apollon.NoProguard;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.Map;
/* loaded from: classes5.dex */
public class StatisticManager implements NoProguard {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static SensorStatisticApi f27478a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.wallet.statistics.api.StatisticManager$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static StatisticManager f27479a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(702534600, "Lcom/baidu/wallet/statistics/api/StatisticManager$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(702534600, "Lcom/baidu/wallet/statistics/api/StatisticManager$a;");
                    return;
                }
            }
            f27479a = new StatisticManager(null);
        }
    }

    public /* synthetic */ StatisticManager(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static StatisticManager a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f27479a : (StatisticManager) invokeV.objValue;
    }

    public static void onEvent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            a();
            SensorStatisticApi sensorStatisticApi = f27478a;
            if (sensorStatisticApi != null) {
                sensorStatisticApi.onEvent(str);
            }
        }
    }

    public static void onEventEnd(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, str, i2) == null) {
            a();
            SensorStatisticApi sensorStatisticApi = f27478a;
            if (sensorStatisticApi != null) {
                sensorStatisticApi.onEventEnd(str, i2);
            }
        }
    }

    public static void onEventEndWithValue(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65543, null, str, i2, str2) == null) {
            a();
            SensorStatisticApi sensorStatisticApi = f27478a;
            if (sensorStatisticApi != null) {
                sensorStatisticApi.onEventEndWithValue(str, i2, str2);
            }
        }
    }

    public static void onEventEndWithValues(String str, int i2, Collection<String> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65545, null, str, i2, collection) == null) {
            a();
            SensorStatisticApi sensorStatisticApi = f27478a;
            if (sensorStatisticApi != null) {
                sensorStatisticApi.onEventEndWithValues(str, i2, collection);
            }
        }
    }

    public static void onEventStart(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, str) == null) {
            a();
            SensorStatisticApi sensorStatisticApi = f27478a;
            if (sensorStatisticApi != null) {
                sensorStatisticApi.onEventStart(str);
            }
        }
    }

    public static void onEventWithValue(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, str, str2) == null) {
            a();
            SensorStatisticApi sensorStatisticApi = f27478a;
            if (sensorStatisticApi != null) {
                sensorStatisticApi.onEventWithValue(str, str2);
            }
        }
    }

    public static void onEventWithValues(String str, Collection<String> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, str, collection) == null) {
            a();
            SensorStatisticApi sensorStatisticApi = f27478a;
            if (sensorStatisticApi != null) {
                sensorStatisticApi.onEventWithValues(str, collection);
            }
        }
    }

    public static void triggerSending() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, null) == null) {
            a();
            SensorStatisticApi sensorStatisticApi = f27478a;
            if (sensorStatisticApi != null) {
                sensorStatisticApi.triggerSending();
            }
        }
    }

    public StatisticManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        f27478a = SensorStatisticApi.getInstance();
    }

    public static void onEvent(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) {
            a();
            SensorStatisticApi sensorStatisticApi = f27478a;
            if (sensorStatisticApi != null) {
                sensorStatisticApi.onEvent(str, str2);
            }
        }
    }

    public static void onEventEnd(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(AdIconUtil.BAIDU_LOGO_ID, null, str, i2, str2) == null) {
            a();
            SensorStatisticApi sensorStatisticApi = f27478a;
            if (sensorStatisticApi != null) {
                sensorStatisticApi.onEventEnd(str, i2, str2);
            }
        }
    }

    public static void onEventEndWithValue(String str, int i2, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65544, null, str, i2, str2, str3) == null) {
            a();
            SensorStatisticApi sensorStatisticApi = f27478a;
            if (sensorStatisticApi != null) {
                sensorStatisticApi.onEventEndWithValue(str, i2, str2, str3);
            }
        }
    }

    public static void onEventEndWithValues(String str, int i2, Collection<String> collection, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65547, null, str, i2, collection, map) == null) {
            a();
            SensorStatisticApi sensorStatisticApi = f27478a;
            if (sensorStatisticApi != null) {
                sensorStatisticApi.onEventEndWithValues(str, i2, collection, map);
            }
        }
    }

    public static void onEventWithValue(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65551, null, str, str2, str3) == null) {
            a();
            SensorStatisticApi sensorStatisticApi = f27478a;
            if (sensorStatisticApi != null) {
                sensorStatisticApi.onEventWithValue(str, str2, str3);
            }
        }
    }

    public static void onEventWithValues(String str, Collection<String> collection, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65554, null, str, collection, map) == null) {
            a();
            SensorStatisticApi sensorStatisticApi = f27478a;
            if (sensorStatisticApi != null) {
                sensorStatisticApi.onEventWithValues(str, collection, map);
            }
        }
    }

    public static void onEventEndWithValues(String str, int i2, Collection<String> collection, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65546, null, str, i2, collection, str2) == null) {
            a();
            SensorStatisticApi sensorStatisticApi = f27478a;
            if (sensorStatisticApi != null) {
                sensorStatisticApi.onEventEndWithValues(str, i2, collection, str2);
            }
        }
    }

    public static void onEventWithValues(String str, Collection<String> collection, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65553, null, str, collection, str2) == null) {
            a();
            SensorStatisticApi sensorStatisticApi = f27478a;
            if (sensorStatisticApi != null) {
                sensorStatisticApi.onEventWithValues(str, collection, str2);
            }
        }
    }

    public static void onEventEndWithValues(String str, int i2, Collection<String> collection, Map<String, Object> map, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{str, Integer.valueOf(i2), collection, map, str2}) == null) {
            a();
            SensorStatisticApi sensorStatisticApi = f27478a;
            if (sensorStatisticApi != null) {
                sensorStatisticApi.onEventEndWithValues(str, i2, collection, map, str2);
            }
        }
    }

    public static void onEventWithValues(String str, Collection<String> collection, Map<String, Object> map, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65555, null, str, collection, map, str2) == null) {
            a();
            SensorStatisticApi sensorStatisticApi = f27478a;
            if (sensorStatisticApi != null) {
                sensorStatisticApi.onEventWithValues(str, collection, map, str2);
            }
        }
    }
}
