package com.baidu.tieba.yuyinala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class f {
    private long amount;
    private int gUc;

    public void parserJson(JSONObject jSONObject) {
        this.gUc = jSONObject.optInt("loot_result");
        this.amount = jSONObject.optLong(LogConfig.LOG_AMOUNT);
    }

    public boolean bUr() {
        return this.gUc == 1;
    }

    public long bUs() {
        return this.amount;
    }
}
