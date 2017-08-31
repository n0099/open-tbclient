package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h {
    private int dMR = 0;
    private int dMS = 0;
    private int dMT = 0;
    private int chat = 0;
    private int dMU = 0;

    public int aBL() {
        return this.dMR;
    }

    public int aBM() {
        return this.dMS;
    }

    public int aBN() {
        return this.dMT;
    }

    public int aBO() {
        return this.dMU;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dMR = jSONObject.optInt("replyme", 0);
                this.dMS = jSONObject.optInt("atme", 0);
                this.dMT = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.dMU = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
