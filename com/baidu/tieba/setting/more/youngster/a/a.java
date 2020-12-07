package com.baidu.tieba.setting.more.youngster.a;

import org.json.JSONObject;
/* loaded from: classes26.dex */
public class a {
    public boolean isSuccess = false;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null && "ok".equals(jSONObject.optString("status"))) {
            this.isSuccess = true;
        }
    }
}
