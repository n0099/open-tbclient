package com.baidu.tieba;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public interface mib {
    String getBizType();

    void onReceiveResult(boolean z, String str, String str2, JSONObject jSONObject, JSONObject jSONObject2);
}
