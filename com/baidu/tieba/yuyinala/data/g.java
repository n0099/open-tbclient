package com.baidu.tieba.yuyinala.data;

import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g {
    public int aGr;
    public long aGs;
    public long aGt;
    public long aGu;
    public boolean aGv;
    public long aGw;
    public String cover;
    public int live_status;
    public String room_name;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.room_name = jSONObject.optString(DpStatConstants.KEY_ROOM_NAME);
            this.cover = jSONObject.optString("cover");
            this.live_status = jSONObject.optInt("live_status");
            this.aGr = jSONObject.optInt("current_rank");
            this.aGs = jSONObject.optLong("current_charm_value");
            this.aGt = jSONObject.optLong("up_charm_value");
            this.aGu = jSONObject.optLong("down_charm_value");
        }
    }

    public String getNameShow() {
        return this.room_name;
    }

    public void bq(boolean z) {
        this.aGv = z;
    }

    public void an(long j) {
        this.aGw = j;
    }
}
