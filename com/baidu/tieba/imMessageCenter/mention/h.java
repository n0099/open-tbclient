package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h {
    private int dRG = 0;
    private int dRH = 0;
    private int dRI = 0;
    private int chat = 0;
    private int dRJ = 0;

    public int aDb() {
        return this.dRG;
    }

    public int aDc() {
        return this.dRH;
    }

    public int aDd() {
        return this.dRI;
    }

    public int aDe() {
        return this.dRJ;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dRG = jSONObject.optInt("replyme", 0);
                this.dRH = jSONObject.optInt("atme", 0);
                this.dRI = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.dRJ = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
