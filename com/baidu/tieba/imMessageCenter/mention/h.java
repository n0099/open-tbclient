package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h {
    private int dJP = 0;
    private int dJQ = 0;
    private int dJR = 0;
    private int chat = 0;
    private int dJS = 0;

    public int aAC() {
        return this.dJP;
    }

    public int aAD() {
        return this.dJQ;
    }

    public int aAE() {
        return this.dJR;
    }

    public int aAF() {
        return this.dJS;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dJP = jSONObject.optInt("replyme", 0);
                this.dJQ = jSONObject.optInt("atme", 0);
                this.dJR = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.dJS = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
