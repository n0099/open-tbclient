package com.baidu.tieba.yuyinala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f {
    private long amount;
    private int gtX;

    public void parserJson(JSONObject jSONObject) {
        this.gtX = jSONObject.optInt("loot_result");
        this.amount = jSONObject.optLong(LogConfig.LOG_AMOUNT);
    }

    public boolean bPi() {
        return this.gtX == 1;
    }

    public long bPj() {
        return this.amount;
    }
}
