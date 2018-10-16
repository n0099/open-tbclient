package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h {
    private int eWs = 0;
    private int eWt = 0;
    private int eWu = 0;
    private int fans = 0;
    private int chat = 0;
    private int eWv = 0;

    public int aUA() {
        return this.eWs;
    }

    public int aUB() {
        return this.eWt;
    }

    public int aUC() {
        return this.eWu;
    }

    public int aUD() {
        return this.fans;
    }

    public int aUE() {
        return this.eWv;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eWs = jSONObject.optInt("agree", 0);
                this.eWt = jSONObject.optInt("replyme", 0);
                this.eWu = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.eWv = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
