package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class h {
    private int iAB = 0;
    private int iAC = 0;
    private int iAD = 0;
    private int fans = 0;
    private int chat = 0;
    private int iAE = 0;

    public int ckx() {
        return this.iAB;
    }

    public int cky() {
        return this.iAC;
    }

    public int ckz() {
        return this.iAD;
    }

    public int ckA() {
        return this.fans;
    }

    public int ckB() {
        return this.iAE;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.iAB = jSONObject.optInt("agree", 0);
                this.iAC = jSONObject.optInt("replyme", 0);
                this.iAD = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.iAE = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
