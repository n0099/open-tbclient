package com.baidu.tieba.yuyinala.data;

import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class g {
    public int aEL;
    public long aEM;
    public long aEN;
    public long aEO;
    public boolean aEP;
    public long aEQ;
    public String cover;
    public int live_status;
    public String room_name;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.room_name = jSONObject.optString(DpStatConstants.KEY_ROOM_NAME);
            this.cover = jSONObject.optString("cover");
            this.live_status = jSONObject.optInt("live_status");
            this.aEL = jSONObject.optInt("current_rank");
            this.aEM = jSONObject.optLong("current_charm_value");
            this.aEN = jSONObject.optLong("up_charm_value");
            this.aEO = jSONObject.optLong("down_charm_value");
        }
    }

    public String getNameShow() {
        return this.room_name;
    }

    public void br(boolean z) {
        this.aEP = z;
    }

    public void aK(long j) {
        this.aEQ = j;
    }
}
