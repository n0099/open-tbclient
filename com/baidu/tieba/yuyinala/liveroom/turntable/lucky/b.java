package com.baidu.tieba.yuyinala.liveroom.turntable.lucky;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public long aJS;
    public int hDk;
    public long hDl;
    public a oqV;

    public b(JSONObject jSONObject) {
        parseJson(jSONObject);
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hDk = jSONObject.optInt("is_lucky_moment");
            this.aJS = jSONObject.optLong("current_time");
            this.hDl = jSONObject.optLong("expired_time");
            this.oqV = new a(jSONObject.optJSONObject("lucky_gift_info"));
        }
    }

    /* loaded from: classes4.dex */
    public class a {
        public String giftName;
        public String hDn;

        public a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.giftName = jSONObject.optString("gift_name");
                this.hDn = jSONObject.optString("pro_up_ratio");
            }
        }
    }
}
