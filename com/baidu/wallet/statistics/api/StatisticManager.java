package com.baidu.wallet.statistics.api;

import com.baidu.apollon.NoProguard;
import java.util.Collection;
import java.util.Map;
/* loaded from: classes5.dex */
public class StatisticManager implements NoProguard {

    /* renamed from: a  reason: collision with root package name */
    public static SensorStatisticApi f26501a;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static StatisticManager f26502a = new StatisticManager();
    }

    public static StatisticManager a() {
        return a.f26502a;
    }

    public static void onEvent(String str) {
        a();
        SensorStatisticApi sensorStatisticApi = f26501a;
        if (sensorStatisticApi != null) {
            sensorStatisticApi.onEvent(str);
        }
    }

    public static void onEventEnd(String str, int i) {
        a();
        SensorStatisticApi sensorStatisticApi = f26501a;
        if (sensorStatisticApi != null) {
            sensorStatisticApi.onEventEnd(str, i);
        }
    }

    public static void onEventEndWithValue(String str, int i, String str2) {
        a();
        SensorStatisticApi sensorStatisticApi = f26501a;
        if (sensorStatisticApi != null) {
            sensorStatisticApi.onEventEndWithValue(str, i, str2);
        }
    }

    public static void onEventEndWithValues(String str, int i, Collection<String> collection) {
        a();
        SensorStatisticApi sensorStatisticApi = f26501a;
        if (sensorStatisticApi != null) {
            sensorStatisticApi.onEventEndWithValues(str, i, collection);
        }
    }

    public static void onEventStart(String str) {
        a();
        SensorStatisticApi sensorStatisticApi = f26501a;
        if (sensorStatisticApi != null) {
            sensorStatisticApi.onEventStart(str);
        }
    }

    public static void onEventWithValue(String str, String str2) {
        a();
        SensorStatisticApi sensorStatisticApi = f26501a;
        if (sensorStatisticApi != null) {
            sensorStatisticApi.onEventWithValue(str, str2);
        }
    }

    public static void onEventWithValues(String str, Collection<String> collection) {
        a();
        SensorStatisticApi sensorStatisticApi = f26501a;
        if (sensorStatisticApi != null) {
            sensorStatisticApi.onEventWithValues(str, collection);
        }
    }

    public static void triggerSending() {
        a();
        SensorStatisticApi sensorStatisticApi = f26501a;
        if (sensorStatisticApi != null) {
            sensorStatisticApi.triggerSending();
        }
    }

    public StatisticManager() {
        f26501a = SensorStatisticApi.getInstance();
    }

    public static void onEvent(String str, String str2) {
        a();
        SensorStatisticApi sensorStatisticApi = f26501a;
        if (sensorStatisticApi != null) {
            sensorStatisticApi.onEvent(str, str2);
        }
    }

    public static void onEventEnd(String str, int i, String str2) {
        a();
        SensorStatisticApi sensorStatisticApi = f26501a;
        if (sensorStatisticApi != null) {
            sensorStatisticApi.onEventEnd(str, i, str2);
        }
    }

    public static void onEventEndWithValue(String str, int i, String str2, String str3) {
        a();
        SensorStatisticApi sensorStatisticApi = f26501a;
        if (sensorStatisticApi != null) {
            sensorStatisticApi.onEventEndWithValue(str, i, str2, str3);
        }
    }

    public static void onEventEndWithValues(String str, int i, Collection<String> collection, Map<String, Object> map) {
        a();
        SensorStatisticApi sensorStatisticApi = f26501a;
        if (sensorStatisticApi != null) {
            sensorStatisticApi.onEventEndWithValues(str, i, collection, map);
        }
    }

    public static void onEventWithValue(String str, String str2, String str3) {
        a();
        SensorStatisticApi sensorStatisticApi = f26501a;
        if (sensorStatisticApi != null) {
            sensorStatisticApi.onEventWithValue(str, str2, str3);
        }
    }

    public static void onEventWithValues(String str, Collection<String> collection, Map<String, Object> map) {
        a();
        SensorStatisticApi sensorStatisticApi = f26501a;
        if (sensorStatisticApi != null) {
            sensorStatisticApi.onEventWithValues(str, collection, map);
        }
    }

    public static void onEventEndWithValues(String str, int i, Collection<String> collection, String str2) {
        a();
        SensorStatisticApi sensorStatisticApi = f26501a;
        if (sensorStatisticApi != null) {
            sensorStatisticApi.onEventEndWithValues(str, i, collection, str2);
        }
    }

    public static void onEventWithValues(String str, Collection<String> collection, String str2) {
        a();
        SensorStatisticApi sensorStatisticApi = f26501a;
        if (sensorStatisticApi != null) {
            sensorStatisticApi.onEventWithValues(str, collection, str2);
        }
    }

    public static void onEventEndWithValues(String str, int i, Collection<String> collection, Map<String, Object> map, String str2) {
        a();
        SensorStatisticApi sensorStatisticApi = f26501a;
        if (sensorStatisticApi != null) {
            sensorStatisticApi.onEventEndWithValues(str, i, collection, map, str2);
        }
    }

    public static void onEventWithValues(String str, Collection<String> collection, Map<String, Object> map, String str2) {
        a();
        SensorStatisticApi sensorStatisticApi = f26501a;
        if (sensorStatisticApi != null) {
            sensorStatisticApi.onEventWithValues(str, collection, map, str2);
        }
    }
}
