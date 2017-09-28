package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h {
    private int dKd = 0;
    private int dKe = 0;
    private int dKf = 0;
    private int chat = 0;
    private int dKg = 0;

    public int aAH() {
        return this.dKd;
    }

    public int aAI() {
        return this.dKe;
    }

    public int aAJ() {
        return this.dKf;
    }

    public int aAK() {
        return this.dKg;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dKd = jSONObject.optInt("replyme", 0);
                this.dKe = jSONObject.optInt("atme", 0);
                this.dKf = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.dKg = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
