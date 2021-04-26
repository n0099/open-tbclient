package com.baidu.wallet.statistics.api;

import com.baidu.apollon.statistics.LogSender;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import java.util.Collection;
import java.util.Map;
/* loaded from: classes5.dex */
public class PMStatisticApi implements IStatistic {
    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEvent(String str) {
        PayStatisticsUtil.onEvent(str);
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventEnd(String str, int i2) {
        PayStatisticsUtil.onEventEnd(str, i2);
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventEndWithValue(String str, int i2, String str2) {
        PayStatisticsUtil.onEventEndWithValue(str, i2, str2);
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventEndWithValues(String str, int i2, Collection<String> collection) {
        PayStatisticsUtil.onEventEndWithValues(str, i2, collection);
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventEndWithValues(String str, int i2, Collection<String> collection, Map<String, Object> map) {
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventEndWithValues(String str, int i2, Collection<String> collection, Map<String, Object> map, String str2) {
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventStart(String str) {
        PayStatisticsUtil.onEventStart(str);
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventWithValue(String str, String str2) {
        PayStatisticsUtil.onEventWithValue(str, str2);
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventWithValues(String str, Collection<String> collection) {
        PayStatisticsUtil.onEventWithValues(str, collection);
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventWithValues(String str, Collection<String> collection, Map<String, Object> map) {
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventWithValues(String str, Collection<String> collection, Map<String, Object> map, String str2) {
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void triggerSending() {
        LogSender.getInstance().triggerSending("normal_log");
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEvent(String str, String str2) {
        PayStatisticsUtil.onEvent(str, str2);
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventEnd(String str, int i2, String str2) {
        PayStatisticsUtil.onEventEnd(str, i2, str2);
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventEndWithValue(String str, int i2, String str2, String str3) {
        PayStatisticsUtil.onEventEndWithValue(str, i2, str2, str3);
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventEndWithValues(String str, int i2, Collection<String> collection, String str2) {
        PayStatisticsUtil.onEventEndWithValues(str, i2, collection, str2);
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventWithValue(String str, String str2, String str3) {
        PayStatisticsUtil.onEventWithValue(str, str2, str3);
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventWithValues(String str, Collection<String> collection, String str2) {
        PayStatisticsUtil.onEventWithValues(str, collection, str2);
    }
}
