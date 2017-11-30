package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h {
    private int dZu = 0;
    private int dZv = 0;
    private int dZw = 0;
    private int chat = 0;
    private int dZx = 0;

    public int aEB() {
        return this.dZu;
    }

    public int aEC() {
        return this.dZv;
    }

    public int aED() {
        return this.dZw;
    }

    public int aEE() {
        return this.dZx;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dZu = jSONObject.optInt("replyme", 0);
                this.dZv = jSONObject.optInt("atme", 0);
                this.dZw = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.dZx = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
