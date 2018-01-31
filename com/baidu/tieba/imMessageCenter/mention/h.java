package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h {
    private int eOA = 0;
    private int eOB = 0;
    private int eOC = 0;
    private int chat = 0;
    private int eOD = 0;

    public int aLV() {
        return this.eOA;
    }

    public int aLW() {
        return this.eOB;
    }

    public int aLX() {
        return this.eOC;
    }

    public int aLY() {
        return this.eOD;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eOA = jSONObject.optInt("replyme", 0);
                this.eOB = jSONObject.optInt("atme", 0);
                this.eOC = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.eOD = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
