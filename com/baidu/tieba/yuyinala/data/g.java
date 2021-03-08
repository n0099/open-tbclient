package com.baidu.tieba.yuyinala.data;

import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class g {
    public int aHY;
    public long aHZ;
    public long aIa;
    public long aIb;
    public boolean aIc;
    public long aId;
    public String cover;
    public int live_status;
    public String room_name;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.room_name = jSONObject.optString(DpStatConstants.KEY_ROOM_NAME);
            this.cover = jSONObject.optString("cover");
            this.live_status = jSONObject.optInt("live_status");
            this.aHY = jSONObject.optInt("current_rank");
            this.aHZ = jSONObject.optLong("current_charm_value");
            this.aIa = jSONObject.optLong("up_charm_value");
            this.aIb = jSONObject.optLong("down_charm_value");
        }
    }

    public String getNameShow() {
        return this.room_name;
    }

    public void bt(boolean z) {
        this.aIc = z;
    }

    public void aM(long j) {
        this.aId = j;
    }
}
