package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class h {
    private int jhk = 0;
    private int jhl = 0;
    private int jhm = 0;
    private int fans = 0;
    private int chat = 0;
    private int jhn = 0;

    public int cuU() {
        return this.jhk;
    }

    public int cuV() {
        return this.jhl;
    }

    public int cuW() {
        return this.jhm;
    }

    public int cuX() {
        return this.fans;
    }

    public int cuY() {
        return this.jhn;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.jhk = jSONObject.optInt("agree", 0);
                this.jhl = jSONObject.optInt("replyme", 0);
                this.jhm = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.jhn = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
