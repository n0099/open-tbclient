package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class h {
    private int iAH = 0;
    private int iAI = 0;
    private int iAJ = 0;
    private int fans = 0;
    private int chat = 0;
    private int iAK = 0;

    public int ckv() {
        return this.iAH;
    }

    public int ckw() {
        return this.iAI;
    }

    public int ckx() {
        return this.iAJ;
    }

    public int cky() {
        return this.fans;
    }

    public int ckz() {
        return this.iAK;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.iAH = jSONObject.optInt("agree", 0);
                this.iAI = jSONObject.optInt("replyme", 0);
                this.iAJ = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.iAK = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
