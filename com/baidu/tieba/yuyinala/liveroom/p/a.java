package com.baidu.tieba.yuyinala.liveroom.p;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    int bsP;
    String date;
    String uid;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a eR(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        this.uid = jSONObject.optString("uid");
        this.date = jSONObject.optString("date");
        this.bsP = jSONObject.optInt("times");
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uid", this.uid);
            jSONObject.put("date", this.date);
            jSONObject.put("times", this.bsP);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
