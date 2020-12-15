package com.baidu.tieba.yuyinala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f {
    private long amount;
    private int gIq;

    public void parserJson(JSONObject jSONObject) {
        this.gIq = jSONObject.optInt("loot_result");
        this.amount = jSONObject.optLong(LogConfig.LOG_AMOUNT);
    }

    public boolean bUM() {
        return this.gIq == 1;
    }

    public long bUN() {
        return this.amount;
    }
}
