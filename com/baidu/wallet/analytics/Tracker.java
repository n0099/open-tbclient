package com.baidu.wallet.analytics;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.WalletApiExt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
/* loaded from: classes5.dex */
public class Tracker {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public Tracker() {
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

    public static void send(@NonNull String str, @NonNull Collection<String> collection, @NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, str, collection, context) == null) {
            send(str, collection, context, "GET");
        }
    }

    public static void sendPerformanceInfoToSensors(@NonNull String str, @NonNull Map<String, String> map, @NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, str, map, context) == null) {
            if (WalletApiExt.getInstance().getSensorsAdapter() != null) {
                WalletApiExt.getInstance().getSensorsAdapter().sendPerformanceInfo(map);
            }
            PayStatisticsUtil.onEventWithValues(str, map.values());
        }
    }

    public static void send(@NonNull String str, @NonNull Collection<String> collection, @NonNull Context context, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65538, null, str, collection, context, str2) == null) {
            ArrayList arrayList = new ArrayList(collection.size() + 2);
            arrayList.add(new RestNameValuePair("type", str));
            int i2 = 1;
            for (String str3 : collection) {
                arrayList.add(new RestNameValuePair("value" + i2, str3));
                i2++;
            }
            arrayList.add(new RestNameValuePair("netType", String.valueOf(NetworkUtils.getNetworkType(context))));
            new TraceBean(context).buildParams(arrayList, str2).execBean();
            PayStatisticsUtil.onEventWithValues(str, collection);
        }
    }

    public static void send(@NonNull String str, @NonNull Map<String, String> map, @NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, str, map, context) == null) {
            send(str, map, context, "GET");
        }
    }

    public static void send(@NonNull String str, @NonNull Map<String, String> map, @NonNull Context context, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, map, context, str2) == null) {
            ArrayList arrayList = new ArrayList(map.size() + 2);
            arrayList.add(new RestNameValuePair("type", str));
            for (Map.Entry<String, String> entry : map.entrySet()) {
                arrayList.add(new RestNameValuePair(entry.getKey(), entry.getValue()));
            }
            arrayList.add(new RestNameValuePair("netType", String.valueOf(NetworkUtils.getNetworkType(context))));
            new TraceBean(context).buildParams(arrayList, str2).execBean();
            PayStatisticsUtil.onEventWithValues(str, map.values());
        }
    }
}
