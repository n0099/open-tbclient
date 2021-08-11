package com.baidu.webkit.internal.monitor;

import com.baidu.webkit.internal.INoProGuard;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public interface IStatisticsTransmission extends INoProGuard {
    void onUbcEvent(String str, String str2, String str3, String str4, String str5, JSONObject jSONObject);
}
