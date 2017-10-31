package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h {
    private int dRC = 0;
    private int dRD = 0;
    private int dRE = 0;
    private int chat = 0;
    private int dRF = 0;

    public int aCX() {
        return this.dRC;
    }

    public int aCY() {
        return this.dRD;
    }

    public int aCZ() {
        return this.dRE;
    }

    public int aDa() {
        return this.dRF;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dRC = jSONObject.optInt("replyme", 0);
                this.dRD = jSONObject.optInt("atme", 0);
                this.dRE = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.dRF = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
