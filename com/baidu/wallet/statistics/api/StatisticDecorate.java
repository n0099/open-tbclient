package com.baidu.wallet.statistics.api;

import java.util.Collection;
import java.util.Map;
/* loaded from: classes5.dex */
public class StatisticDecorate implements IStatistic {

    /* renamed from: a  reason: collision with root package name */
    public IStatistic f26666a;

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEvent(String str) {
        IStatistic iStatistic = this.f26666a;
        if (iStatistic != null) {
            iStatistic.onEvent(str);
        }
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventEnd(String str, int i2) {
        IStatistic iStatistic = this.f26666a;
        if (iStatistic != null) {
            iStatistic.onEventEnd(str, i2);
        }
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventEndWithValue(String str, int i2, String str2) {
        IStatistic iStatistic = this.f26666a;
        if (iStatistic != null) {
            iStatistic.onEventEndWithValue(str, i2, str2);
        }
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventEndWithValues(String str, int i2, Collection<String> collection) {
        IStatistic iStatistic = this.f26666a;
        if (iStatistic != null) {
            iStatistic.onEventEndWithValues(str, i2, collection);
        }
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventStart(String str) {
        IStatistic iStatistic = this.f26666a;
        if (iStatistic != null) {
            iStatistic.onEventStart(str);
        }
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventWithValue(String str, String str2) {
        IStatistic iStatistic = this.f26666a;
        if (iStatistic != null) {
            iStatistic.onEventWithValue(str, str2);
        }
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventWithValues(String str, Collection<String> collection) {
        IStatistic iStatistic = this.f26666a;
        if (iStatistic != null) {
            iStatistic.onEventWithValues(str, collection);
        }
    }

    public void setStatistic(IStatistic iStatistic) {
        this.f26666a = iStatistic;
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void triggerSending() {
        IStatistic iStatistic = this.f26666a;
        if (iStatistic != null) {
            iStatistic.triggerSending();
        }
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEvent(String str, String str2) {
        IStatistic iStatistic = this.f26666a;
        if (iStatistic != null) {
            iStatistic.onEvent(str, str2);
        }
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventEnd(String str, int i2, String str2) {
        IStatistic iStatistic = this.f26666a;
        if (iStatistic != null) {
            iStatistic.onEventEnd(str, i2, str2);
        }
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventEndWithValue(String str, int i2, String str2, String str3) {
        IStatistic iStatistic = this.f26666a;
        if (iStatistic != null) {
            iStatistic.onEventEndWithValue(str, i2, str2, str3);
        }
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventEndWithValues(String str, int i2, Collection<String> collection, Map<String, Object> map) {
        IStatistic iStatistic = this.f26666a;
        if (iStatistic != null) {
            iStatistic.onEventEndWithValues(str, i2, collection, map);
        }
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventWithValue(String str, String str2, String str3) {
        IStatistic iStatistic = this.f26666a;
        if (iStatistic != null) {
            iStatistic.onEventWithValue(str, str2, str3);
        }
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventWithValues(String str, Collection<String> collection, Map<String, Object> map) {
        IStatistic iStatistic = this.f26666a;
        if (iStatistic != null) {
            iStatistic.onEventWithValues(str, collection, map);
        }
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventEndWithValues(String str, int i2, Collection<String> collection, String str2) {
        IStatistic iStatistic = this.f26666a;
        if (iStatistic != null) {
            iStatistic.onEventEndWithValues(str, i2, collection, str2);
        }
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventWithValues(String str, Collection<String> collection, String str2) {
        IStatistic iStatistic = this.f26666a;
        if (iStatistic != null) {
            iStatistic.onEventWithValues(str, collection, str2);
        }
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventEndWithValues(String str, int i2, Collection<String> collection, Map<String, Object> map, String str2) {
        IStatistic iStatistic = this.f26666a;
        if (iStatistic != null) {
            iStatistic.onEventEndWithValues(str, i2, collection, map, str2);
        }
    }

    @Override // com.baidu.wallet.statistics.api.IStatistic
    public void onEventWithValues(String str, Collection<String> collection, Map<String, Object> map, String str2) {
        IStatistic iStatistic = this.f26666a;
        if (iStatistic != null) {
            iStatistic.onEventWithValues(str, collection, map, str2);
        }
    }
}
