package com.baidu.tieba.yuyinala.liveroom.h;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
class c {
    boolean hFa = false;
    String date = "";
    int bsA = 0;
    int oqi = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("hasShowMax", this.hFa);
            jSONObject.put("date", this.date);
            jSONObject.put("times", this.bsA);
            jSONObject.put("clickTimes", this.oqi);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
