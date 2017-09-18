package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h {
    private int dNL = 0;
    private int dNM = 0;
    private int dNN = 0;
    private int chat = 0;
    private int dNO = 0;

    public int aBW() {
        return this.dNL;
    }

    public int aBX() {
        return this.dNM;
    }

    public int aBY() {
        return this.dNN;
    }

    public int aBZ() {
        return this.dNO;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dNL = jSONObject.optInt("replyme", 0);
                this.dNM = jSONObject.optInt("atme", 0);
                this.dNN = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.dNO = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
