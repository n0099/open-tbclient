package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h {
    private int eaz = 0;
    private int eaA = 0;
    private int eaB = 0;
    private int chat = 0;
    private int eaC = 0;

    public int aEK() {
        return this.eaz;
    }

    public int aEL() {
        return this.eaA;
    }

    public int aEM() {
        return this.eaB;
    }

    public int aEN() {
        return this.eaC;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eaz = jSONObject.optInt("replyme", 0);
                this.eaA = jSONObject.optInt("atme", 0);
                this.eaB = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.eaC = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
