package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h {
    private int eWt = 0;
    private int eWu = 0;
    private int eWv = 0;
    private int fans = 0;
    private int chat = 0;
    private int eWw = 0;

    public int aUA() {
        return this.eWt;
    }

    public int aUB() {
        return this.eWu;
    }

    public int aUC() {
        return this.eWv;
    }

    public int aUD() {
        return this.fans;
    }

    public int aUE() {
        return this.eWw;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eWt = jSONObject.optInt("agree", 0);
                this.eWu = jSONObject.optInt("replyme", 0);
                this.eWv = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.eWw = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
