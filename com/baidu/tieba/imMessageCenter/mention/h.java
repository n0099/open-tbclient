package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h {
    private int kJK = 0;
    private int kJL = 0;
    private int kJM = 0;
    private int fans = 0;
    private int chat = 0;
    private int kJN = 0;

    public int cXn() {
        return this.kJK;
    }

    public int cXo() {
        return this.kJL;
    }

    public int cXp() {
        return this.kJM;
    }

    public int cXq() {
        return this.fans;
    }

    public int cXr() {
        return this.kJN;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.kJK = jSONObject.optInt("agree", 0);
                this.kJL = jSONObject.optInt("replyme", 0);
                this.kJM = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.kJN = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
