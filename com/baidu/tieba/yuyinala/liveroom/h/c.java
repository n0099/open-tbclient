package com.baidu.tieba.yuyinala.liveroom.h;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
class c {
    boolean hGB = false;
    String date = "";
    int bsP = 0;
    int oxZ = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("hasShowMax", this.hGB);
            jSONObject.put("date", this.date);
            jSONObject.put("times", this.bsP);
            jSONObject.put("clickTimes", this.oxZ);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
