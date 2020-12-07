package com.baidu.tieba.yuyinala.data;

import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g {
    public int aJa;
    public long aJb;
    public long aJc;
    public long aJd;
    public boolean aJe;
    public long aJf;
    public String cover;
    public int live_status;
    public String room_name;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.room_name = jSONObject.optString(DpStatConstants.KEY_ROOM_NAME);
            this.cover = jSONObject.optString("cover");
            this.live_status = jSONObject.optInt("live_status");
            this.aJa = jSONObject.optInt("current_rank");
            this.aJb = jSONObject.optLong("current_charm_value");
            this.aJc = jSONObject.optLong("up_charm_value");
            this.aJd = jSONObject.optLong("down_charm_value");
        }
    }

    public String getNameShow() {
        return this.room_name;
    }

    public void by(boolean z) {
        this.aJe = z;
    }

    public void aL(long j) {
        this.aJf = j;
    }
}
