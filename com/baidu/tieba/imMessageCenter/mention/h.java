package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h {
    private int eaD = 0;
    private int eaE = 0;
    private int eaF = 0;
    private int chat = 0;
    private int eaG = 0;

    public int aEK() {
        return this.eaD;
    }

    public int aEL() {
        return this.eaE;
    }

    public int aEM() {
        return this.eaF;
    }

    public int aEN() {
        return this.eaG;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eaD = jSONObject.optInt("replyme", 0);
                this.eaE = jSONObject.optInt("atme", 0);
                this.eaF = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.eaG = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
