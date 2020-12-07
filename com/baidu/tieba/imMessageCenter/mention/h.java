package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes22.dex */
public class h {
    private int kJe = 0;
    private int kJf = 0;
    private int kJg = 0;
    private int fans = 0;
    private int chat = 0;
    private int kJh = 0;

    public int dbA() {
        return this.kJe;
    }

    public int dbB() {
        return this.kJf;
    }

    public int dbC() {
        return this.kJg;
    }

    public int dbD() {
        return this.fans;
    }

    public int dbE() {
        return this.kJh;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.kJe = jSONObject.optInt("agree", 0);
                this.kJf = jSONObject.optInt("replyme", 0);
                this.kJg = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.kJh = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
