package com.baidu.tieba.yuyinala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f {
    private long amount;
    private int gIo;

    public void parserJson(JSONObject jSONObject) {
        this.gIo = jSONObject.optInt("loot_result");
        this.amount = jSONObject.optLong(LogConfig.LOG_AMOUNT);
    }

    public boolean bUL() {
        return this.gIo == 1;
    }

    public long bUM() {
        return this.amount;
    }
}
