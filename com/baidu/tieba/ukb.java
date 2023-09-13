package com.baidu.tieba;

import org.json.JSONObject;
/* loaded from: classes8.dex */
public interface ukb {
    String getBizType();

    void onReceiveResult(boolean z, String str, String str2, JSONObject jSONObject, JSONObject jSONObject2);
}
