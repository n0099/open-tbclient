package com.baidu.wallet.analytics;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.wallet.api.WalletApiExt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
/* loaded from: classes5.dex */
public class Tracker {
    public static void send(@NonNull String str, @NonNull Collection<String> collection, @NonNull Context context) {
        send(str, collection, context, "GET");
    }

    public static void sendPerformanceInfoToSensors(@NonNull String str, @NonNull Map<String, String> map, @NonNull Context context) {
        if (WalletApiExt.getInstance().getSensorsAdapter() != null) {
            WalletApiExt.getInstance().getSensorsAdapter().sendPerformanceInfo(map);
        }
        PayStatisticsUtil.onEventWithValues(str, map.values());
    }

    public static void send(@NonNull String str, @NonNull Collection<String> collection, @NonNull Context context, String str2) {
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

    public static void send(@NonNull String str, @NonNull Map<String, String> map, @NonNull Context context) {
        send(str, map, context, "GET");
    }

    public static void send(@NonNull String str, @NonNull Map<String, String> map, @NonNull Context context, @NonNull String str2) {
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
