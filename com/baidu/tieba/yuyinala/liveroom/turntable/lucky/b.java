package com.baidu.tieba.yuyinala.liveroom.turntable.lucky;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    public long aIa;
    public long expiredTime;
    public int hPn;
    public a oCD;

    public b(JSONObject jSONObject) {
        parseJson(jSONObject);
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hPn = jSONObject.optInt("is_lucky_moment");
            this.aIa = jSONObject.optLong("current_time");
            this.expiredTime = jSONObject.optLong("expired_time");
            this.oCD = new a(jSONObject.optJSONObject("lucky_gift_info"));
        }
    }

    /* loaded from: classes11.dex */
    public class a {
        public String giftName;
        public String hPp;

        public a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.giftName = jSONObject.optString("gift_name");
                this.hPp = jSONObject.optString("pro_up_ratio");
            }
        }
    }
}
