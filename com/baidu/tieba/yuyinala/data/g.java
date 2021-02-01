package com.baidu.tieba.yuyinala.data;

import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class g {
    public long aGA;
    public long aGB;
    public boolean aGC;
    public long aGD;
    public int aGy;
    public long aGz;
    public String cover;
    public int live_status;
    public String room_name;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.room_name = jSONObject.optString(DpStatConstants.KEY_ROOM_NAME);
            this.cover = jSONObject.optString("cover");
            this.live_status = jSONObject.optInt("live_status");
            this.aGy = jSONObject.optInt("current_rank");
            this.aGz = jSONObject.optLong("current_charm_value");
            this.aGA = jSONObject.optLong("up_charm_value");
            this.aGB = jSONObject.optLong("down_charm_value");
        }
    }

    public String getNameShow() {
        return this.room_name;
    }

    public void bt(boolean z) {
        this.aGC = z;
    }

    public void aM(long j) {
        this.aGD = j;
    }
}
