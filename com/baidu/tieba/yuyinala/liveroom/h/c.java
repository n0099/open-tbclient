package com.baidu.tieba.yuyinala.liveroom.h;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
class c {
    boolean hAu = false;
    String date = "";
    int bnO = 0;
    int olC = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("hasShowMax", this.hAu);
            jSONObject.put("date", this.date);
            jSONObject.put("times", this.bnO);
            jSONObject.put("clickTimes", this.olC);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
