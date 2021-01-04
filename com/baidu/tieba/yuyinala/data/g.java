package com.baidu.tieba.yuyinala.data;

import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class g {
    public long aJA;
    public long aJB;
    public boolean aJC;
    public long aJD;
    public int aJy;
    public long aJz;
    public String cover;
    public int live_status;
    public String room_name;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.room_name = jSONObject.optString(DpStatConstants.KEY_ROOM_NAME);
            this.cover = jSONObject.optString("cover");
            this.live_status = jSONObject.optInt("live_status");
            this.aJy = jSONObject.optInt("current_rank");
            this.aJz = jSONObject.optLong("current_charm_value");
            this.aJA = jSONObject.optLong("up_charm_value");
            this.aJB = jSONObject.optLong("down_charm_value");
        }
    }

    public String getNameShow() {
        return this.room_name;
    }

    public void bv(boolean z) {
        this.aJC = z;
    }

    public void aK(long j) {
        this.aJD = j;
    }
}
