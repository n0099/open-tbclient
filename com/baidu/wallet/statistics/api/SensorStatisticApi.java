package com.baidu.wallet.statistics.api;

import d.d.a.a.b.d;
import java.util.Collection;
import java.util.Map;
/* loaded from: classes5.dex */
public class SensorStatisticApi extends StatisticDecorate {

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static SensorStatisticApi f26665a = new SensorStatisticApi();
    }

    public static SensorStatisticApi getInstance() {
        return a.f26665a;
    }

    @Override // com.baidu.wallet.statistics.api.StatisticDecorate, com.baidu.wallet.statistics.api.IStatistic
    public void onEvent(String str) {
        super.onEvent(str);
        d.d.a.a.a.onEvent(str);
    }

    @Override // com.baidu.wallet.statistics.api.StatisticDecorate, com.baidu.wallet.statistics.api.IStatistic
    public void onEventEnd(String str, int i2) {
        super.onEventEnd(str, i2);
        d.d.a.a.a.i(str, i2);
    }

    @Override // com.baidu.wallet.statistics.api.StatisticDecorate, com.baidu.wallet.statistics.api.IStatistic
    public void onEventEndWithValue(String str, int i2, String str2) {
        super.onEventEndWithValue(str, i2, str2);
        d.d.a.a.a.k(str, i2, str2);
    }

    @Override // com.baidu.wallet.statistics.api.StatisticDecorate, com.baidu.wallet.statistics.api.IStatistic
    public void onEventEndWithValues(String str, int i2, Collection<String> collection) {
        super.onEventEndWithValues(str, i2, collection);
        d.d.a.a.a.m(str, i2, collection);
    }

    @Override // com.baidu.wallet.statistics.api.StatisticDecorate, com.baidu.wallet.statistics.api.IStatistic
    public void onEventStart(String str) {
        super.onEventStart(str);
        d.d.a.a.a.q(str);
    }

    @Override // com.baidu.wallet.statistics.api.StatisticDecorate, com.baidu.wallet.statistics.api.IStatistic
    public void onEventWithValue(String str, String str2) {
        super.onEventWithValue(str, str2);
        d.d.a.a.a.r(str, str2);
    }

    @Override // com.baidu.wallet.statistics.api.StatisticDecorate, com.baidu.wallet.statistics.api.IStatistic
    public void onEventWithValues(String str, Collection<String> collection) {
        super.onEventWithValues(str, collection);
        d.d.a.a.a.t(str, collection);
    }

    @Override // com.baidu.wallet.statistics.api.StatisticDecorate, com.baidu.wallet.statistics.api.IStatistic
    public void triggerSending() {
        super.triggerSending();
        d.h().i("normal_log");
    }

    @Override // com.baidu.wallet.statistics.api.StatisticDecorate, com.baidu.wallet.statistics.api.IStatistic
    public void onEvent(String str, String str2) {
        super.onEvent(str, str2);
        d.d.a.a.a.h(str, str2);
    }

    @Override // com.baidu.wallet.statistics.api.StatisticDecorate, com.baidu.wallet.statistics.api.IStatistic
    public void onEventEnd(String str, int i2, String str2) {
        super.onEventEnd(str, i2, str2);
        d.d.a.a.a.j(str, i2, str2);
    }

    @Override // com.baidu.wallet.statistics.api.StatisticDecorate, com.baidu.wallet.statistics.api.IStatistic
    public void onEventEndWithValue(String str, int i2, String str2, String str3) {
        super.onEventEndWithValue(str, i2, str2, str3);
        d.d.a.a.a.l(str, i2, str2, str3);
    }

    @Override // com.baidu.wallet.statistics.api.StatisticDecorate, com.baidu.wallet.statistics.api.IStatistic
    public void onEventEndWithValues(String str, int i2, Collection<String> collection, Map<String, Object> map) {
        super.onEventEndWithValues(str, i2, collection, map);
        d.d.a.a.a.o(str, i2, collection, map);
    }

    @Override // com.baidu.wallet.statistics.api.StatisticDecorate, com.baidu.wallet.statistics.api.IStatistic
    public void onEventWithValue(String str, String str2, String str3) {
        super.onEventWithValue(str, str2, str3);
        d.d.a.a.a.s(str, str2, str3);
    }

    @Override // com.baidu.wallet.statistics.api.StatisticDecorate, com.baidu.wallet.statistics.api.IStatistic
    public void onEventWithValues(String str, Collection<String> collection, Map<String, Object> map) {
        super.onEventWithValues(str, collection, map);
        d.d.a.a.a.v(str, collection, map);
    }

    @Override // com.baidu.wallet.statistics.api.StatisticDecorate, com.baidu.wallet.statistics.api.IStatistic
    public void onEventEndWithValues(String str, int i2, Collection<String> collection, String str2) {
        super.onEventEndWithValues(str, i2, collection, str2);
        d.d.a.a.a.n(str, i2, collection, str2);
    }

    @Override // com.baidu.wallet.statistics.api.StatisticDecorate, com.baidu.wallet.statistics.api.IStatistic
    public void onEventWithValues(String str, Collection<String> collection, String str2) {
        super.onEventWithValues(str, collection, str2);
        d.d.a.a.a.u(str, collection, str2);
    }

    @Override // com.baidu.wallet.statistics.api.StatisticDecorate, com.baidu.wallet.statistics.api.IStatistic
    public void onEventEndWithValues(String str, int i2, Collection<String> collection, Map<String, Object> map, String str2) {
        super.onEventEndWithValues(str, i2, collection, map, str2);
        d.d.a.a.a.p(str, i2, collection, map, str2);
    }

    @Override // com.baidu.wallet.statistics.api.StatisticDecorate, com.baidu.wallet.statistics.api.IStatistic
    public void onEventWithValues(String str, Collection<String> collection, Map<String, Object> map, String str2) {
        super.onEventWithValues(str, collection, map, str2);
        d.d.a.a.a.w(str, collection, map, str2);
    }
}
