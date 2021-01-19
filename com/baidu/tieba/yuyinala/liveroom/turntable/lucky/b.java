package com.baidu.tieba.yuyinala.liveroom.turntable.lucky;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    public long aFE;
    public long expiredTime;
    public int hKF;
    public a oss;

    public b(JSONObject jSONObject) {
        parseJson(jSONObject);
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hKF = jSONObject.optInt("is_lucky_moment");
            this.aFE = jSONObject.optLong("current_time");
            this.expiredTime = jSONObject.optLong("expired_time");
            this.oss = new a(jSONObject.optJSONObject("lucky_gift_info"));
        }
    }

    /* loaded from: classes10.dex */
    public class a {
        public String giftName;
        public String hKH;

        public a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.giftName = jSONObject.optString("gift_name");
                this.hKH = jSONObject.optString("pro_up_ratio");
            }
        }
    }
}
