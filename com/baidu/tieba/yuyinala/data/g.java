package com.baidu.tieba.yuyinala.data;

import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g {
    public int aHl;
    public long aHm;
    public long aHn;
    public long aHo;
    public boolean aHp;
    public long aHq;
    public String cover;
    public int live_status;
    public String room_name;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.room_name = jSONObject.optString(DpStatConstants.KEY_ROOM_NAME);
            this.cover = jSONObject.optString("cover");
            this.live_status = jSONObject.optInt("live_status");
            this.aHl = jSONObject.optInt("current_rank");
            this.aHm = jSONObject.optLong("current_charm_value");
            this.aHn = jSONObject.optLong("up_charm_value");
            this.aHo = jSONObject.optLong("down_charm_value");
        }
    }

    public String getNameShow() {
        return this.room_name;
    }

    public void bn(boolean z) {
        this.aHp = z;
    }

    public void ab(long j) {
        this.aHq = j;
    }
}
