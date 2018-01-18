package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h {
    private int eOf = 0;
    private int eOg = 0;
    private int eOh = 0;
    private int chat = 0;
    private int eOi = 0;

    public int aLQ() {
        return this.eOf;
    }

    public int aLR() {
        return this.eOg;
    }

    public int aLS() {
        return this.eOh;
    }

    public int aLT() {
        return this.eOi;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eOf = jSONObject.optInt("replyme", 0);
                this.eOg = jSONObject.optInt("atme", 0);
                this.eOh = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.eOi = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
