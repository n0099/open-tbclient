package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h {
    private int eMG = 0;
    private int eMH = 0;
    private int eMI = 0;
    private int chat = 0;
    private int eMJ = 0;

    public int aLL() {
        return this.eMG;
    }

    public int aLM() {
        return this.eMH;
    }

    public int aLN() {
        return this.eMI;
    }

    public int aLO() {
        return this.eMJ;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eMG = jSONObject.optInt("replyme", 0);
                this.eMH = jSONObject.optInt("atme", 0);
                this.eMI = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.eMJ = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
