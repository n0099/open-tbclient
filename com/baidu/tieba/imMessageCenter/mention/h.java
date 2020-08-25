package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes16.dex */
public class h {
    private int jEZ = 0;
    private int jFa = 0;
    private int jFb = 0;
    private int fans = 0;
    private int chat = 0;
    private int jFc = 0;

    public int cJL() {
        return this.jEZ;
    }

    public int cJM() {
        return this.jFa;
    }

    public int cJN() {
        return this.jFb;
    }

    public int cJO() {
        return this.fans;
    }

    public int cJP() {
        return this.jFc;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.jEZ = jSONObject.optInt("agree", 0);
                this.jFa = jSONObject.optInt("replyme", 0);
                this.jFb = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.jFc = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
