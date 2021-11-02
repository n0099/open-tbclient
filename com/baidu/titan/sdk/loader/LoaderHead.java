package com.baidu.titan.sdk.loader;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class LoaderHead {
    public static final String KEY_PATCH_HASH = "patchHash";
    public static final String KEY_TARGET_ID = "targetId";
    public String patchHash;
    public String targetId;

    public static LoaderHead createFromJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            LoaderHead loaderHead = new LoaderHead();
            loaderHead.patchHash = jSONObject.getString(KEY_PATCH_HASH);
            loaderHead.targetId = jSONObject.getString("targetId");
            return loaderHead;
        } catch (Exception unused) {
            return null;
        }
    }

    public String toJsonString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(KEY_PATCH_HASH, this.patchHash);
            jSONObject.put("targetId", this.targetId);
            return jSONObject.toString();
        } catch (Exception unused) {
            return null;
        }
    }
}
