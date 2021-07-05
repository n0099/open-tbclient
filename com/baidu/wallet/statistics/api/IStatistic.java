package com.baidu.wallet.statistics.api;

import java.util.Collection;
import java.util.Map;
/* loaded from: classes6.dex */
public interface IStatistic {
    void onEvent(String str);

    void onEvent(String str, String str2);

    void onEventEnd(String str, int i2);

    void onEventEnd(String str, int i2, String str2);

    void onEventEndWithValue(String str, int i2, String str2);

    void onEventEndWithValue(String str, int i2, String str2, String str3);

    void onEventEndWithValues(String str, int i2, Collection<String> collection);

    void onEventEndWithValues(String str, int i2, Collection<String> collection, String str2);

    void onEventEndWithValues(String str, int i2, Collection<String> collection, Map<String, Object> map);

    void onEventEndWithValues(String str, int i2, Collection<String> collection, Map<String, Object> map, String str2);

    void onEventStart(String str);

    void onEventWithValue(String str, String str2);

    void onEventWithValue(String str, String str2, String str3);

    void onEventWithValues(String str, Collection<String> collection);

    void onEventWithValues(String str, Collection<String> collection, String str2);

    void onEventWithValues(String str, Collection<String> collection, Map<String, Object> map);

    void onEventWithValues(String str, Collection<String> collection, Map<String, Object> map, String str2);

    void triggerSending();
}
