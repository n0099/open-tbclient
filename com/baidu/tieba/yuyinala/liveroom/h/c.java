package com.baidu.tieba.yuyinala.liveroom.h;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
class c {
    boolean hES = false;
    String date = "";
    int brp = 0;
    int ovU = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("hasShowMax", this.hES);
            jSONObject.put("date", this.date);
            jSONObject.put("times", this.brp);
            jSONObject.put("clickTimes", this.ovU);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
