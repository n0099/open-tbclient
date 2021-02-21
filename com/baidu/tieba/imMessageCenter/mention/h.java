package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h {
    private int kSb = 0;
    private int kSc = 0;
    private int kSd = 0;
    private int fans = 0;
    private int chat = 0;
    private int kSe = 0;

    public int cZs() {
        return this.kSb;
    }

    public int cZt() {
        return this.kSc;
    }

    public int cZu() {
        return this.kSd;
    }

    public int cZv() {
        return this.fans;
    }

    public int cZw() {
        return this.kSe;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.kSb = jSONObject.optInt("agree", 0);
                this.kSc = jSONObject.optInt("replyme", 0);
                this.kSd = jSONObject.optInt("atme", 0);
                this.fans = jSONObject.optInt("fans", 0);
                this.chat = jSONObject.optInt("pletter", 0);
                this.kSe = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
