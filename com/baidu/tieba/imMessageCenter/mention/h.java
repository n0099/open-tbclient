package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes22.dex */
public class h {
    private int kva = 0;
    private int kvb = 0;
    private int kvc = 0;
    private int fans = 0;
    private int chat = 0;
    private int kvd = 0;

    public int cWI() {
        return this.kva;
    }

    public int cWJ() {
        return this.kvb;
    }

    public int cWK() {
        return this.kvc;
    }

    public int cWL() {
        return this.fans;
    }

    public int cWM() {
        return this.kvd;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.kva = jSONObject.optInt("agree", 0);
                this.kvb = jSONObject.optInt("replyme", 0);
                this.kvc = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.kvd = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
