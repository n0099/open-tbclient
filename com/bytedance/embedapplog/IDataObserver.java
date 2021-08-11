package com.bytedance.embedapplog;

import org.json.JSONObject;
/* loaded from: classes9.dex */
public interface IDataObserver {
    void onIdLoaded(String str, String str2, String str3);

    void onRemoteAbConfigGet(boolean z, JSONObject jSONObject);

    void onRemoteConfigGet(boolean z, JSONObject jSONObject);

    void onRemoteIdGet(boolean z, String str, String str2, String str3, String str4, String str5, String str6);
}
