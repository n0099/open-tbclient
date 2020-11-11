package com.baidu.tieba.yuyinala.data;

import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g {
    public int aIc;
    public long aId;
    public long aIe;
    public long aIf;
    public boolean aIg;
    public long aIh;
    public String cover;
    public int live_status;
    public String room_name;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.room_name = jSONObject.optString(DpStatConstants.KEY_ROOM_NAME);
            this.cover = jSONObject.optString("cover");
            this.live_status = jSONObject.optInt("live_status");
            this.aIc = jSONObject.optInt("current_rank");
            this.aId = jSONObject.optLong("current_charm_value");
            this.aIe = jSONObject.optLong("up_charm_value");
            this.aIf = jSONObject.optLong("down_charm_value");
        }
    }

    public String getNameShow() {
        return this.room_name;
    }

    public void bo(boolean z) {
        this.aIg = z;
    }

    public void an(long j) {
        this.aIh = j;
    }
}
