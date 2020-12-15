package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes22.dex */
public class h {
    private int kJg = 0;
    private int kJh = 0;
    private int kJi = 0;
    private int fans = 0;
    private int chat = 0;
    private int kJj = 0;

    public int dbB() {
        return this.kJg;
    }

    public int dbC() {
        return this.kJh;
    }

    public int dbD() {
        return this.kJi;
    }

    public int dbE() {
        return this.fans;
    }

    public int dbF() {
        return this.kJj;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.kJg = jSONObject.optInt("agree", 0);
                this.kJh = jSONObject.optInt("replyme", 0);
                this.kJi = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.kJj = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
